package br.com.ucsal.olimpiadas.domain.repository.IRepository;

import br.com.ucsal.olimpiadas.domain.entity.Questao;

import java.util.List;

public interface IQuestaoRepository {
    void salvarQuestao(Questao questao);

    List<Questao> buscarQuestoes();

    Long proximaQuestao();
}
