package br.com.atividade1.atividade1.controllers;

import br.com.atividade1.atividade1.dtos.composedDTO.UsuarioClienteDTO;
import br.com.atividade1.atividade1.entities.responses.SucessoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Clientes", description = "Controller para cadastro de usuarios do tipo cliente.")
public interface ClientesController {

    @Operation(
            description = "Cria um novo usuario do tipo cliente.",
            summary = "Cadastro de cliente.",
            responses = {
                    @ApiResponse(
                            description = "Cadastrado com sucesso!",
                            responseCode = "201",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = {
                                            @ExampleObject(
                                                    name = "usuariosRequestDTO",
                                                    value = "\"nome\": \"Liam\",\n" +
                                                            "\"email\": \"cliente@gmail.com\",\n" +
                                                            "\"login\": \"liam\",\n" +
                                                            "\"senha\": \"123\""
                                            ),
                                            @ExampleObject(
                                                    name = "clientesRequestDTO",
                                                    value = "\"rua\": \"Rua X\",\n" +
                                                            "\"bairro\": \"Bairro Y\",\n" +
                                                            "\"numero\": \"123\",\n" +
                                                            "\"cep\": \"29000-000\",\n" +
                                                            "\"complemento\": \"Apto 45\""
                                            )
                                    }
                            )
                    )}
    )
    @PostMapping
    ResponseEntity<SucessoResponse> salvarCliente(@Valid @RequestBody UsuarioClienteDTO usuarioClienteDTO);

    @Operation(
            description = "Altera dados de um usuario do tipo cliente.",
            summary = "Alteracao de dados de cliente.",
            responses = {
                    @ApiResponse(
                            description = "Cadastrado alterado com sucesso!",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = {
                                            @ExampleObject(
                                                    name = "usuariosRequestDTO",
                                                    value = "\"nome\": \"Vitor\",\n" +
                                                            "\"email\": \"vitor@gmail.com\",\n" +
                                                            "\"login\": \"vitor\""
                                            ),
                                            @ExampleObject(
                                                    name = "clientesRequestDTO",
                                                    value = "\"rua\": \"Rua X\",\n" +
                                                            "\"bairro\": \"Bairro Y\",\n" +
                                                            "\"numero\": \"123\",\n" +
                                                            "\"cep\": \"29000-000\",\n" +
                                                            "\"complemento\": \"Apto 45\""
                                            )
                                    }
                            )
                    )}
    )
    @PutMapping("/alteracao/{id}")
    public ResponseEntity<SucessoResponse> alterarCliente(@Valid @RequestBody UsuarioClienteDTO usuarioClienteDTO, @PathVariable("id") Long id);

    @Operation(
            description = "Deleta o cadastro de um usuario do tipo cliente.",
            summary = "Deleta cadastro de cliente.",
            responses = {
                    @ApiResponse(
                            description = "Cliente deletado com sucesso!",
                            responseCode = "200"
                    )}
    )
    @DeleteMapping("/exclusao/{id}")
    ResponseEntity<SucessoResponse> deletarCliente(@PathVariable("id") Long id);

    @Operation(
            description = "Troca a senha de um usuario do tipo cliente.",
            summary = "Troca de senha de cliente.",
            responses = {
                    @ApiResponse(
                            description = "Senha alterada com sucesso!",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = {
                                            @ExampleObject(
                                                    name = "trocaSenhaDTO",
                                                    value = "\"email\": \"vitor@gmail.com\",\n" +
                                                            "\"senha\": \"minhaSenhaSegura123\""
                                            )
                                    }
                            )
                    )}
    )
    @PutMapping("/trocar-senha")
    ResponseEntity<SucessoResponse> trocarSenhaCliente(@Valid @RequestBody UsuarioClienteDTO usuarioClienteDTO);
}
