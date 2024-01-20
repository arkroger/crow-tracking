package br.com.rogeriosouza.crowtracking.monitor.model;

import java.io.Serializable;
import java.util.UUID;

public class Crow implements Serializable {

    private static final long serialVersionUID = -6617390558608661971L;

    private final UUID uuid;
    private final String nome;
    private Posicao localizacao;
    private final Posicao destino;

    public Crow(UUID uuid, String nome, Posicao localizacao, Posicao destino) {
        this.uuid = uuid;
        this.nome = nome;
        this.localizacao = localizacao;
        this.destino = destino;
    }

    public void atualizarLocalizacao(Posicao posicao) {
        this.localizacao = posicao;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getNome() {
        return nome;
    }

    public Posicao getLocalizacao() {
        return localizacao;
    }

    public Posicao getDestino() {
        return destino;
    }


}
