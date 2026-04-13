package br.com.ucsal.olimpiadas;

import br.com.ucsal.olimpiadas.domain.repository.IRepository.IParticipanteRepository;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IProvaRepository;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IQuestaoRepository;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.ITentativaRepository;
import br.com.ucsal.olimpiadas.domain.repository.MemoryRepository.ParticipanteMemoryRepository;
import br.com.ucsal.olimpiadas.domain.repository.MemoryRepository.ProvaMemoryRepository;
import br.com.ucsal.olimpiadas.domain.repository.MemoryRepository.QuestaoMemoryRepository;
import br.com.ucsal.olimpiadas.domain.repository.MemoryRepository.TentativaMemoryRepository;
import br.com.ucsal.olimpiadas.initialization.Init;
import br.com.ucsal.olimpiadas.initialization.ItemDeclaration;
import br.com.ucsal.olimpiadas.menu.Menu;
import br.com.ucsal.olimpiadas.menu.itensMenu.*;
import br.com.ucsal.olimpiadas.service.PontuacaoService;
import br.com.ucsal.olimpiadas.ui.UiConsole;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    private final Scanner in = new Scanner(System.in);

    private Menu menu = new Menu();


    private IParticipanteRepository participanteRepository = new ParticipanteMemoryRepository();
    private IProvaRepository provaRepository = new ProvaMemoryRepository();
    private IQuestaoRepository questaoRepository = new QuestaoMemoryRepository();
    private ITentativaRepository tentativaRepository = new TentativaMemoryRepository();

    private PontuacaoService pontuacaoService = new PontuacaoService();
    private UiConsole uiConsole = new UiConsole(participanteRepository, provaRepository, in);
    private final Init init = new Init(provaRepository, questaoRepository);

    private final Map<String, ItemMenu> itemMenu
            = ItemDeclaration.decItem(in, participanteRepository, provaRepository, questaoRepository, uiConsole, tentativaRepository, pontuacaoService);

    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    private void start() {
        init.seed();
        while (true) {
            menu.mostraMenu(itemMenu);
            String ch = in.nextLine();
            if (ch.equals("0")) {
                System.out.println("Tchau");
                break;
            }
            ItemMenu opcoes = itemMenu.get(ch);
            if (opcoes != null) {
                opcoes.action();
            } else {
                System.out.println("Opção inválida");
            }
        }
    }

}