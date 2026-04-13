package br.com.ucsal.olimpiadas.domain.repository.IRepository;

import br.com.ucsal.olimpiadas.domain.entity.Participante;

import java.util.List;

public interface IParticipanteRepository {
    void salvarParticipante(Participante participante);

    boolean isEmpty();

    List<Participante> buscarPartipantes();

    Long proximoParticipante();
}
