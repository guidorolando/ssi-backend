package com.ssi.ssi.service;

import com.ssi.ssi.domain.model.LesionType;
import com.ssi.ssi.domain.repository.LesionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LesionTypeService {

    @Autowired
    private LesionTypeRepository lesionTypeRepository;

    public Optional<LesionType> findLesionTypeById(Long id){
        return lesionTypeRepository.findById(id);
    }


    public LesionType createLesionType(LesionType lesionType) {
        return lesionTypeRepository.save(lesionType);
    }

    public Boolean updateLesionType(LesionType lesionType) {

        Boolean wasUpdated = Boolean.FALSE;

        Optional<LesionType> lesionTypeDb = findLesionTypeById(lesionType.getId());
        if (lesionTypeDb.isPresent()) {
            lesionTypeDb.get().setType(lesionType.getType());
            lesionTypeDb.get().setDescription(lesionType.getDescription());
            lesionTypeRepository.save(lesionTypeDb.get());
            wasUpdated = Boolean.TRUE;
        }

        return wasUpdated;
    }

    public List<LesionType> getAllLesionTypes() {
        return (List<LesionType>) lesionTypeRepository.findAll();
    }
}
