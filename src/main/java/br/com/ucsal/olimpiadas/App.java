package br.com.ucsal.olimpiadas;

import br.com.ucsal.olimpiadas.domain.repository.IRepository.IParticipanteRepository;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IProvaRepository;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IQuestaoRepository;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.ITentativaRepository;
import br.com.ucsal.olimpiadas.domain.repository.MemoryRepository.ParticipanteMemoryRepository;
import br.com.ucsal.olimpiadas.domain.repository.MemoryRepository.ProvaMemoryRepository;
import br.com.ucsal.olimpiadas.domain.repository.MemoryRepository.QuestaoMemoryRepository;
import br.com.ucsal.olimpiadas.domain.repository.MemoryRepository.TentativaMemoryRepository;
import br.com.ucsal.olimpiadas.menu.Menu;
import br.com.ucsal.olimpiadas.menu.itensMenu.*;
import br.com.ucsal.olimpiadas.service.PontuacaoService;
import br.com.ucsal.olimpiadas.ui.Console;
import br.com.ucsal.olimpiadas.ui.Init;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    private final Scanner in = new Scanner(System.in);
    private Menu menu = new Menu();
    private IParticipanteRepository participanteRepository = new ParticipanteMemoryRepository();
    private IProvaRepository provaRepository = new ProvaMemoryRepository();
    private IQuestaoRepository IQuestaoRepository = new QuestaoMemoryRepository();
    private ITentativaRepository ITentativaRepository = new TentativaMemoryRepository();
    private PontuacaoService pontuacaoService = new PontuacaoService();
    private Console console = new Console(participanteRepository, provaRepository, in);
    private final Map<String, ItemMenu> itemMenu
            = new HashMap<>();
    private final Init init = new Init(provaRepository, IQuestaoRepository);

    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    public App() {
        itemMenu.put("1", new CadastrarParticipanteItem(participanteRepository, in));
        itemMenu.put("2", new CadastrarProvaItem(provaRepository, in));
        itemMenu.put("3", new CadastrarQuestaoItem(IQuestaoRepository, provaRepository, console, in));
        itemMenu.put("4", new aplicarProvaItem(participanteRepository, IQuestaoRepository, provaRepository, ITentativaRepository, pontuacaoService, console, in));
        itemMenu.put("5", new ListaTentativasItem(ITentativaRepository, pontuacaoService));
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