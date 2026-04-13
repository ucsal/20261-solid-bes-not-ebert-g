package br.com.ucsal.olimpiadas.service;

import br.com.ucsal.olimpiadas.domain.entity.Prova;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IProvaRepository;

public class ProvaService {

    public void cadastrarProva(IProvaRepository provaRepository, String titulo) {

        var prova = new Prova();
        prova.setId(provaRepository.proximaProva() + 1);
        prova.setTitulo(titulo);

        provaRepository.salvarProva(prova);
        System.out.println("Prova criada: " + prova.getId());
    }
}
