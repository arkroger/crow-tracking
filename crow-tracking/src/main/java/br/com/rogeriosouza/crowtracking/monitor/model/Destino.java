package br.com.rogeriosouza.crowtracking.monitor.model;

import java.io.Serial;
import java.io.Serializable;

public class Destino implements Serializable {

    @Serial
    private static final long serialVersionUID = -974098542383702058L;

    private final double latitude;
    private final double longitude;

    public Destino(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
