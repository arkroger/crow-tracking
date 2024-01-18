package br.com.rogeriosouza.crowtracking.monitor.model;

import java.io.Serializable;
import java.util.UUID;

public class Crow implements Serializable {

    private static final long serialVersionUID = -6617390558608661971L;

    private final UUID uuid;
    private final String nome;
    private Long latitude;
    private Long longitude;
    private final Destino destino;

    public Crow(UUID uuid, String nome, Long latitude, Long longitude, Destino destino) {
        this.uuid = uuid;
        this.nome = nome + " " + uuid;
        this.latitude = latitude;
        this.longitude = longitude;
        this.destino = destino;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getNome() {
        return nome;
    }

    public Long getLatitude() {
        return latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }
}
