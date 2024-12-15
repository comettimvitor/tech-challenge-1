package br.com.atividade1.atividade1.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TrocaSenhaDTO(
        @NotNull(message = "E-Mail nao pode ser null.") @Email String email,
        @NotNull(message = "Senha nao pode ser null.") String senha
) {}
