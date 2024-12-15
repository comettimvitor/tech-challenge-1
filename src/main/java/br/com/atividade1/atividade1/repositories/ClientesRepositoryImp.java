package br.com.atividade1.atividade1.repositories;

import br.com.atividade1.atividade1.entities.Clientes;
import br.com.atividade1.atividade1.enums.TipoUsuario;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class ClientesRepositoryImp extends UsuariosRepositoryImp implements ClientesRepository{

    private final JdbcClient jdbcClient;

    public ClientesRepositoryImp(JdbcClient jdbcClient) {
        super(jdbcClient);
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Integer salvarCliente(Clientes clientes) {
        Long idUsuario = salvarUsuario(clientes, TipoUsuario.CLIENTE.getDescricao());

        String insereCliente = "INSERT INTO clientes(id_usuario, rua, bairro, numero, cep, complemento) VALUES(:id_usuario, :rua, :bairro, :numero, :cep, :complemento);";

        return this.jdbcClient.sql(insereCliente)
                .param("id_usuario", idUsuario)
                .param("rua", clientes.getRua())
                .param("bairro", clientes.getBairro())
                .param("numero", clientes.getNumero())
                .param("cep", clientes.getCep())
                .param("complemento", clientes.getComplemento())
                .update();
    }

    @Override
    public Integer alterarCliente(Clientes clientes, Long id) {
        alterarUsuario(clientes, id, TipoUsuario.CLIENTE.getDescricao());

        String alteraCliente = "UPDATE clientes SET rua = :rua, bairro = :bairro, numero = :numero, cep = :cep, complemento = :complemento WHERE id_usuario = :id_usuario;";

        return this.jdbcClient.sql(alteraCliente)
                .param("id_usuario", id)
                .param("rua", clientes.getRua())
                .param("bairro", clientes.getBairro())
                .param("numero", clientes.getNumero())
                .param("cep", clientes.getCep())
                .param("complemento", clientes.getComplemento())
                .update();
    }

    @Override
    public Integer deletarCliente(Long id) {
        String deletaCliente = "DELETE FROM clientes WHERE id_usuario = :id_usuario";

        this.jdbcClient.sql(deletaCliente)
                .param("id_usuario", id)
                .update();

        deletarUsuario(id);

        return 1;
    }

    @Override
    public Integer trocarSenhaCliente(Clientes clientes) {
        clientes.setTipoUsuario(TipoUsuario.CLIENTE.getDescricao());

        trocarSenha(clientes);

        return 1;
    }
}
