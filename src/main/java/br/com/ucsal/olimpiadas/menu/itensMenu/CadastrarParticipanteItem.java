package br.com.ucsal.olimpiadas.menu.itensMenu;

import br.com.ucsal.olimpiadas.domain.repository.IRepository.IParticipanteRepository;
import br.com.ucsal.olimpiadas.service.ParticipanteService;

import java.util.Scanner;

public class CadastrarParticipanteItem implements ItemMenu {
    private final String descricao = "Cadastrar participante";

    private final IParticipanteRepository participanteRepository;
    private final Scanner in;

    ParticipanteService participanteService = new ParticipanteService();

    public CadastrarParticipanteItem(IParticipanteRepository participanteRepository, Scanner in) {
        this.participanteRepository = participanteRepository;
        this.in = in;
    }

    @Override
    public void action() {
        participanteService.cadastrarParticipante(in, participanteRepository);
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }
}
