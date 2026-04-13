package br.com.ucsal.olimpiadas.service;

import br.com.ucsal.olimpiadas.domain.entity.Prova;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IProvaRepository;

import java.util.Scanner;

public class ProvaService {

    public void cadastrarProva(IProvaRepository provaRepository, Scanner in) {
        System.out.print("Título da prova: ");
        var titulo = in.nextLine();

        if (titulo == null || titulo.isBlank()) {
            System.out.println("título inválido");
            return;
        }

        var prova = new Prova();
        prova.setId(provaRepository.proximaProva() + 1);
        prova.setTitulo(titulo);

        provaRepository.salvarProva(prova);
        System.out.println("Prova criada: " + prova.getId());
    }
}
