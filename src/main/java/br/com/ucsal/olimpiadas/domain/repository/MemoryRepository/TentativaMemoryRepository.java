package br.com.ucsal.olimpiadas.domain.repository.MemoryRepository;

import br.com.ucsal.olimpiadas.domain.entity.Tentativa;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.ITentativaRepository;

import java.util.ArrayList;
import java.util.List;

public class TentativaMemoryRepository implements ITentativaRepository {
    private final List<Tentativa> tentativas = new ArrayList<>();
    private long proximaTentativaId = 0;

    @Override
    public void salvaTentativa(Tentativa tentativa) {
        this.tentativas.add(tentativa);
        this.proximaTentativaId++;
    }

    @Override
    public List<Tentativa> buscaTentativas() {
        return this.tentativas;
    }

    @Override
    public Long proximaTentativa() {
        return this.proximaTentativaId;
    }

}
