package br.com.rogeriosouza.crowtracking.simulator;

import br.com.rogeriosouza.crowtracking.monitor.model.Posicao;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PosicaoHelperTest {

    @Test
    void proximaLocalizacaoComValoresInteiros() {
        BigDecimal latitudeEsperada = BigDecimal.valueOf(2).setScale(PosicaoHelper.CASAS_DECIMAIS, PosicaoHelper.ARREDONDAMENTO);
        BigDecimal longitudeEsperada = BigDecimal.valueOf(2).setScale(PosicaoHelper.CASAS_DECIMAIS, PosicaoHelper.ARREDONDAMENTO);

        Posicao origem = new Posicao(BigDecimal.valueOf(1), BigDecimal.valueOf(1));
        Posicao destino = new Posicao(BigDecimal.valueOf(10), BigDecimal.valueOf(10));

        Posicao posicao = PosicaoHelper.proximaLocalizacao(origem, destino, 1);

        assertEquals(latitudeEsperada, posicao.getLatitude());
        assertEquals(longitudeEsperada, posicao.getLongitude());
    }

    @Test
    void proximaLocalizacaoComValoresInteirosLatitudeNegativa() {
        BigDecimal latitudeEsperada = BigDecimal.valueOf(2).setScale(PosicaoHelper.CASAS_DECIMAIS, PosicaoHelper.ARREDONDAMENTO);
        BigDecimal longitudeEsperada = BigDecimal.valueOf(0).setScale(PosicaoHelper.CASAS_DECIMAIS, PosicaoHelper.ARREDONDAMENTO);

        Posicao origem = new Posicao(BigDecimal.valueOf(1), BigDecimal.valueOf(1));
        Posicao destino = new Posicao(BigDecimal.valueOf(-8), BigDecimal.valueOf(10));

        Posicao posicao = PosicaoHelper.proximaLocalizacao(origem, destino, 1);

        assertEquals(latitudeEsperada, posicao.getLatitude());
        assertEquals(longitudeEsperada, posicao.getLongitude());

    }

    @Test
    void proximaLocalizacaoComValoresInteirosLongitudeNegativa() {
        BigDecimal latitudeEsperada = BigDecimal.valueOf(2).setScale(PosicaoHelper.CASAS_DECIMAIS, PosicaoHelper.ARREDONDAMENTO);
        BigDecimal longitudeEsperada = BigDecimal.valueOf(0).setScale(PosicaoHelper.CASAS_DECIMAIS, PosicaoHelper.ARREDONDAMENTO);

        Posicao origem = new Posicao(BigDecimal.valueOf(1), BigDecimal.valueOf(1));
        Posicao destino = new Posicao(BigDecimal.valueOf(10), BigDecimal.valueOf(-8));

        Posicao posicao = PosicaoHelper.proximaLocalizacao(origem, destino, 1);

        assertEquals(latitudeEsperada, posicao.getLatitude());
        assertEquals(longitudeEsperada, posicao.getLongitude());
    }

    @Test
    void proximaLocalizacaoComValoresInteirosNegativos() {
        BigDecimal latitudeEsperada = BigDecimal.valueOf(2).setScale(PosicaoHelper.CASAS_DECIMAIS, PosicaoHelper.ARREDONDAMENTO);
        BigDecimal longitudeEsperada = BigDecimal.valueOf(2).setScale(PosicaoHelper.CASAS_DECIMAIS, PosicaoHelper.ARREDONDAMENTO);

        Posicao origem = new Posicao(BigDecimal.valueOf(1), BigDecimal.valueOf(1));
        Posicao destino = new Posicao(BigDecimal.valueOf(-10), BigDecimal.valueOf(-10));

        Posicao posicao = PosicaoHelper.proximaLocalizacao(origem, destino, 1);

        assertEquals(latitudeEsperada, posicao.getLatitude());
        assertEquals(longitudeEsperada, posicao.getLongitude());

    }
}