package br.com.rogeriosouza.crowtracking.monitor;

import br.com.rogeriosouza.crowtracking.monitor.model.Posicao;

import java.math.BigDecimal;

public final class DistanciaHelper {


    private static final BigDecimal RAIO_TERRA = BigDecimal.valueOf(6371);

    private DistanciaHelper() {

    }

    public static BigDecimal calcularDistancia(Posicao posicaoInicial, Posicao posicaoFinal) {

        if (posicaoInicial.getLatitude().equals(posicaoFinal.getLatitude()) && posicaoInicial.getLongitude().equals(posicaoFinal.getLongitude())) {
            return BigDecimal.ZERO;
        }

        double valor = (Math.sin(getRadiano(posicaoInicial.getLatitude())) * Math.sin(getRadiano(posicaoFinal.getLatitude()))) +
                (Math.cos(getRadiano(posicaoInicial.getLatitude()))
                        * Math.cos(getRadiano(posicaoFinal.getLatitude())) *
                        Math.cos(getRadiano(posicaoFinal.getLongitude().subtract(posicaoInicial.getLongitude()))));



        double distancia = Math.acos(valor) * RAIO_TERRA.doubleValue();

        return BigDecimal.valueOf(distancia).setScale(3, BigDecimal.ROUND_HALF_UP);

    }

    private static double getRadiano(BigDecimal valor) {
        return Math.toRadians(valor.doubleValue());
    }
}
