package br.com.rogeriosouza.crowtracking.monitor.model;

import java.io.Serial;
import java.io.Serializable;

public class Destino implements Serializable {

    @Serial
    private static final long serialVersionUID = -974098542383702058L;

    private final Long latitude;
    private final Long longitude;

    public Destino(Long latitude, Long longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getLatitude() {
        return latitude;
    }

    public Long getLongitude() {
        return longitude;
    }
}
