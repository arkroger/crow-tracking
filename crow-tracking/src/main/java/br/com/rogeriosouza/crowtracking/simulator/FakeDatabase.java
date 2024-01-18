package br.com.rogeriosouza.crowtracking.simulator;

import br.com.rogeriosouza.crowtracking.monitor.model.Crow;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class FakeDatabase {

    private static final List<Crow> CROWS = new ArrayList<>();

    public void add(Crow crow) {
        CROWS.add(crow);
    }

    public List<Crow> getCrows() {
        return CROWS;
    }


}
