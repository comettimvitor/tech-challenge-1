package br.com.atividade1.atividade1.controllers;

import br.com.atividade1.atividade1.controllers.ClientesController;
import br.com.atividade1.atividade1.dtos.composedDTO.UsuarioClienteDTO;
import br.com.atividade1.atividade1.entities.responses.SucessoResponse;
import br.com.atividade1.atividade1.services.ClientesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario/cliente")
public class ClientesControllerImp implements ClientesController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientesControllerImp.class);

    private final ClientesService clientesService;

    public ClientesControllerImp(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @Override
    public ResponseEntity<SucessoResponse> salvarCliente(UsuarioClienteDTO usuarioClienteDTO) {
        LOGGER.info("POST -> /cliente");

        this.clientesService.salvarCliente(usuarioClienteDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(SucessoResponse.mensagem("Cadastrado com sucesso!", HttpStatus.CREATED.value()));
    }

    @Override
    public ResponseEntity<SucessoResponse> alterarCliente(UsuarioClienteDTO usuarioClienteDTO, Long id) {
        LOGGER.info("PUT -> /cliente/" + id);

        this.clientesService.alterarCliente(usuarioClienteDTO, id);

        return ResponseEntity.status(HttpStatus.OK).body(SucessoResponse.mensagem("Cadastrado alterado com sucesso!", HttpStatus.OK.value()));
    }

    @Override
    public ResponseEntity<SucessoResponse> deletarCliente(Long id) {
        LOGGER.info("DELETE -> /cliente/" + id);

        this.clientesService.deletarCliente(id);

        return ResponseEntity.status(HttpStatus.OK).body(SucessoResponse.mensagem("Cliente deletado com sucesso!", HttpStatus.OK.value()));
    }

    @Override
    public ResponseEntity<SucessoResponse> trocarSenhaCliente(UsuarioClienteDTO usuarioClienteDTO) {
        LOGGER.info("PUT -> /cliente/trocar-senha");

        this.clientesService.trocarSenhaCliente(usuarioClienteDTO);

        return ResponseEntity.status(HttpStatus.OK).body(SucessoResponse.mensagem("Senha alterada com sucesso!", HttpStatus.OK.value()));
    }
}
