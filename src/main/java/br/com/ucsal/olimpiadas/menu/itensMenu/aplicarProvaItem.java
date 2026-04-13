package br.com.ucsal.olimpiadas.menu.itensMenu;

import br.com.ucsal.olimpiadas.domain.repository.IRepository.IParticipanteRepository;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IProvaRepository;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IQuestaoRepository;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.ITentativaRepository;
import br.com.ucsal.olimpiadas.service.AplicarProvaService;
import br.com.ucsal.olimpiadas.service.PontuacaoService;
import br.com.ucsal.olimpiadas.ui.UiConsole;

import java.util.Scanner;

public class aplicarProvaItem implements ItemMenu {
    private final String descricao = "Aplicar prova (selecionar participante + prova)";

    private final IParticipanteRepository participanteRepository;
    private final IQuestaoRepository questaoRepository;
    private final IProvaRepository provaRepository;
    private final ITentativaRepository tentativaRepository;
    private final PontuacaoService pontuacaoService;
    private final UiConsole uiConsole;
    private final Scanner in;
    AplicarProvaService aplicarProvaService = new AplicarProvaService();

    public aplicarProvaItem(IParticipanteRepository participanteRepository, IQuestaoRepository questaoRepository, IProvaRepository provaRepository, ITentativaRepository tentativaRepository, PontuacaoService pontuacaoService, UiConsole uiConsole, Scanner in) {
        this.participanteRepository = participanteRepository;
        this.questaoRepository = questaoRepository;
        this.provaRepository = provaRepository;
        this.tentativaRepository = tentativaRepository;
        this.pontuacaoService = pontuacaoService;
        this.uiConsole = uiConsole;
        this.in = in;
        this.aplicarProvaService = aplicarProvaService;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public void action() {
        aplicarProvaService.aplicarProva(in, provaRepository, participanteRepository, uiConsole, questaoRepository, tentativaRepository, pontuacaoService);
    }
}
