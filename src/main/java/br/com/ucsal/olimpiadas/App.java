package br.com.ucsal.olimpiadas;

import br.com.ucsal.olimpiadas.domain.repository.IRepository.IParticipanteRepository;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IProvaRepository;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IQuestaoRepository;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.ITentativaRepository;
import br.com.ucsal.olimpiadas.domain.repository.MemoryRepository.ParticipanteMemoryRepository;
import br.com.ucsal.olimpiadas.domain.repository.MemoryRepository.ProvaMemoryRepository;
import br.com.ucsal.olimpiadas.domain.repository.MemoryRepository.QuestaoMemoryRepository;
import br.com.ucsal.olimpiadas.domain.repository.MemoryRepository.TentativaMemoryRepository;
import br.com.ucsal.olimpiadas.initialization.InitLoop;
import br.com.ucsal.olimpiadas.initialization.ItemDeclaration;
import br.com.ucsal.olimpiadas.initialization.Seed;
import br.com.ucsal.olimpiadas.menu.Menu;
import br.com.ucsal.olimpiadas.menu.itensMenu.ItemMenu;
import br.com.ucsal.olimpiadas.service.PontuacaoService;
import br.com.ucsal.olimpiadas.ui.UiConsole;

import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        Menu menu = new Menu();

        IParticipanteRepository participanteRepository = new ParticipanteMemoryRepository();
        IProvaRepository provaRepository = new ProvaMemoryRepository();
        IQuestaoRepository questaoRepository = new QuestaoMemoryRepository();
        ITentativaRepository tentativaRepository = new TentativaMemoryRepository();

        PontuacaoService pontuacaoService = new PontuacaoService();
        UiConsole uiConsole = new UiConsole(participanteRepository, provaRepository, in);
        final Seed seed = new Seed(provaRepository, questaoRepository);
        final Map<String, ItemMenu> itemMenu
                = ItemDeclaration.decItem(in, participanteRepository, provaRepository, questaoRepository, uiConsole, tentativaRepository, pontuacaoService);

        InitLoop.start(seed, menu, itemMenu, in);

    }


}