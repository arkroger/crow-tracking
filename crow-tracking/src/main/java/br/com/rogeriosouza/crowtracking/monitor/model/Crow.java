package br.com.rogeriosouza.crowtracking.monitor.model;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public class Crow implements Serializable {

    @Serial
    private static final long serialVersionUID = -6617390558608661971L;

    private static final BigDecimal DISTANCIA_EM_KM_INICIO_DECOLAGEM_POUSO = BigDecimal.valueOf(0.5);

    private final UUID uuid;
    private final String nome;
    private Posicao localizacao;
    private final Posicao destino;

    private final Posicao origem;

    private Distancia distancia = new Distancia();

    public Crow(UUID uuid, String nome, Posicao origem, Posicao destino) {
        this.uuid = uuid;
        this.nome = nome;
        this.localizacao = origem;
        this.destino = destino;
        this.origem = origem;
        this.atualizarDistancia();
    }

    public void atualizarLocalizacao(Posicao posicao) {
        this.localizacao = posicao;
        this.atualizarDistancia();
    }

    public void atualizarDistancia() {
        this.distancia.atualizar(this.origem, this.localizacao, this.destino);
    }

    public boolean isIniciandoVoo() {
        return DISTANCIA_EM_KM_INICIO_DECOLAGEM_POUSO.compareTo(this.distancia.getPercorrida()) >= 0;
    }

    public boolean isPouso() {
        return DISTANCIA_EM_KM_INICIO_DECOLAGEM_POUSO.compareTo(this.distancia.getRestante()) >= 0;
    }

    public boolean isChegou() {
        return BigDecimal.ZERO.compareTo(this.distancia.getRestante()) == 0;
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

    public Distancia getDistancia() {
        return distancia;
    }
}
