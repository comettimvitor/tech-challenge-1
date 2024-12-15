package br.com.atividade1.atividade1.entities.responses;

public class SucessoResponse {
    private String mensagem;
    private int status;

    public SucessoResponse(String mensagem, int status) {
        this.mensagem = mensagem;
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static SucessoResponse mensagem(String mensagem, int status) {
        return new SucessoResponse(mensagem, status);
    }
}
