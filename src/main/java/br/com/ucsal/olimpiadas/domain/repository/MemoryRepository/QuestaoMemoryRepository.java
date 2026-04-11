package br.com.ucsal.olimpiadas.domain.repository.MemoryRepository;

import br.com.ucsal.olimpiadas.domain.entity.Questao;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IQuestaoRepository;

import java.util.ArrayList;
import java.util.List;

public class QuestaoMemoryRepository implements IQuestaoRepository {
    private final List<Questao> questoes = new ArrayList<>();
    private long proximaQuestaoId = 0;

    @Override
    public void salvarQuestao(Questao questao) {
        this.questoes.add(questao);
        this.proximaQuestaoId++;
    }

    @Override
    public List<Questao> buscarQuestoes() {
        return this.questoes;
    }

    @Override
    public Long proximaQuestao() {
        return this.proximaQuestaoId;
    }

}
