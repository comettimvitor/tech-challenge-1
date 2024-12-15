package br.com.atividade1.atividade1.services;

import br.com.atividade1.atividade1.dtos.TrocaSenhaDTO;
import br.com.atividade1.atividade1.dtos.composedDTO.UsuarioClienteDTO;
import br.com.atividade1.atividade1.entities.Clientes;
import br.com.atividade1.atividade1.repositories.ClientesRepository;
import br.com.atividade1.atividade1.services.exceptions.CadastroExistenteException;
import br.com.atividade1.atividade1.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    private final ClientesRepository clientesRepository;

    public ClientesService(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    public void salvarCliente(UsuarioClienteDTO usuarioClienteDTO) {
        var clienteEntity = retornaDadosCliente(usuarioClienteDTO);

        var salvar = this.clientesRepository.salvarCliente(clienteEntity);

        if(salvar == 0) {
            throw new CadastroExistenteException("Usuario ja cadastrado.");
        }

    }

    public void alterarCliente(UsuarioClienteDTO usuarioClienteDTO, Long id) {
        var clienteEntity = retornaDadosCliente(usuarioClienteDTO);

        var alterar = this.clientesRepository.alterarCliente(clienteEntity, id);

        if(alterar == 0) {
            throw new ResourceNotFoundException("ID de Usuario inexistente...");
        }
    }

    public void deletarCliente(Long id) {
        var deleta = this.clientesRepository.deletarCliente(id);

        if(deleta == 0) {
            throw new ResourceNotFoundException("Usuario inexistente...");
        }
    }

    public void trocarSenhaCliente(UsuarioClienteDTO usuarioClienteDTO) {

        var clienteEntity = retornaDadosTrocarSenha(usuarioClienteDTO.trocaSenhaDTO());

        var trocarSenha = this.clientesRepository.trocarSenhaCliente(clienteEntity);

        if(trocarSenha == 0) {
            throw new ResourceNotFoundException("ID de Usuario inexistente...");
        }
    }

    private Clientes retornaDadosCliente(UsuarioClienteDTO usuarioClienteDTO) {
        return new Clientes(usuarioClienteDTO);
    }

    private Clientes retornaDadosTrocarSenha(TrocaSenhaDTO trocaSenhaDTO) {
        return new Clientes(trocaSenhaDTO);
    }
}
