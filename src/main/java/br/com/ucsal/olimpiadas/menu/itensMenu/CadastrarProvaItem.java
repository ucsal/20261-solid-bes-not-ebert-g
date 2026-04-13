package br.com.ucsal.olimpiadas.menu.itensMenu;

import br.com.ucsal.olimpiadas.domain.repository.IRepository.IProvaRepository;
import br.com.ucsal.olimpiadas.service.ProvaService;

import java.util.Scanner;

public class CadastrarProvaItem implements ItemMenu {
    private final String descricao = "Cadastrar prova";

    private final IProvaRepository provaRepository;
    private final Scanner in;

    ProvaService provaService = new ProvaService();

    public CadastrarProvaItem(IProvaRepository provaRepository, Scanner in) {
        this.provaRepository = provaRepository;
        this.in = in;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public void action() {
        System.out.print("Título da prova: ");
        var titulo = in.nextLine();

        if (titulo == null || titulo.isBlank()) {
            System.out.println("título inválido");
            return;
        }
        provaService.cadastrarProva(provaRepository, titulo);
    }
}
