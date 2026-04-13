package br.com.ucsal.olimpiadas.menu.itensMenu;

import br.com.ucsal.olimpiadas.domain.entity.Questao;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IProvaRepository;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IQuestaoRepository;
import br.com.ucsal.olimpiadas.ui.UiConsole;

import java.util.Scanner;

public class CadastrarQuestaoItem implements ItemMenu {
    private final String descricao = "Cadastrar questão (A–E) em uma prova\"";

    private final IQuestaoRepository IQuestaoRepository;
    private final IProvaRepository provaRepository;
    private final UiConsole uiConsole;
    private final Scanner in;


    public CadastrarQuestaoItem(IQuestaoRepository IQuestaoRepository, IProvaRepository provaRepository, UiConsole uiConsole, Scanner in) {
        this.IQuestaoRepository = IQuestaoRepository;
        this.provaRepository = provaRepository;
        this.uiConsole = uiConsole;
        this.in = in;
    }

    private void cadastrarQuestao() {
        if (provaRepository.isEmpty()) {
            System.out.println("não há provas cadastradas");
            return;
        }

        var provaId = uiConsole.escolherProva();
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
        q.setId(IQuestaoRepository.proximaQuestao() + 1);
        q.setProvaId(provaId);
        q.setEnunciado(enunciado);
        q.setAlternativas(alternativas);
        q.setAlternativaCorreta(correta);

        IQuestaoRepository.salvarQuestao(q);

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
