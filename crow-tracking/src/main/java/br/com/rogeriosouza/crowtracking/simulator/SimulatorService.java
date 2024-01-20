package br.com.rogeriosouza.crowtracking.simulator;

import br.com.rogeriosouza.crowtracking.EventHelper;
import br.com.rogeriosouza.crowtracking.monitor.model.Crow;
import br.com.rogeriosouza.crowtracking.monitor.model.Destino;
import io.vertx.mutiny.core.eventbus.EventBus;
import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

@ApplicationScoped
public class SimulatorService {

    private final FakeDatabase fakeDatabase;

    private final EventBus eventBus;

    private static final int VARIACAO_MIN = -20;
    private static final int VARIACAO_MAX = 50;

    public SimulatorService(FakeDatabase fakeDatabase, EventBus eventBus) {
        this.fakeDatabase = fakeDatabase;
        this.eventBus = eventBus;
    }

    public void gerarPosicao() {
        List<Crow> crows = fakeDatabase.getCrows();

        //FIXME REMOVER
        if (crows.isEmpty()) {
            crows.add(new Crow(UUID.randomUUID(), "Jubileu", -23.4409067, -46.7381877,
                    new Destino(400L, 500L)
            ));
        }

        crows.forEach(crow -> {
            crow.setLatitude(crow.getLatitude() + getVariacao());
            crow.setLongitude(crow.getLongitude() + getVariacao());
        });
        crows.forEach(crow -> this.eventBus.publish(EventHelper.ENVIA_POSICAO, crow));
    }

    private double getVariacao() {
        int variacao = new Random()
                .ints(VARIACAO_MIN, VARIACAO_MAX)
                .findFirst()
                .getAsInt();

        return new BigDecimal(variacao).divide(new BigDecimal(10000)).doubleValue();

    }

    public void add(Crow crow) {
        fakeDatabase.add(crow);
        this.gerarPosicao();
    }
}
