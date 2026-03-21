package br.com.ucsal.olimpiadas.domain.repository;

import br.com.ucsal.olimpiadas.domain.entity.Questao;

import java.util.ArrayList;
import java.util.List;

public class QuestaoRepository {
    private final List<Questao> questoes = new ArrayList<>();
    private long proximaQuestaoId = 0;

    public void salvarQuestao(Questao questao) {
        this.questoes.add(questao);
        this.proximaQuestaoId++;
    }

    public List<Questao> buscarQuestoes() {
        return this.questoes;
    }

    public Long proximaQuestao() {
        return this.proximaQuestaoId;
    }

}
