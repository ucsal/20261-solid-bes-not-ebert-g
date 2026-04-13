package br.com.ucsal.olimpiadas.menu.itensMenu;

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
        questaoService.cadastrarQuestao(provaRepository, uiConsole, in, questaoRepository);
    }
}
