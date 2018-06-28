package com.ssi.ssi.service;

import com.ssi.ssi.domain.model.AccidentAgent;
import com.ssi.ssi.domain.repository.AccidentAgentRepository;
import com.ssi.ssi.resources.AccidentAgentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccidentAgentService 
{

    @Autowired
    private AccidentAgentRepository accidentAgentRepository;

    public Optional<AccidentAgent> findAccidentAgentById(Long id) 
	{
        return accidentAgentRepository.findById(id);
    }


    public AccidentAgent createAccidentAgent(AccidentAgentResource accidentAgentResource)
	 {
        Long accidentAgentId = accidentAgentRepository.createAccidentAgent(accidentAgentResource.getAgentName());
        return accidentAgentRepository.getAccidentAgent(accidentAgentId);
    }

    public Boolean updateAccidentAgent(AccidentAgent accidentAgent) 
	{

        Boolean wasUpdated = Boolean.FALSE;

        Optional<AccidentAgent> accidentAgentDb = findAccidentAgentById(accidentAgent.getId());
        if (accidentAgentDb.isPresent()) 
		{
            accidentAgentDb.get().setAgentName(accidentAgent.getAgentName());
            accidentAgentRepository.save(accidentAgentDb.get());
            wasUpdated = Boolean.TRUE;
        }

        return wasUpdated;
    }

    public List<AccidentAgent> getAllAccidentAgent() 
	{
        return accidentAgentRepository.getAllAccidentAgent();
    }

    public void delete(Long id) 
	{
        Optional<AccidentAgent> accidentAgentDb = findAccidentAgentById(id);
        if (accidentAgentDb.isPresent()) 
		{
            accidentAgentDb.get().setIsDeleted(Boolean.TRUE);
            accidentAgentRepository.save(accidentAgentDb.get());
        }
    }

    public AccidentAgentResource builderAccidentAgentResource(AccidentAgent accidentAgent) 
	{
        return new AccidentAgentResource(accidentAgent);
    }
}