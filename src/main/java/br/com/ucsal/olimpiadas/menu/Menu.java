package br.com.ucsal.olimpiadas.menu;

import br.com.ucsal.olimpiadas.menu.itensMenu.ItemMenu;

import java.util.Map;

public class Menu {
    public void mostraMenu(Map<String, ItemMenu> itensMenu) {
        System.out.println("\n=== OLIMPÍADA DE QUESTÕES (V1) ===");

        itensMenu.forEach((id, itemMenu)-> {
            System.out.println(id + ") " +itemMenu.getDescricao());
        });
        System.out.println("0) Sair");
        System.out.print("> ");
    }
}
