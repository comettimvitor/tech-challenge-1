package br.com.atividade1.atividade1.enums;

public enum TipoUsuario {
    CLIENTE("Cliente"),
    DONO_RESTAURANTE("Dono de restaurante");

    private final String descricao;

    TipoUsuario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
