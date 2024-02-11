package br.com.rogeriosouza.crowtracking.monitor;

import br.com.rogeriosouza.crowtracking.monitor.model.Posicao;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DistanciaHelperTest {

    @Test
    void calcularDistancia() {

        BigDecimal distanciaEsperada = BigDecimal.valueOf(12.337);

        Posicao posicaoInicial = new Posicao(BigDecimal.valueOf(-23.4409067), BigDecimal.valueOf(-46.7381877));
        Posicao posicaoFinal = new Posicao(BigDecimal.valueOf(-23.538805), BigDecimal.valueOf(-46.681260));

        BigDecimal distanciaCalculada = DistanciaHelper.calcularDistancia(posicaoInicial, posicaoFinal);

        assertEquals(distanciaEsperada, distanciaCalculada);

    }
}