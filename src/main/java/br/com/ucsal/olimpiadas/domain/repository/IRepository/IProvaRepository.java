package br.com.ucsal.olimpiadas.domain.repository.IRepository;

import br.com.ucsal.olimpiadas.domain.entity.Prova;

import java.util.List;

public interface IProvaRepository {
    void salvarProva(Prova prova);

    Long proximaProva();

    Boolean isEmpty();

    List<Prova> buscaProvas();
}
