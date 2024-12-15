package br.com.atividade1.atividade1.entities;

import br.com.atividade1.atividade1.dtos.TrocaSenhaDTO;
import br.com.atividade1.atividade1.dtos.composedDTO.UsuarioDonoRestauranteDTO;

public class DonoRestaurante extends Usuarios{
    private Long id;
    private String nomeRestaurante;

    public DonoRestaurante(UsuarioDonoRestauranteDTO usuarioDonoRestauranteDTO) {
        super(usuarioDonoRestauranteDTO);
        this.nomeRestaurante = usuarioDonoRestauranteDTO.donoRestauranteRequestDTO().nomeRestaurante();
    }

    public DonoRestaurante(TrocaSenhaDTO trocaSenhaDTO) {
        super(trocaSenhaDTO);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }
}
