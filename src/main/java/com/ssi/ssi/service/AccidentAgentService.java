package com.ssi.ssi.service;

import com.ssi.ssi.domain.model.AccidentAgent;
import com.ssi.ssi.domain.repository.AccidentAgentRepository;
import com.ssi.ssi.resources.AccidentAgentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccidentAgentService {

    @Autowired
    private AccidentAgentRepository accidentAgentRepository;

    public Optional<AccidentAgent> findAccidentAgentById(Long id) {
        return accidentAgentRepository.findById(id);
    }


    public AccidentAgent createAccidentAgent(AccidentAgent accidentAgent) {
        accidentAgent.setIsDeleted(false);
        return accidentAgentRepository.save(accidentAgent);
    }

    public Boolean updateAccidentAgent(AccidentAgent accidentAgent) {

        Boolean wasUpdated = Boolean.FALSE;

        Optional<AccidentAgent> accidentAgentDb = findAccidentAgentById(accidentAgent.getId());
        if (accidentAgentDb.isPresent()) {
            accidentAgentDb.get().setAgentName(accidentAgent.getAgentName());
            accidentAgentRepository.save(accidentAgentDb.get());
            wasUpdated = Boolean.TRUE;
        }

        return wasUpdated;
    }

    public List<AccidentAgent> getAllAccidentAgents() {
        return accidentAgentRepository.findAll();
    }

    public void delete(Long id) {
        Optional<AccidentAgent> accidentAgentDb = findAccidentAgentById(id);
        if (accidentAgentDb.isPresent()) {
            accidentAgentDb.get().setIsDeleted(Boolean.TRUE);
            accidentAgentRepository.save(accidentAgentDb.get());
        }
    }

    public AccidentAgentResource builderAccidentAgentResource (AccidentAgent accidentAgent) {
        AccidentAgentResource instance = new AccidentAgentResource(accidentAgent);
        instance.setId(accidentAgent.getId());
        instance.setAgentName(accidentAgent.getAgentName());
        instance.setDeleted(accidentAgent.getIsDeleted());
        return instance;
    }
}
