package com.ssi.ssi.service;

import com.ssi.ssi.domain.model.MaterialType;
import com.ssi.ssi.domain.repository.MaterialTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialTypeService {
    @Autowired
    private MaterialTypeRepository materialTypeRepository;

    public MaterialType save(MaterialType materialType){
        return materialTypeRepository.save(materialType);
    }

    public List<MaterialType> getAll(){
        return (List<MaterialType>) materialTypeRepository.findAll();
    }

    public Optional<MaterialType> getById(Long id){
        return materialTypeRepository.findById(id);
    }

    public void delete(MaterialType materialType){
        materialTypeRepository.delete(materialType);
    }

    public void deleteById(Long id){
        materialTypeRepository.deleteById(id);
    }
}
