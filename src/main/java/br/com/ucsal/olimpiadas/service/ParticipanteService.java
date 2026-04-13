package br.com.ucsal.olimpiadas.service;

import br.com.ucsal.olimpiadas.domain.entity.Participante;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IParticipanteRepository;

import java.util.Scanner;

public class ParticipanteService {

    public void cadastrarParticipante(Scanner in, IParticipanteRepository participanteRepository) {
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
