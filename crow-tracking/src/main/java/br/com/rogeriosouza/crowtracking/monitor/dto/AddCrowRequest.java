package br.com.rogeriosouza.crowtracking.monitor.dto;

public class AddCrowRequest {

    private String nome;
    private AddCrowDestinoRequest destino;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public AddCrowDestinoRequest getDestino() {
        return destino;
    }

    public void setDestino(AddCrowDestinoRequest destino) {
        this.destino = destino;
    }
}
