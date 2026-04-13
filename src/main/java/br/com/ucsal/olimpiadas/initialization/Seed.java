package br.com.ucsal.olimpiadas.initialization;

import br.com.ucsal.olimpiadas.domain.entity.Prova;
import br.com.ucsal.olimpiadas.domain.entity.Questao;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IProvaRepository;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IQuestaoRepository;

public class Seed {
    private final IProvaRepository provaRepository;
    private final IQuestaoRepository IQuestaoRepository;

    public Seed(IProvaRepository provaRepository, IQuestaoRepository IQuestaoRepository) {
        this.provaRepository = provaRepository;
        this.IQuestaoRepository = IQuestaoRepository;
    }

    public void seed() {

        var prova = new Prova();
        prova.setId(provaRepository.proximaProva() + 1);
        prova.setTitulo("Olimpíada 2026 • Nível 1 • Prova A");
        provaRepository.salvarProva(prova);

        var q1 = new Questao();
        q1.setId(IQuestaoRepository.proximaQuestao() + 1);
        q1.setProvaId(prova.getId());

        q1.setEnunciado("""
                Questão 1 — Mate em 1.
                É a vez das brancas.
                Encontre o lance que dá mate imediatamente.
                """);

        q1.setFenInicial("6k1/5ppp/8/8/8/7Q/6PP/6K1 w - - 0 1");

        q1.setAlternativas(new String[]{"A) Qh7#", "B) Qf5#", "C) Qc8#", "D) Qh8#", "E) Qe6#"});

        q1.setAlternativaCorreta('C');

        IQuestaoRepository.salvarQuestao(q1);
    }

}
