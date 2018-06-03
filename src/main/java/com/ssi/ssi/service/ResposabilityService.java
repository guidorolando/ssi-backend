package com.ssi.ssi.service;

import com.ssi.ssi.domain.model.Capacity;
import com.ssi.ssi.domain.model.Responsibility;
import com.ssi.ssi.domain.repository.ResponsabilityRepository;
import com.ssi.ssi.resources.ResponsabilityResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResposabilityService {


    @Autowired
    private ResponsabilityRepository responsabilityRepository;


    public Responsibility createResponsabilit(Responsibility responsibility) {
        responsibility.setDeleted(false);
        return responsabilityRepository.save(responsibility);
    }

    public Optional<Responsibility> findResponsabilityById(Long id){

        return responsabilityRepository.findById(id);
    }

    public Responsibility createResponsability(ResponsabilityResource responsabilityResource) {
        Responsibility responsibility = new Responsibility();
        responsibility.setName(responsibility.getName());
        responsibility.setDeleted(false);
        responsibility.setDescription(responsibility.getDescription());
        return responsabilityRepository.save(responsibility);
    }



    public Boolean updateResponsabilty(Responsibility responsibility) {

        Boolean wasUpdated = Boolean.FALSE;

        Optional<Responsibility> responsibilityDb = findResponsabilityById(responsibility.getId());
        if (responsibilityDb.isPresent()) {
            responsibilityDb.get().setName(responsibility.getName());
            responsibilityDb.get().setDescription(responsibility.getDescription());
            responsabilityRepository.save(responsibilityDb.get());

            wasUpdated = Boolean.TRUE;
        }
     return wasUpdated;
    }

    public List<Responsibility> getAllResponsability() {
        return (List<Responsibility>) responsabilityRepository.findAll();
    }

}
