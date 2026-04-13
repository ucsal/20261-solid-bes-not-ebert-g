package br.com.ucsal.olimpiadas.service;

import br.com.ucsal.olimpiadas.domain.entity.Questao;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IQuestaoRepository;

public class QuestaoService {

    public Questao cadastrarQuestao(IQuestaoRepository questaoRepository, Long provaId, String enunciado, String[] alternativas, char correta) {

        var q = new Questao();
        q.setId(questaoRepository.proximaQuestao() + 1);
        q.setProvaId(provaId);
        q.setEnunciado(enunciado);
        q.setAlternativas(alternativas);
        q.setAlternativaCorreta(correta);

        questaoRepository.salvarQuestao(q);

        return q;
    }
}
