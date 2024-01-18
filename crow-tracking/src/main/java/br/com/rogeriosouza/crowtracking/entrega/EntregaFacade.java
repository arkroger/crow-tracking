package br.com.rogeriosouza.crowtracking.entrega;

import br.com.rogeriosouza.crowtracking.rastreio.RastreioFacade;
import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class EntregaFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(EntregaFacade.class);

    private final RastreioFacade rastreioFacade;

    public EntregaFacade(RastreioFacade rastreioFacade) {
        this.rastreioFacade = rastreioFacade;
    }

    public void novaEntrega() {

        String rastreio = this.rastreioFacade.novoRastreio();

        LOGGER.debug("Entrega adicionada Rastreio:{}", rastreio);




    }
}
