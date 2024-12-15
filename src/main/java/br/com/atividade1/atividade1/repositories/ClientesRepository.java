package br.com.atividade1.atividade1.repositories;

import br.com.atividade1.atividade1.entities.Clientes;

public interface ClientesRepository {
    Integer salvarCliente(Clientes clientes);
    Integer alterarCliente(Clientes clientes, Long id);
    Integer deletarCliente(Long id);
    Integer trocarSenhaCliente(Clientes clientes);
}
