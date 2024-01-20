package br.com.rogeriosouza.crowtracking.simulator;

import br.com.rogeriosouza.crowtracking.monitor.model.Posicao;

import java.math.BigDecimal;

public final class PosicaoHelper {

    public static final int CASAS_DECIMAIS = 6;
    public static final int ARREDONDAMENTO = BigDecimal.ROUND_HALF_UP ;

    private PosicaoHelper() {

    }

    public static Posicao proximaLocalizacao(Posicao posicaoAtual, Posicao destino, double delta) {

        /*
         * EQUACAO GERAL DA RETA ax + by + c = 0
         * a = (ya - yb)
         * b = (xb - xa)
         * c = xayb - xbya
         */
        BigDecimal a = posicaoAtual.getLongitude().subtract(destino.getLongitude());
        BigDecimal b = destino.getLatitude().subtract(posicaoAtual.getLatitude());
        BigDecimal c = posicaoAtual.getLatitude().multiply(destino.getLongitude()).subtract(destino.getLatitude().multiply(posicaoAtual.getLongitude()));

        BigDecimal novaLatitude = posicaoAtual.getLatitude().add(BigDecimal.valueOf(delta));

        BigDecimal longitude = a.multiply(novaLatitude).add(c).multiply(new BigDecimal(-1))
                .divide(b, ARREDONDAMENTO);

        return new Posicao(
                novaLatitude.setScale(CASAS_DECIMAIS, ARREDONDAMENTO),
                longitude.setScale(CASAS_DECIMAIS, ARREDONDAMENTO)
        );
    }


}
