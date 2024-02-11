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

    private static final int VARIACAO_MIN = 35;
    private static final int VARIACAO_MAX = 60;

    private static final int VARIACAO_MIN_DECOLAGEM_POUSO = 1;
    private static final int VARIACAO_MAX_DECOLAGEM_POUSO = 3;

    public SimulatorService(FakeDatabase fakeDatabase, EventBus eventBus) {
        this.fakeDatabase = fakeDatabase;
        this.eventBus = eventBus;
    }

    public void gerarPosicao() {
        List<Crow> crows = fakeDatabase.getCrows();

//        FIXME REMOVER
        if (crows.isEmpty()) {
            crows.add(new Crow(
                    UUID.randomUUID(),
                    "Jubileu" ,
                    new Posicao(BigDecimal.valueOf(-23.4409067), BigDecimal.valueOf(-46.7381877)),
                    new Posicao(BigDecimal.valueOf(-23.538805), BigDecimal.valueOf(-46.681260)))
            );
        }

        crows.forEach(crow -> {
            if (!crow.isChegou()) {
                double variacao = getVariacao(crow);
                crow.atualizarLocalizacao(
                        PosicaoHelper.proximaLocalizacao(crow.getLocalizacao(), crow.getDestino(), variacao));
            }
        });
        crows.forEach(crow -> this.eventBus.publish(EventHelper.ENVIA_POSICAO, crow));
    }

    private double getVariacao(Crow crow) {
        int variacao;
        if (crow.isPouso() || crow.isIniciandoVoo()) {
            variacao = new Random()
                    .ints(VARIACAO_MIN_DECOLAGEM_POUSO, VARIACAO_MAX_DECOLAGEM_POUSO)
                    .findFirst()
                    .getAsInt();
        } else {
            variacao = new Random()
                    .ints(VARIACAO_MIN, VARIACAO_MAX)
                    .findFirst()
                    .getAsInt();
        }


        if (crow.getLocalizacao().getLatitude().compareTo(crow.getDestino().getLatitude()) > 0) {
            return new BigDecimal(variacao * -1).divide(new BigDecimal(10000)).doubleValue();
        }

        return new BigDecimal(variacao).divide(new BigDecimal(10000)).doubleValue();

    }

    public void add(Crow crow) {
        fakeDatabase.add(crow);
        this.gerarPosicao();
    }
}
