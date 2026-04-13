package br.com.ucsal.olimpiadas.menu.itensMenu;

import br.com.ucsal.olimpiadas.domain.repository.IRepository.ITentativaRepository;
import br.com.ucsal.olimpiadas.service.PontuacaoService;
import br.com.ucsal.olimpiadas.service.TentativaService;

public class ListaTentativasItem implements ItemMenu {
    private final String descricao = "Listar tentativas (resumo)";
    private final ITentativaRepository tentativaRepository;
    private final PontuacaoService pontuacaoService;

    private final TentativaService tentativaService = new TentativaService();

    public ListaTentativasItem(ITentativaRepository tentativaRepository, PontuacaoService pontuacaoService) {
        this.tentativaRepository = tentativaRepository;
        this.pontuacaoService = pontuacaoService;
    }

    @Override
    public void action() {
        tentativaService.listarTentativas(tentativaRepository, pontuacaoService);
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

}
