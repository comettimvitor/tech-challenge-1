package br.com.atividade1.atividade1.dtos.composedDTO;

import br.com.atividade1.atividade1.dtos.ClientesRequestDTO;
import br.com.atividade1.atividade1.dtos.TrocaSenhaDTO;
import br.com.atividade1.atividade1.dtos.UsuariosRequestDTO;

public record UsuarioClienteDTO(
        UsuariosRequestDTO usuariosRequestDTO,
        ClientesRequestDTO clientesRequestDTO,
        TrocaSenhaDTO trocaSenhaDTO
) {}
