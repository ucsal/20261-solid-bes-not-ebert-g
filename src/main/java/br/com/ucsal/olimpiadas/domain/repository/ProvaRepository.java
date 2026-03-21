package br.com.ucsal.olimpiadas.domain.repository;

import br.com.ucsal.olimpiadas.domain.entity.Prova;

import java.util.ArrayList;
import java.util.List;

public class ProvaRepository {
    private final List<Prova> provas = new ArrayList<>();
    private long proximaProvaId = 0;


    public void salvarProva(Prova prova) {
        this.provas.add(prova);
        this.proximaProvaId++;
    }

    public Long proximaProva() {
        return this.proximaProvaId;
    }

    public Boolean isEmpty() {
        return this.provas.isEmpty();
    }

    public List<Prova> buscaProvas() {
        return this.provas;
    }


}
