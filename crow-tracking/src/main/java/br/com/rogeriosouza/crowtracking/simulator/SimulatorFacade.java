package br.com.rogeriosouza.crowtracking.simulator;

import br.com.rogeriosouza.crowtracking.monitor.model.Crow;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SimulatorFacade {


    private final SimulatorService simulatorService;

    public SimulatorFacade(SimulatorService simulatorService) {
        this.simulatorService = simulatorService;
    }

    public void lancarCorvo(Crow crow) {

        simulatorService.add(crow);

    }
}
