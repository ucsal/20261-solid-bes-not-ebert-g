package br.com.ucsal.olimpiadas.menu.itensMenu;

import br.com.ucsal.olimpiadas.domain.entity.Questao;
import br.com.ucsal.olimpiadas.domain.repository.ProvaRepository;
import br.com.ucsal.olimpiadas.domain.repository.QuestaoRepository;
import br.com.ucsal.olimpiadas.ui.Console;

import java.util.Scanner;

public class CadastrarQuestaoItem implements ItemMenu {
    private final String descricao = "Cadastrar questão (A–E) em uma prova\"";

    private final QuestaoRepository questaoRepository;
    private final ProvaRepository provaRepository;
    private final Console console;
    private final Scanner in;


    public CadastrarQuestaoItem(QuestaoRepository questaoRepository, ProvaRepository provaRepository, Console console, Scanner in) {
        this.questaoRepository = questaoRepository;
        this.provaRepository = provaRepository;
        this.console = console;
        this.in = in;
    }

    private void cadastrarQuestao() {
        if (provaRepository.isEmpty()) {
            System.out.println("não há provas cadastradas");
            return;
        }

        var provaId = console.escolherProva();
        if (provaId == null)
            return;

        System.out.println("Enunciado:");
        var enunciado = in.nextLine();

        var alternativas = new String[5];
        for (int i = 0; i < 5; i++) {
            char letra = (char) ('A' + i);
            System.out.print("Alternativa " + letra + ": ");
            alternativas[i] = letra + ") " + in.nextLine();
        }

        System.out.print("Alternativa correta (A–E): ");
        char correta;
        try {
            correta = Questao.normalizar(in.nextLine().trim().charAt(0));
        } catch (Exception e) {
            System.out.println("alternativa inválida");
            return;
        }

        var q = new Questao();
        q.setId(questaoRepository.proximaQuestao() + 1);
        q.setProvaId(provaId);
        q.setEnunciado(enunciado);
        q.setAlternativas(alternativas);
        q.setAlternativaCorreta(correta);

        questaoRepository.salvarQuestao(q);

        System.out.println("Questão cadastrada: " + q.getId() + " (na prova " + provaId + ")");
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public void action() {
        this.cadastrarQuestao();
    }
}
