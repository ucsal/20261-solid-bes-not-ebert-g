package br.com.ucsal.olimpiadas.menu.itensMenu;

import br.com.ucsal.olimpiadas.domain.entity.Questao;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IProvaRepository;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IQuestaoRepository;
import br.com.ucsal.olimpiadas.service.QuestaoService;
import br.com.ucsal.olimpiadas.ui.UiConsole;

import java.util.Scanner;

public class CadastrarQuestaoItem implements ItemMenu {
    private final String descricao = "Cadastrar questão (A–E) em uma prova\"";

    private final IQuestaoRepository questaoRepository;
    private final IProvaRepository provaRepository;
    private final UiConsole uiConsole;
    private final Scanner in;

    private final QuestaoService questaoService = new QuestaoService();

    public CadastrarQuestaoItem(IQuestaoRepository questaoRepository, IProvaRepository provaRepository, UiConsole uiConsole, Scanner in) {
        this.questaoRepository = questaoRepository;
        this.provaRepository = provaRepository;
        this.uiConsole = uiConsole;
        this.in = in;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public void action() {
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

        Questao q = questaoService.cadastrarQuestao(questaoRepository, provaId, enunciado, alternativas, correta);

        System.out.println("Questão cadastrada: " + q.getId() + " (na prova " + provaId + ")");
    }
}
