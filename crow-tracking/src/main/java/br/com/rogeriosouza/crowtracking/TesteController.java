package br.com.rogeriosouza.crowtracking;

import br.com.rogeriosouza.crowtracking.monitor.dto.AddCrowRequest;
import br.com.rogeriosouza.crowtracking.monitor.model.Crow;
import br.com.rogeriosouza.crowtracking.monitor.model.Destino;
import br.com.rogeriosouza.crowtracking.simulator.SimulatorFacade;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.UUID;

@Path("teste")
public class TesteController {

    @Inject
    private SimulatorFacade simulatorFacade;

    @POST
    public void add(AddCrowRequest addCrowRequest) {

        Crow crow = new Crow(
                UUID.randomUUID(),
                addCrowRequest.getNome(),
                addCrowRequest.getDestino().getLatitude(),
                addCrowRequest.getDestino().getLongitude(),
                new Destino(addCrowRequest.getDestino().getLatitude(), addCrowRequest.getDestino().getLongitude())
        );

        simulatorFacade.lancarCorvo(crow);

    }
}
