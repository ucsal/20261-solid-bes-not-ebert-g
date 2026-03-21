package br.com.ucsal.olimpiadas.menu.itensMenu;

import br.com.ucsal.olimpiadas.domain.repository.TentativaRepository;
import br.com.ucsal.olimpiadas.service.PontuacaoService;

public class ListaTentativasItem implements ItemMenu {
    private final String descricao = "Listar tentativas (resumo)";

    private final TentativaRepository tentativaRepository;
    private final PontuacaoService pontuacaoService;

    public ListaTentativasItem(TentativaRepository tentativaRepository, PontuacaoService pontuacaoService) {
        this.tentativaRepository = tentativaRepository;
        this.pontuacaoService = pontuacaoService;
    }

    private void listarTentativas() {
        System.out.println("\n--- Tentativas ---");
        for (var t : tentativaRepository.buscaTentativas()) {
            System.out.printf("#%d | participante=%d | prova=%d | nota=%d/%d%n", t.getId(), t.getParticipanteId(),
                    t.getProvaId(), pontuacaoService.calcularNota(t), t.getRespostas().size());
        }
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public void action() {
        this.listarTentativas();
    }
}
