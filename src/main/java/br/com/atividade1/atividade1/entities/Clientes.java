package br.com.atividade1.atividade1.entities;

import br.com.atividade1.atividade1.dtos.TrocaSenhaDTO;
import br.com.atividade1.atividade1.dtos.composedDTO.UsuarioClienteDTO;

public class Clientes extends Usuarios{
    private Long id;
    private Long idUsuario;
    private String rua;
    private String bairro;
    private String numero;
    private String cep;
    private String complemento;

    public Clientes(UsuarioClienteDTO usuarioClienteDTO) {
        super(usuarioClienteDTO);
        this.idUsuario = usuarioClienteDTO.clientesRequestDTO().idUsuario();
        this.rua = usuarioClienteDTO.clientesRequestDTO().rua();
        this.bairro = usuarioClienteDTO.clientesRequestDTO().bairro();
        this.numero = usuarioClienteDTO.clientesRequestDTO().numero();
        this.cep = usuarioClienteDTO.clientesRequestDTO().cep();
        this.complemento = usuarioClienteDTO.clientesRequestDTO().complemento();
    }

    public Clientes(TrocaSenhaDTO trocaSenhaDTO) {
        super(trocaSenhaDTO);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
