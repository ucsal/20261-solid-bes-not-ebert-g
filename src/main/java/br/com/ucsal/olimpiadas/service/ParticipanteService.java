package br.com.ucsal.olimpiadas.service;

import br.com.ucsal.olimpiadas.domain.entity.Participante;
import br.com.ucsal.olimpiadas.domain.repository.IRepository.IParticipanteRepository;

public class ParticipanteService {

    public Participante cadastrarParticipante(IParticipanteRepository participanteRepository, String nome, String email) {

        var p = new Participante();
        p.setId(participanteRepository.proximoParticipante() + 1);
        p.setNome(nome);
        p.setEmail(email);

        participanteRepository.salvarParticipante(p);

        return p;
    }

}
