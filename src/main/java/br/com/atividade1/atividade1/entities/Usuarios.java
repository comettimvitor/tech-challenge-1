package br.com.atividade1.atividade1.entities;

import br.com.atividade1.atividade1.dtos.TrocaSenhaDTO;
import br.com.atividade1.atividade1.dtos.composedDTO.UsuarioClienteDTO;
import br.com.atividade1.atividade1.dtos.composedDTO.UsuarioDonoRestauranteDTO;

import java.time.LocalDate;

public abstract class Usuarios {
    private Long id;
    private String nome;
    private String email;
    private String login;
    private String senha;
    private LocalDate ultimaAlteracao;
    private String tipoUsuario;

    public Usuarios(UsuarioClienteDTO usuarioClienteDTO) {
        this.nome = usuarioClienteDTO.usuariosRequestDTO().nome();
        this.email = usuarioClienteDTO.usuariosRequestDTO().email();
        this.login = usuarioClienteDTO.usuariosRequestDTO().login();
        this.senha = usuarioClienteDTO.usuariosRequestDTO().senha();
        this.ultimaAlteracao = usuarioClienteDTO.usuariosRequestDTO().ultimaAlteracao();
        this.tipoUsuario = usuarioClienteDTO.usuariosRequestDTO().tipoUsuario();
    }

    public Usuarios(UsuarioDonoRestauranteDTO usuarioDonoRestauranteDTO) {
        this.nome = usuarioDonoRestauranteDTO.usuariosRequestDTO().nome();
        this.email = usuarioDonoRestauranteDTO.usuariosRequestDTO().email();
        this.login = usuarioDonoRestauranteDTO.usuariosRequestDTO().login();
        this.senha = usuarioDonoRestauranteDTO.usuariosRequestDTO().senha();
        this.ultimaAlteracao = usuarioDonoRestauranteDTO.usuariosRequestDTO().ultimaAlteracao();
        this.tipoUsuario = usuarioDonoRestauranteDTO.usuariosRequestDTO().tipoUsuario();
    }

    public Usuarios(TrocaSenhaDTO trocaSenhaDTO) {
        this.email = trocaSenhaDTO.email();
        this.senha = trocaSenhaDTO.senha();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getUltimaAlteracao() {
        return ultimaAlteracao;
    }

    public void setUltimaAlteracao(LocalDate ultimaAlteracao) {
        this.ultimaAlteracao = ultimaAlteracao;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
