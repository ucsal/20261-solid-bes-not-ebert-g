package br.com.ucsal.olimpiadas.domain.repository.MemoryRepository;

import br.com.ucsal.olimpiadas.domain.entity.Participante;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IParticipanteRepository;

import java.util.ArrayList;
import java.util.List;

public class ParticipanteMemoryRepository implements IParticipanteRepository {
    private final List<Participante> participantes = new ArrayList<>();
    private long proximoParticipanteId = 0;

    @Override
    public void salvarParticipante(Participante participante) {
        participantes.add(participante);
        proximoParticipanteId++;
    }

    @Override
    public boolean isEmpty() {
        return participantes.isEmpty();
    }

    @Override
    public List<Participante> buscarPartipantes() {
        return participantes;
    }

    @Override
    public Long proximoParticipante() {
        return this.proximoParticipanteId;
    }
}
