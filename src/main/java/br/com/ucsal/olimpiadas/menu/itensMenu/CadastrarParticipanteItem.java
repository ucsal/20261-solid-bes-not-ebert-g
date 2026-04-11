package br.com.ucsal.olimpiadas.menu.itensMenu;

import br.com.ucsal.olimpiadas.domain.entity.Participante;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IParticipanteRepository;

import java.util.Scanner;

public class CadastrarParticipanteItem implements ItemMenu {
    private final String descricao = "Cadastrar participante";
    private final IParticipanteRepository participanteRepository;
    private final Scanner in;


    public CadastrarParticipanteItem(IParticipanteRepository participanteRepository, Scanner in) {
        this.participanteRepository = participanteRepository;
        this.in = in;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public void action() {
        this.cadastrarParticipante();
    }

    private void cadastrarParticipante() {
        System.out.print("Nome: ");
        var nome = in.nextLine();

        System.out.print("Email (opcional): ");
        var email = in.nextLine();

        if (nome == null || nome.isBlank()) {
            System.out.println("nome inválido");
            return;
        }

        var p = new Participante();
        p.setId(participanteRepository.proximoParticipante() + 1);
        p.setNome(nome);
        p.setEmail(email);

        participanteRepository.salvarParticipante(p);
        System.out.println("Participante cadastrado: " + p.getId());
    }
}
