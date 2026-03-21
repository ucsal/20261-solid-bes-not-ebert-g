package br.com.ucsal.olimpiadas.domain.repository;

import br.com.ucsal.olimpiadas.domain.entity.Tentativa;

import java.util.ArrayList;
import java.util.List;

public class TentativaRepository {
    private final List<Tentativa> tentativas = new ArrayList<>();
    private long proximaTentativaId = 0;

    public void salvaTentativa(Tentativa tentativa) {
        this.tentativas.add(tentativa);
        this.proximaTentativaId++;
    }

    public List<Tentativa> buscaTentativas() {
        return this.tentativas;
    }
    public Long proximaTentativa() {
        return this.proximaTentativaId;
    }

}
