package com.ssi.ssi.service;

import com.ssi.ssi.domain.model.Material;
import com.ssi.ssi.domain.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

        public List<Material> getAllMaterial(){
            return (List<Material>) materialRepository.findAll();
        }

    public Optional<Material> getMaterialById(Long id){
        return materialRepository.findById(id);
    }

    public Material saveMaterial(Material material) {
        return materialRepository.save(material);
    }

    public void delete(Material material) {
        materialRepository.delete(material);
    }

    public void deleteById(Long id) {
        materialRepository.deleteById(id);
    }

    public Boolean updateMaterial(Long id, Material updatedMaterial){

        Boolean wasUpdated = Boolean.FALSE;

        Optional<Material> material = getMaterialById(id);
        if(material.isPresent()){
            material.get().setName(updatedMaterial.getName());
            material.get().setMatDescription(updatedMaterial.getMatDescription());
            materialRepository.save(material.get());
            wasUpdated = Boolean.TRUE;
        }
        return wasUpdated;
    }
}
