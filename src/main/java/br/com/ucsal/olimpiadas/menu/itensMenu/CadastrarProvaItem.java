package br.com.ucsal.olimpiadas.menu.itensMenu;

import br.com.ucsal.olimpiadas.domain.entity.Prova;
import br.com.ucsal.olimpiadas.domain.repository.ProvaRepository;

import java.util.Scanner;

public class CadastrarProvaItem implements ItemMenu {
    private final String descricao = "Cadastrar prova";
    private final ProvaRepository provaRepository;
    private final Scanner in;


    public CadastrarProvaItem(ProvaRepository provaRepository, Scanner in) {
        this.provaRepository = provaRepository;
        this.in = in;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public void action() {
        this.cadastrarProva();
    }

    private void cadastrarProva() {
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
