package br.com.ucsal.olimpiadas.service;

import br.com.ucsal.olimpiadas.domain.entity.Tentativa;

public class PontuacaoService {
    public static int calcularNota(Tentativa tentativa) {
        int acertos = 0;
        for (var r : tentativa.getRespostas()) {
            if (r.isCorreta())
                acertos++;
        }
        return acertos;
    }
}
