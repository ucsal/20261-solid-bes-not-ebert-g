package br.com.ucsal.olimpiadas.domain.repository.MemoryRepository;

import br.com.ucsal.olimpiadas.domain.entity.Prova;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IProvaRepository;

import java.util.ArrayList;
import java.util.List;

public class ProvaMemoryRepository implements IProvaRepository {
    private final List<Prova> provas = new ArrayList<>();
    private long proximaProvaId = 0;

    @Override
    public void salvarProva(Prova prova) {
        this.provas.add(prova);
        this.proximaProvaId++;
    }

    @Override
    public Long proximaProva() {
        return this.proximaProvaId;
    }

    @Override
    public Boolean isEmpty() {
        return this.provas.isEmpty();
    }

    @Override
    public List<Prova> buscaProvas() {
        return this.provas;
    }
}
