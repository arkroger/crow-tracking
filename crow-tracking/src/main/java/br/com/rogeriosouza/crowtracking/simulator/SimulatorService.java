package br.com.rogeriosouza.crowtracking.simulator;

import br.com.rogeriosouza.crowtracking.EventHelper;
import br.com.rogeriosouza.crowtracking.monitor.model.Crow;
import io.vertx.mutiny.core.eventbus.EventBus;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class SimulatorService {

    private final FakeDatabase fakeDatabase;

    private final EventBus eventBus;

    public SimulatorService(FakeDatabase fakeDatabase, EventBus eventBus) {
        this.fakeDatabase = fakeDatabase;
        this.eventBus = eventBus;
    }

    public void gerarPosicao() {
        List<Crow> crows = fakeDatabase.getCrows();
        crows.forEach(crow -> {
            crow.setLatitude(crow.getLatitude() + 2);
            crow.setLongitude(crow.getLongitude() + 4);
        });
        crows.forEach(crow -> this.eventBus.publish(EventHelper.ENVIA_POSICAO, crow));
    }

    public void add(Crow crow) {
        fakeDatabase.add(crow);
        this.gerarPosicao();
    }
}
