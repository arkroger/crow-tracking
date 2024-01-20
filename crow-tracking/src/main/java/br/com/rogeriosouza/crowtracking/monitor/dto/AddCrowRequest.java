package br.com.rogeriosouza.crowtracking.monitor.dto;

public class AddCrowRequest {

    private String nome;

    private AddCrowPosicaoRequest origem;
    private AddCrowPosicaoRequest destino;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public AddCrowPosicaoRequest getOrigem() {
        return origem;
    }

    public void setOrigem(AddCrowPosicaoRequest origem) {
        this.origem = origem;
    }

    public AddCrowPosicaoRequest getDestino() {
        return destino;
    }

    public void setDestino(AddCrowPosicaoRequest destino) {
        this.destino = destino;
    }
}
