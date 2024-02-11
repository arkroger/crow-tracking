package br.com.rogeriosouza.crowtracking.monitor.model;

import br.com.rogeriosouza.crowtracking.monitor.DistanciaHelper;

import java.math.BigDecimal;

public class Distancia {

    private BigDecimal percorrida;
    private BigDecimal restante;

    public void atualizar(Posicao origem, Posicao localizacao, Posicao destino) {
        this.percorrida = DistanciaHelper.calcularDistancia(origem, localizacao);
        this.restante = DistanciaHelper.calcularDistancia(localizacao, destino);
    }

    public BigDecimal getPercorrida() {
        return percorrida;
    }

    public BigDecimal getRestante() {
        return restante;
    }
}
