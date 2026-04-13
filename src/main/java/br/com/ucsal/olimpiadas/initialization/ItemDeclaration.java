package br.com.ucsal.olimpiadas.initialization;

import br.com.ucsal.olimpiadas.domain.repository.IRepository.IParticipanteRepository;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IProvaRepository;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IQuestaoRepository;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.ITentativaRepository;
import br.com.ucsal.olimpiadas.menu.itensMenu.*;
import br.com.ucsal.olimpiadas.service.PontuacaoService;
import br.com.ucsal.olimpiadas.ui.UiConsole;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ItemDeclaration {

    public static Map<String, ItemMenu> decItem(Scanner in, IParticipanteRepository participanteRepository, IProvaRepository provaRepository, IQuestaoRepository IQuestaoRepository, UiConsole uiConsole, ITentativaRepository tentativaRepository, PontuacaoService pontuacaoService) {

        Map<String, ItemMenu> itemMenu = new HashMap<>();

        itemMenu.put("1", new CadastrarParticipanteItem(participanteRepository, in));
        itemMenu.put("2", new CadastrarProvaItem(provaRepository, in));
        itemMenu.put("3", new CadastrarQuestaoItem(IQuestaoRepository, provaRepository, uiConsole, in));
        itemMenu.put("4", new aplicarProvaItem(participanteRepository, IQuestaoRepository, provaRepository, tentativaRepository, pontuacaoService, uiConsole, in));
        itemMenu.put("5", new ListaTentativasItem(tentativaRepository, pontuacaoService));

        return itemMenu;
    }
}
