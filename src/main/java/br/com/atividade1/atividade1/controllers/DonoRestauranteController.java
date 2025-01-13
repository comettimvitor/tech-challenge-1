package br.com.atividade1.atividade1.controllers;

import br.com.atividade1.atividade1.dtos.composedDTO.UsuarioDonoRestauranteDTO;
import br.com.atividade1.atividade1.entities.responses.SucessoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Dono de Restaurante", description = "Controller para cadastro de usuarios do tipo dono de restaurante.")
public interface DonoRestauranteController {


    @Operation(
            description = "Cria um novo usuario do tipo Dono de Restaurante.",
            summary = "Cadastro de Dono de Restaurante.",
            responses = {
                    @ApiResponse(
                            description = "Cadastrado com sucesso!",
                            responseCode = "201",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = {
                                            @ExampleObject(
                                                    name = "usuariosRequestDTO",
                                                    value = "\"nome\": \"Vitor\",\n" +
                                                            "\"email\": \"vitor@gmail.com\",\n" +
                                                            "\"login\": \"Dono Rest\",\n" +
                                                            "\"senha\": \"123456\""
                                            ),
                                            @ExampleObject(
                                                    name = "donoRestauranteRequestDTO",
                                                    value = "\"nomeRestaurante\": \"teste1\""
                                            )
                                    }
                            )
                    )}
    )
    @PostMapping
    public ResponseEntity<SucessoResponse> salvarDonoRestaurante(@Valid @RequestBody UsuarioDonoRestauranteDTO usuarioDonoRestauranteDTO);

    @Operation(
            description = "Altera dados de um usuario do tipo Dono de Restaurante.",
            summary = "Altera dados de um Dono de Restaurante.",
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
                                                            "\"email\": \"teste@gmail.com\",\n" +
                                                            "\"login\": \"vitor123\""
                                            ),
                                            @ExampleObject(
                                                    name = "donoRestauranteRequestDTO",
                                                    value = "\"nomeRestaurante\": \"Comida Caseira\""
                                            )
                                    }
                            )
                    )}
    )
    @PutMapping("/alteracao/{id}")
    public ResponseEntity<SucessoResponse> alterarDonoRestaurante(@Valid @RequestBody UsuarioDonoRestauranteDTO usuarioDonoRestauranteDTO, @PathVariable("id") Long id);

    @Operation(
            description = "Deleta um usuario do tipo Dono de Restaurante.",
            summary = "Deleta dados de um Dono de Restaurante.",
            responses = {
                    @ApiResponse(
                            description = "Dono de restaurante deletado com sucesso!",
                            responseCode = "200"
                    )}
    )
    @DeleteMapping("/exclusao/{id}")
    public ResponseEntity<SucessoResponse> deletarDonoRestaurante(@PathVariable("id") Long id);

    @Operation(
            description = "Troca a senha de um usuario do tipo Dono de Restaurante.",
            summary = "Troca a senha de um Dono de Restaurante.",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = {
                                            @ExampleObject(
                                                    name = "trocaSenhaDTO",
                                                    value = "\"email\": \"vitor@gmail.com\",\n" +
                                                            "\"senha\": \"seguro\""
                                            )
                                    }
                            )
                    )}
    )
    @PutMapping("/trocar-senha")
    public ResponseEntity<SucessoResponse> trocarSenhaDonoRestaurante(@Valid @RequestBody UsuarioDonoRestauranteDTO usuarioDonoRestauranteDTO);
}
