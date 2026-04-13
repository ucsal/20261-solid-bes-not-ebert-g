package br.com.ucsal.olimpiadas.service;

import br.com.ucsal.olimpiadas.domain.repository.IRepository.ITentativaRepository;

public class TentativaService {

    public void listarTentativas(ITentativaRepository tentativaRepository, PontuacaoService pontuacaoService) {
        System.out.println("\n--- Tentativas ---");
        for (var t : tentativaRepository.buscaTentativas()) {
            System.out.printf("#%d | participante=%d | prova=%d | nota=%d/%d%n", t.getId(), t.getParticipanteId(),
                    t.getProvaId(), pontuacaoService.calcularNota(t), t.getRespostas().size());
        }
    }

}
