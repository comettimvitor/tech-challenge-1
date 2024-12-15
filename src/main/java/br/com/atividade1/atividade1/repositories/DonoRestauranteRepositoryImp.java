package br.com.atividade1.atividade1.repositories;

import br.com.atividade1.atividade1.entities.DonoRestaurante;
import br.com.atividade1.atividade1.enums.TipoUsuario;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class DonoRestauranteRepositoryImp extends UsuariosRepositoryImp implements DonoRestauranteRepository {

    private final JdbcClient jdbcClient;

    public DonoRestauranteRepositoryImp(JdbcClient jdbcClient) {
        super(jdbcClient);
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Integer salvarDonoRestaurante(DonoRestaurante donoRestaurante) {
        Long idUsuario = salvarUsuario(donoRestaurante, TipoUsuario.DONO_RESTAURANTE.getDescricao());

        String insereDonoRestaurante = "INSERT INTO dono_restaurante(id_usuario, nome_restaurante) VALUES(:id_usuario, :nome_restaurante);";

        return this.jdbcClient.sql(insereDonoRestaurante)
                .param("id_usuario", idUsuario)
                .param("nome_restaurante", donoRestaurante.getNomeRestaurante())
                .update();
    }

    @Override
    public Integer alterarDonoRestaurante(DonoRestaurante donoRestaurante, Long id) {
        alterarUsuario(donoRestaurante, id, donoRestaurante.getTipoUsuario());

        String alteraDonoRestaurante = "UPDATE dono_restaurante SET nome_restaurante = :nome_restaurante WHERE id_usuario = :id_usuario;";

        return this.jdbcClient.sql(alteraDonoRestaurante)
                .param("id_usuario", id)
                .param("nome_restaurante", donoRestaurante.getNomeRestaurante())
                .update();
    }

    @Override
    public Integer deletarDonoRestaurante(Long id) {
        String deletaDonoRestaurante = "DELETE FROM dono_restaurante WHERE id_usuario = :id_usuario;";

        this.jdbcClient.sql(deletaDonoRestaurante)
                .param("id_usuario", id)
                .update();

        deletarUsuario(id);

        return 1;
    }

    @Override
    public Integer trocarSenhaDonoRestaurante(DonoRestaurante donoRestaurante) {
        donoRestaurante.setTipoUsuario(TipoUsuario.DONO_RESTAURANTE.getDescricao());

        trocarSenha(donoRestaurante);

        return 1;
    }
}
