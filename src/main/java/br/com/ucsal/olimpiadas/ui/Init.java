package br.com.ucsal.olimpiadas.ui;

import br.com.ucsal.olimpiadas.domain.entity.Prova;
import br.com.ucsal.olimpiadas.domain.entity.Questao;
import br.com.ucsal.olimpiadas.domain.repository.ProvaRepository;
import br.com.ucsal.olimpiadas.domain.repository.QuestaoRepository;

public class Init {
    private final ProvaRepository provaRepository;
    private final QuestaoRepository questaoRepository;

    public Init(ProvaRepository provaRepository, QuestaoRepository questaoRepository) {
        this.provaRepository = provaRepository;
        this.questaoRepository = questaoRepository;
    }

    public void seed() {

        var prova = new Prova();
        prova.setId(provaRepository.proximaProva() + 1);
        prova.setTitulo("Olimpíada 2026 • Nível 1 • Prova A");
        provaRepository.salvarProva(prova);

        var q1 = new Questao();
        q1.setId(questaoRepository.proximaQuestao() + 1);
        q1.setProvaId(prova.getId());

        q1.setEnunciado("""
                Questão 1 — Mate em 1.
                É a vez das brancas.
                Encontre o lance que dá mate imediatamente.
                """);

        q1.setFenInicial("6k1/5ppp/8/8/8/7Q/6PP/6K1 w - - 0 1");

        q1.setAlternativas(new String[]{"A) Qh7#", "B) Qf5#", "C) Qc8#", "D) Qh8#", "E) Qe6#"});

        q1.setAlternativaCorreta('C');

        questaoRepository.salvarQuestao(q1);
    }

}
