package br.com.atividade1.atividade1.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Schema(description = "DTO para cadastro de um usuario")
public record UsuariosRequestDTO(
        @Schema(description = "Nome do usuario")
        @NotNull(message = "Nome nao pode ser null.") String nome,
        @Schema(description = "E-mail do usuario", example = "pessoa@email.com")
        @NotNull(message = "E-Mail nao pode ser null.") @Email String email,
        @Schema(description = "Login do usuario")
        @NotNull(message = "Login nao pode ser null.") String login,
        @Schema(description = "Senha do usuario")
        @NotNull(message = "Senha nao pode ser null.") String senha,
        @Schema(description = "Data da ultima alteracao do cadastro")
        @NotNull(message = "Data da ultima alteracao nao pode ser null.") LocalDate ultimaAlteracao,
        @Schema(description = "Tipo de usuario", example = "'Cliente' ou 'Dono Restaurante'")
        @NotNull(message = "Tipo de usuario nao pode ser null.") String tipoUsuario
) {}
