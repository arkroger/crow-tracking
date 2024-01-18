package br.com.rogeriosouza.crowtracking.monitor;

import br.com.rogeriosouza.crowtracking.EventHelper;
import br.com.rogeriosouza.crowtracking.monitor.model.Crow;
import io.quarkus.vertx.ConsumeEvent;
import io.vertx.mutiny.core.eventbus.EventBus;
import jakarta.inject.Singleton;

@Singleton
public class MonitorService {

    private final EventBus eventBus;

    public MonitorService(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @ConsumeEvent(EventHelper.ENVIA_POSICAO)
    public void list(Crow crow) {
        eventBus.publish(EventHelper.ATUALIZA_MONITORAMENTO, crow);
    }

}
