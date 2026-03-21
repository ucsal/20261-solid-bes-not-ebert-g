package br.com.ucsal.olimpiadas;

import br.com.ucsal.olimpiadas.menu.*;
import br.com.ucsal.olimpiadas.domain.repository.ParticipanteRepository;
import br.com.ucsal.olimpiadas.domain.repository.ProvaRepository;
import br.com.ucsal.olimpiadas.domain.repository.QuestaoRepository;
import br.com.ucsal.olimpiadas.domain.repository.TentativaRepository;
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
    private ParticipanteRepository participanteRepository = new ParticipanteRepository();
    private ProvaRepository provaRepository = new ProvaRepository();
    private QuestaoRepository questaoRepository = new QuestaoRepository();
    private TentativaRepository tentativaRepository = new TentativaRepository();
    private PontuacaoService pontuacaoService = new PontuacaoService();
    private Console console = new Console(participanteRepository, provaRepository, in);
    private final Map<String, ItemMenu> itemMenu
            = new HashMap<>();
    private final Init init = new Init(provaRepository, questaoRepository);

    public App() {
        itemMenu.put("1", new CadastrarParticipanteItem(participanteRepository, in));
        itemMenu.put("2", new CadastrarProvaItem(provaRepository, in));
        itemMenu.put("3", new CadastrarQuestaoItem(questaoRepository, provaRepository, console, in));
        itemMenu.put("4", new aplicarProvaItem(participanteRepository, questaoRepository, provaRepository, tentativaRepository, pontuacaoService, console, in));
        itemMenu.put("5", new ListaTentativasItem(tentativaRepository, pontuacaoService));
    }

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