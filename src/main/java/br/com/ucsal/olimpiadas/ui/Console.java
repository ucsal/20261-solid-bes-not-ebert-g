package br.com.ucsal.olimpiadas.ui;

import br.com.ucsal.olimpiadas.domain.repository.ParticipanteRepository;
import br.com.ucsal.olimpiadas.domain.repository.ProvaRepository;

import java.util.Scanner;

public class Console {
    private final ParticipanteRepository participanteRepository;
    private final ProvaRepository provaRepository;
    private final Scanner in;

    public Console(ParticipanteRepository participanteRepository, ProvaRepository provaRepository, Scanner in) {
        this.participanteRepository = participanteRepository;
        this.provaRepository = provaRepository;
        this.in = in;
    }

    public Long escolherProva() {
        System.out.println("\nProvas:");
        for (var p : provaRepository.buscaProvas()) {
            System.out.printf("  %d) %s%n", p.getId(), p.getTitulo());
        }
        System.out.print("Escolha o id da prova: ");

        try {
            long id = Long.parseLong(in.nextLine());
            boolean existe = provaRepository.buscaProvas().stream().anyMatch(p -> p.getId() == id);
            if (!existe) {
                System.out.println("id inválido");
                return null;
            }
            return id;
        } catch (Exception e) {
            System.out.println("entrada inválida");

            return null;
        }
    }

    public Long escolherParticipante() {
        System.out.println("\nParticipantes:");
        for (var p : participanteRepository.buscarPartipantes()) {
            System.out.printf("  %d) %s%n", p.getId(), p.getNome());
        }
        System.out.print("Escolha o id do participante: ");

        try {
            long id = Long.parseLong(in.nextLine());
            boolean existe = participanteRepository.buscarPartipantes().stream().anyMatch(p -> p.getId() == id);
            if (!existe) {
                System.out.println("id inválido");
                return null;
            }
            return id;
        } catch (Exception e) {
            System.out.println("entrada inválida");
            return null;
        }
    }

    public void imprimirTabuleiroFen(String fen) {

        String parteTabuleiro = fen.split(" ")[0];
        String[] ranks = parteTabuleiro.split("/");

        System.out.println();
        System.out.println("    a b c d e f g h");
        System.out.println("   -----------------");

        for (int r = 0; r < 8; r++) {

            String rank = ranks[r];
            System.out.print((8 - r) + " | ");

            for (char c : rank.toCharArray()) {

                if (Character.isDigit(c)) {
                    int vazios = c - '0';
                    for (int i = 0; i < vazios; i++) {
                        System.out.print(". ");
                    }
                } else {
                    System.out.print(c + " ");
                }
            }

            System.out.println("| " + (8 - r));
        }

        System.out.println("   -----------------");
        System.out.println("    a b c d e f g h");
        System.out.println();
    }
}
