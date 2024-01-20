package br.com.rogeriosouza.crowtracking.monitor.model;

import java.io.Serializable;
import java.util.UUID;

public class Crow implements Serializable {

    private static final long serialVersionUID = -6617390558608661971L;

    private final UUID uuid;
    private final String nome;
    private double latitude;
    private double longitude;
    private final Destino destino;

    public Crow(UUID uuid, String nome, double latitude, double longitude, Destino destino) {
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

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
