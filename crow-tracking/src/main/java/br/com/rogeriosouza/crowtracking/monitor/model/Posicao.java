package br.com.rogeriosouza.crowtracking.monitor.model;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public class Posicao implements Serializable {

    @Serial
    private static final long serialVersionUID = -974098542383702058L;

    private final BigDecimal latitude;
    private final BigDecimal longitude;

    public Posicao(BigDecimal latitude, BigDecimal longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }
}
