package br.com.rogeriosouza.crowtracking.monitor;

import br.com.rogeriosouza.crowtracking.EventHelper;
import br.com.rogeriosouza.crowtracking.monitor.model.Crow;
import io.smallrye.mutiny.Multi;
import io.vertx.mutiny.core.eventbus.EventBus;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestStreamElementType;

import java.util.List;

@Path("monitor")
public class MonitorController {

    private final EventBus eventBus;

    public MonitorController(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @RestStreamElementType(MediaType.APPLICATION_JSON)
    public Multi<List<Crow>> stream() {
        return eventBus.<List<Crow>>consumer(EventHelper.ATUALIZA_MONITORAMENTO)
                .bodyStream()
                .toMulti();
    }

}
