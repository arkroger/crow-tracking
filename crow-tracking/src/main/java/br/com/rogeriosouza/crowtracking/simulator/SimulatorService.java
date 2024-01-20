package br.com.rogeriosouza.crowtracking.simulator;

import br.com.rogeriosouza.crowtracking.EventHelper;
import br.com.rogeriosouza.crowtracking.monitor.model.Crow;
import br.com.rogeriosouza.crowtracking.monitor.model.Posicao;
import io.vertx.mutiny.core.eventbus.EventBus;
import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@ApplicationScoped
public class SimulatorService {

    private final FakeDatabase fakeDatabase;

    private final EventBus eventBus;

    private static final int VARIACAO_MIN = 10;
    private static final int VARIACAO_MAX = 40;

    public SimulatorService(FakeDatabase fakeDatabase, EventBus eventBus) {
        this.fakeDatabase = fakeDatabase;
        this.eventBus = eventBus;
    }

    public void gerarPosicao() {
        List<Crow> crows = fakeDatabase.getCrows();

        //FIXME REMOVER
//        if (crows.isEmpty()) {
//            crows.add(new Crow(
//                    UUID.randomUUID(),
//                    "Jubileu",
//                    new Posicao(BigDecimal.valueOf(-23.4409067), BigDecimal.valueOf(-46.7381877)),
//                    new Posicao(BigDecimal.valueOf(-23.538805), BigDecimal.valueOf(-46.681260))
//            ));
//        }

        crows.forEach(crow -> {
            double variacao = getVariacao(crow.getLocalizacao(), crow.getDestino());
            crow.atualizarLocalizacao(
                    PosicaoHelper.proximaLocalizacao(crow.getLocalizacao(), crow.getDestino(), variacao));
        });
        crows.forEach(crow -> this.eventBus.publish(EventHelper.ENVIA_POSICAO, crow));
    }

    private double getVariacao(Posicao localizacao, Posicao destino) {
        int variacao = new Random()
                .ints(VARIACAO_MIN, VARIACAO_MAX)
                .findFirst()
                .getAsInt();

        if (localizacao.getLatitude().compareTo(destino.getLatitude()) > 0) {
            return new BigDecimal(variacao * -1).divide(new BigDecimal(10000)).doubleValue();
        }

        return new BigDecimal(variacao).divide(new BigDecimal(10000)).doubleValue();

    }

    public void add(Crow crow) {
        fakeDatabase.add(crow);
        this.gerarPosicao();
    }
}
