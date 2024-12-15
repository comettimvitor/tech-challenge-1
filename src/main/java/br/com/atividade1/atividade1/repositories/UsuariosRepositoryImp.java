package br.com.atividade1.atividade1.repositories;

import br.com.atividade1.atividade1.entities.Usuarios;
import br.com.atividade1.atividade1.services.exceptions.CadastroExistenteException;
import br.com.atividade1.atividade1.services.exceptions.ResourceNotFoundException;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class UsuariosRepositoryImp implements UsuariosRepository{

    private final JdbcClient jdbcClient;

    public UsuariosRepositoryImp(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Long salvarUsuario(Usuarios usuarios, String tipoUsuario) {
        Integer usuarioCadastrado = confereEmailTipoUsuario(usuarios.getEmail(), tipoUsuario);

        if(usuarioCadastrado == 1){
            throw new CadastroExistenteException("Já existe um usuário cadastrado com o email: " + usuarios.getEmail());
        }

        String insereUsuario = "INSERT INTO usuarios(nome, email, login, senha, ultima_alteracao, tipo_usuario) VALUES(:nome, :email, :login, :senha, CURRENT_DATE, :tipo_usuario) RETURNING id;";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.jdbcClient.sql(insereUsuario)
                .param("nome", usuarios.getNome())
                .param("email", usuarios.getEmail())
                .param("login", usuarios.getLogin())
                .param("senha", usuarios.getSenha())
                .param("tipo_usuario", tipoUsuario)
                .update(keyHolder);

        return keyHolder.getKey().longValue();
    }

    @Override
    public Integer alterarUsuario(Usuarios usuarios, Long id, String tipoUsuario) {
        Integer retornaUsuario = confereId(id);

        if(retornaUsuario == 0){
            throw new ResourceNotFoundException("O usuario com id: " + id + " nao foi encontrado...");
        }

        Integer usuarioCadastrado = confereEmailTipoUsuario(usuarios.getEmail(), tipoUsuario);

        if(usuarioCadastrado == 1){
            throw new CadastroExistenteException("Já existe um usuário cadastrado com o email: " + usuarios.getEmail());
        }

        String alteraUsuario = "UPDATE usuarios SET nome = :nome, email = :email, login = :login WHERE id = :id AND tipo_usuario = :tipo_usuario;";

        return this.jdbcClient.sql(alteraUsuario)
                .param("id", id)
                .param("nome", usuarios.getNome())
                .param("email", usuarios.getEmail())
                .param("login", usuarios.getLogin())
                .param("tipo_usuario", tipoUsuario)
                .update();
    }

    @Override
    public Integer deletarUsuario(Long id) {
        Integer retornaUsuario = confereId(id);

        if(retornaUsuario == 0){
            throw new ResourceNotFoundException("O usuario com id: " + id + " nao foi encontrado...");
        }

        String deletaUsuario = "DELETE FROM usuarios WHERE id = :id";

        return this.jdbcClient.sql(deletaUsuario)
                .param("id", id)
                .update();
    }

    @Override
    public Integer trocarSenha(Usuarios usuarios) {
        Integer usuarioCadastrado = confereEmailTipoUsuario(usuarios.getEmail(), usuarios.getTipoUsuario());

        if(usuarioCadastrado == 0){
            throw new ResourceNotFoundException("Usuario nao encontrado.");
        }

        String trocarSenha = "UPDATE usuarios SET senha = :senha, ultima_alteracao = CURRENT_DATE WHERE email = :email AND tipo_usuario = :tipo_usuario;";

        return this.jdbcClient.sql(trocarSenha)
                .param("email", usuarios.getEmail())
                .param("senha", usuarios.getSenha())
                .param("tipo_usuario", usuarios.getTipoUsuario())
                .update();
    }

    @Override
    public Integer login(String login, String senha) {
        String confereLogin = "SELECT COUNT(*) FROM usuarios WHERE login = :login and senha = :senha;";

        return this.jdbcClient.sql(confereLogin)
                .param("login", login)
                .param("senha", senha)
                .query(Integer.class)
                .single();
    }

    private Integer confereEmailTipoUsuario(String email, String tipoUsuario) {
        String confereCadastros = "SELECT COUNT(*) FROM usuarios WHERE email = :email AND tipo_usuario = :tipo_usuario";

        return this.jdbcClient.sql(confereCadastros)
                .param("email", email)
                .param("tipo_usuario", tipoUsuario)
                .query(Integer.class)
                .single();
    }

    private Integer confereId(Long id) {
        String confereCadastros = "SELECT COUNT(*) FROM usuarios WHERE id = :id";

        return this.jdbcClient.sql(confereCadastros)
                .param("id", id)
                .query(Integer.class)
                .single();
    }
}
