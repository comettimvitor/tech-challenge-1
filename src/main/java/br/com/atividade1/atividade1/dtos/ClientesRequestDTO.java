package br.com.atividade1.atividade1.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ClientesRequestDTO(
        @NotNull(message = "ID usuario nao pode ser null.") Long idUsuario,
        @NotNull(message = "Rua nao pode ser null.") String rua,
        @NotNull(message = "Bairro nao pode ser null.") String bairro,
        @NotNull(message = "Numero nao pode ser null.") String numero,
        @NotNull(message = "CEP nao pode ser null.") String cep,
        String complemento
) {}
