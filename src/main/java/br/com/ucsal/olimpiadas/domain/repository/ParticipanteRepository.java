package br.com.ucsal.olimpiadas.domain.repository;

import br.com.ucsal.olimpiadas.domain.entity.Participante;

import java.util.ArrayList;
import java.util.List;

public class ParticipanteRepository {
    private final List<Participante> participantes = new ArrayList<>();
    private long proximoParticipanteId = 0;



    public void salvarParticipante (Participante participante) {
        participantes.add(participante);
        proximoParticipanteId++;
    }

    public boolean isEmpty () {
        return  participantes.isEmpty();
    }

    public List<Participante> buscarPartipantes() {
        return participantes;
    }

    public Long proximoParticipante () {
        return this.proximoParticipanteId;
    }
}
