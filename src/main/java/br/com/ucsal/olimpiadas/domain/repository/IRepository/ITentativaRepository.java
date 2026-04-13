package br.com.ucsal.olimpiadas.domain.repository.IRepository;

import br.com.ucsal.olimpiadas.domain.entity.Tentativa;

import java.util.List;

public interface ITentativaRepository {
    void salvaTentativa(Tentativa tentativa);

    List<Tentativa> buscaTentativas();

    Long proximaTentativa();
}
