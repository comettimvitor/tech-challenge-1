package br.com.atividade1.atividade1.dtos;

import jakarta.validation.constraints.NotNull;

public record DonoRestauranteRequestDTO(
        @NotNull(message = "ID usuario nao pode ser null.") Long idUsuario,
        @NotNull(message = "Nome do Restaurante nao pode ser null.") String nomeRestaurante
) {}
