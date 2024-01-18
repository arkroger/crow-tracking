package br.com.rogeriosouza.crowtracking.simulator;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class Schedule {

    private static final Logger LOGGER = LoggerFactory.getLogger(Schedule.class);

    private final SimulatorService simulatorService;

    public Schedule(SimulatorService simulatorService) {
        this.simulatorService = simulatorService;
    }

    @Scheduled(every = "1s")
    public void gerarPosicao() {

        LOGGER.info("Gerar posição");
        simulatorService.gerarPosicao();

    }
}
