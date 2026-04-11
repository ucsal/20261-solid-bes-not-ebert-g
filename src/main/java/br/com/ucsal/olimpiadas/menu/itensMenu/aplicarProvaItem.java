package br.com.ucsal.olimpiadas.menu.itensMenu;

import br.com.ucsal.olimpiadas.domain.entity.Questao;
import br.com.ucsal.olimpiadas.domain.entity.Resposta;
import br.com.ucsal.olimpiadas.domain.entity.Tentativa;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IParticipanteRepository;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IProvaRepository;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IQuestaoRepository;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.ITentativaRepository;
import br.com.ucsal.olimpiadas.service.PontuacaoService;
import br.com.ucsal.olimpiadas.ui.Console;

import java.util.Scanner;

public class aplicarProvaItem implements ItemMenu {
    private final String descricao = "Aplicar prova (selecionar participante + prova)";
    private final IParticipanteRepository participanteRepository;
    private final IQuestaoRepository IQuestaoRepository;
    private final IProvaRepository provaRepository;
    private final ITentativaRepository ITentativaRepository;
    private final PontuacaoService pontuacaoService;
    private final Console console;
    private final Scanner in;


    public aplicarProvaItem(IParticipanteRepository participanteRepository, IQuestaoRepository IQuestaoRepository, IProvaRepository provaRepository, ITentativaRepository ITentativaRepository, PontuacaoService pontuacaoService, Console console, Scanner in) {
        this.participanteRepository = participanteRepository;
        this.IQuestaoRepository = IQuestaoRepository;
        this.provaRepository = provaRepository;
        this.ITentativaRepository = ITentativaRepository;
        this.pontuacaoService = pontuacaoService;
        this.console = console;
        this.in = in;
    }

    public void aplicarProva() {
        if (participanteRepository.isEmpty()) {
            System.out.println("cadastre participantes primeiro");
            return;
        }
        if (provaRepository.isEmpty()) {
            System.out.println("cadastre provas primeiro");
            return;
        }

        var participanteId = console.escolherParticipante();
        if (participanteId == null)
            return;

        var provaId = console.escolherProva();
        if (provaId == null)
            return;

        var questoesDaProva = IQuestaoRepository.buscarQuestoes().stream().filter(q -> q.getProvaId() == provaId).toList();

        if (questoesDaProva.isEmpty()) {
            System.out.println("esta prova não possui questões cadastradas");
            return;
        }

        var tentativa = new Tentativa();
        tentativa.setId(ITentativaRepository.proximaTentativa() + 1);
        tentativa.setParticipanteId(participanteId);
        tentativa.setProvaId(provaId);

        System.out.println("\n--- Início da Prova ---");

        for (var q : questoesDaProva) {
            System.out.println("\nQuestão #" + q.getId());
            System.out.println(q.getEnunciado());

            System.out.println("Posição inicial:");
            console.imprimirTabuleiroFen(q.getFenInicial());

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

        ITentativaRepository.salvaTentativa(tentativa);

        int nota = pontuacaoService.calcularNota(tentativa);
        System.out.println("\n--- Fim da Prova ---");
        System.out.println("Nota (acertos): " + nota + " / " + tentativa.getRespostas().size());
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public void action() {
        this.aplicarProva();
    }
}
