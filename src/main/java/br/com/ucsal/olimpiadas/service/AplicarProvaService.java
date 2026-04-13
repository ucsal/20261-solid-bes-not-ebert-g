package br.com.ucsal.olimpiadas.service;

import br.com.ucsal.olimpiadas.domain.entity.Questao;
import br.com.ucsal.olimpiadas.domain.entity.Resposta;
import br.com.ucsal.olimpiadas.domain.entity.Tentativa;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IParticipanteRepository;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IProvaRepository;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IQuestaoRepository;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.ITentativaRepository;
import br.com.ucsal.olimpiadas.ui.UiConsole;

import java.util.Scanner;

public class AplicarProvaService {

    public void aplicarProva(Scanner in, IProvaRepository provaRepository, IParticipanteRepository participanteRepository, UiConsole uiConsole, IQuestaoRepository questaoRepository, ITentativaRepository tentativaRepository, PontuacaoService pontuacaoService) {
        if (participanteRepository.isEmpty()) {
            System.out.println("cadastre participantes primeiro");
            return;
        }
        if (provaRepository.isEmpty()) {
            System.out.println("cadastre provas primeiro");
            return;
        }

        var participanteId = uiConsole.escolherParticipante();
        if (participanteId == null)
            return;

        var provaId = uiConsole.escolherProva();
        if (provaId == null)
            return;

        var questoesDaProva = questaoRepository.buscarQuestoes().stream().filter(q -> q.getProvaId() == provaId).toList();

        if (questoesDaProva.isEmpty()) {
            System.out.println("esta prova não possui questões cadastradas");
            return;
        }

        var tentativa = new Tentativa();
        tentativa.setId(tentativaRepository.proximaTentativa() + 1);
        tentativa.setParticipanteId(participanteId);
        tentativa.setProvaId(provaId);

        System.out.println("\n--- Início da Prova ---");

        for (var q : questoesDaProva) {
            System.out.println("\nQuestão #" + q.getId());
            System.out.println(q.getEnunciado());

            System.out.println("Posição inicial:");
            uiConsole.imprimirTabuleiroFen(q.getFenInicial());

            for (var alt : q.getAlternativas()) {
                System.out.println(alt);
            }

            System.out.print("Sua resposta (A–E): ");
            char marcada;
            try {
                marcada = Questao.normalizar(in.nextLine().trim().charAt(0));
            } catch (Exception e) {
                System.out.println("resposta inválida (marcando como errada)");
                marcada = 'X';
            }

            var r = new Resposta();
            r.setQuestaoId(q.getId());
            r.setAlternativaMarcada(marcada);
            r.setCorreta(q.isRespostaCorreta(marcada));

            tentativa.getRespostas().add(r);
        }

        tentativaRepository.salvaTentativa(tentativa);

        int nota = pontuacaoService.calcularNota(tentativa);
        System.out.println("\n--- Fim da Prova ---");
        System.out.println("Nota (acertos): " + nota + " / " + tentativa.getRespostas().size());
    }
}
