package br.com.atividade1.atividade1.services;

import br.com.atividade1.atividade1.dtos.TrocaSenhaDTO;
import br.com.atividade1.atividade1.dtos.composedDTO.UsuarioDonoRestauranteDTO;
import br.com.atividade1.atividade1.entities.Clientes;
import br.com.atividade1.atividade1.entities.DonoRestaurante;
import br.com.atividade1.atividade1.repositories.DonoRestauranteRepository;
import br.com.atividade1.atividade1.services.exceptions.CadastroExistenteException;
import br.com.atividade1.atividade1.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class DonoRestauranteService {

    private final DonoRestauranteRepository donoRestauranteRepository;

    public DonoRestauranteService(DonoRestauranteRepository donoRestauranteRepository) {
        this.donoRestauranteRepository = donoRestauranteRepository;
    }

    public void salvarDonoRestaurante(UsuarioDonoRestauranteDTO usuarioDonoRestauranteDTO) {
        var donoRestauranteEntity = retornaDadosDonoRestaurante(usuarioDonoRestauranteDTO);

        var salvar = this.donoRestauranteRepository.salvarDonoRestaurante(donoRestauranteEntity);

        if (salvar == 0) {
            throw new CadastroExistenteException("Usuario ja cadastrado.");
        }
    }

    public void alterarDonoRestaurante(UsuarioDonoRestauranteDTO usuarioDonoRestauranteDTO, Long id) {
        var donoRestauranteEntity = retornaDadosDonoRestaurante(usuarioDonoRestauranteDTO);

        var alterar = this.donoRestauranteRepository.alterarDonoRestaurante(donoRestauranteEntity, id);

        if (alterar == 0) {
            throw new ResourceNotFoundException("ID de Usuario inexistente...");
        }
    }

    public void deletarDonoRestaurante(Long id) {
        var deleta = this.donoRestauranteRepository.deletarDonoRestaurante(id);

        if (deleta == 0) {
            throw new ResourceNotFoundException("id de Usuario inexistente...");
        }
    }

    public void trocarSenhaDonoRestaurante(UsuarioDonoRestauranteDTO donoRestauranteDTO) {
        var donoRestauranteEntity = retornaDadosTrocarSenha(donoRestauranteDTO.trocaSenhaDTO());

        var trocarSenha = this.donoRestauranteRepository.trocarSenhaDonoRestaurante(donoRestauranteEntity);

        if(trocarSenha == 0) {
            throw new ResourceNotFoundException("ID de Usuario inexistente...");
        }
    }

    private DonoRestaurante retornaDadosDonoRestaurante(UsuarioDonoRestauranteDTO usuarioDonoRestauranteDTO) {
        return new DonoRestaurante(usuarioDonoRestauranteDTO);
    }

    private DonoRestaurante retornaDadosTrocarSenha(TrocaSenhaDTO trocaSenhaDTO) {
        return new DonoRestaurante(trocaSenhaDTO);
    }
}
