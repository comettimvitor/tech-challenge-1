package br.com.atividade1.atividade1.repositories;

import br.com.atividade1.atividade1.entities.Clientes;
import br.com.atividade1.atividade1.entities.Usuarios;
import br.com.atividade1.atividade1.enums.TipoUsuario;

public interface UsuariosRepository {
    Long salvarUsuario(Usuarios usuarios, String tipoUsuario);
    Integer alterarUsuario(Usuarios usuarios, Long id, String tipoUsuario);
    Integer deletarUsuario(Long id);
    Integer trocarSenha(Usuarios usuarios);
    Integer login(String login, String senha);
}
