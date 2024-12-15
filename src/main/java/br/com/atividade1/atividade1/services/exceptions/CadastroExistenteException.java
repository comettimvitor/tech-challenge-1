package br.com.atividade1.atividade1.services.exceptions;

public class CadastroExistenteException extends RuntimeException{

    public CadastroExistenteException(String mensagem) {
        super(mensagem);
    }
}
