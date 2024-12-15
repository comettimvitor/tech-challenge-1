package br.com.atividade1.atividade1.dtos.composedDTO;

import br.com.atividade1.atividade1.dtos.DonoRestauranteRequestDTO;
import br.com.atividade1.atividade1.dtos.TrocaSenhaDTO;
import br.com.atividade1.atividade1.dtos.UsuariosRequestDTO;

public record UsuarioDonoRestauranteDTO(
        UsuariosRequestDTO usuariosRequestDTO,
        DonoRestauranteRequestDTO donoRestauranteRequestDTO,
        TrocaSenhaDTO trocaSenhaDTO
) {}
