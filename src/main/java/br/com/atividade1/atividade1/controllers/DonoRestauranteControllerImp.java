package br.com.atividade1.atividade1.controllers;

import br.com.atividade1.atividade1.controllers.swagger.DonoRestauranteApi;
import br.com.atividade1.atividade1.dtos.composedDTO.UsuarioDonoRestauranteDTO;
import br.com.atividade1.atividade1.entities.responses.SucessoResponse;
import br.com.atividade1.atividade1.services.DonoRestauranteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario/dono-restaurante")
public class DonoRestauranteControllerImp implements DonoRestauranteApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(DonoRestauranteControllerImp.class);

    private final DonoRestauranteService donoRestauranteService;

    public DonoRestauranteControllerImp(DonoRestauranteService donoRestauranteService) {
        this.donoRestauranteService = donoRestauranteService;
    }

    @Override
    public ResponseEntity<SucessoResponse> salvarDonoRestaurante(UsuarioDonoRestauranteDTO usuarioDonoRestauranteDTO) {
        LOGGER.info("POST -> /dono-restaurante");

        this.donoRestauranteService.salvarDonoRestaurante(usuarioDonoRestauranteDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(SucessoResponse.mensagem("Cadastrado com sucesso!", HttpStatus.CREATED.value()));
    }

    @Override
    public ResponseEntity<SucessoResponse> alterarDonoRestaurante(UsuarioDonoRestauranteDTO usuarioDonoRestauranteDTO, @PathVariable("id") Long id) {
        LOGGER.info("PUT -> /cliente/" + id);

        this.donoRestauranteService.alterarDonoRestaurante(usuarioDonoRestauranteDTO, id);

        return ResponseEntity.status(HttpStatus.OK).body(SucessoResponse.mensagem("Cadastrado alterado com sucesso!", HttpStatus.OK.value()));
    }

    @Override
    public ResponseEntity<SucessoResponse> deletarDonoRestaurante(Long id) {
        LOGGER.info("DELETE -> /dono-restaurante/" + id);

        this.donoRestauranteService.deletarDonoRestaurante(id);

        return ResponseEntity.status(HttpStatus.OK).body(SucessoResponse.mensagem("Dono de restaurante deletado com sucesso!", HttpStatus.OK.value()));
    }

    @Override
    public ResponseEntity<SucessoResponse> trocarSenhaDonoRestaurante(UsuarioDonoRestauranteDTO usuarioDonoRestauranteDTO) {
        LOGGER.info("PUT -> /dono-restaurante/trocar-senha");

        this.donoRestauranteService.trocarSenhaDonoRestaurante(usuarioDonoRestauranteDTO);

        return ResponseEntity.status(HttpStatus.OK).body(SucessoResponse.mensagem("Senha alterada com sucesso!", HttpStatus.OK.value()));
    }
}
