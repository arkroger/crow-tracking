package br.com.rogeriosouza.crowtracking.rastreio;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class RastreioFacade {

    public String novoRastreio() {

        return UUID.randomUUID().toString();
    }
}
