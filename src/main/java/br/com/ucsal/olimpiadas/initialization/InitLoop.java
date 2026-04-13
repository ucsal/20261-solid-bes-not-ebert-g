package br.com.ucsal.olimpiadas.initialization;

import br.com.ucsal.olimpiadas.menu.Menu;
import br.com.ucsal.olimpiadas.menu.itensMenu.ItemMenu;

import java.util.Map;
import java.util.Scanner;

public class InitLoop {

    public static void start(Seed seed, Menu menu, Map<String, ItemMenu> itemMenu, Scanner in) {
        seed.seed();
        while (true) {
            menu.mostraMenu(itemMenu);
            String ch = in.nextLine();
            if (ch.equals("0")) {
                System.out.println("Tchau");
                break;
            }
            ItemMenu opcoes = itemMenu.get(ch);
            if (opcoes != null) {
                opcoes.action();
            } else {
                System.out.println("Opção inválida");
            }
        }

    }
}
