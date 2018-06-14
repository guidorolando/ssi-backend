package com.ssi.ssi.service;

import com.ssi.ssi.domain.model.Employee;
import com.ssi.ssi.domain.model.EmployeeType;
import com.ssi.ssi.domain.model.MaterialType;
import com.ssi.ssi.domain.repository.MaterialTypeRepository;
import com.ssi.ssi.resources.MaterialTypeResource;
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
        if(materialTypeRepository.existsById(id)){
            materialTypeRepository.deleteById(id);
        }
        else{
            System.out.println("No exist the Material Type with id '" + id + "' for delete.");
        }
    }

    /*public Optional<MaterialType> findById(Long id) {
        Optional<MaterialType> materialType = materialTypeRepository.findById(id);
        if(materialType.isPresent()){
            return materialType;
        }else {
            return null;
        }
    }*/

    public void addMaterialType (MaterialTypeResource materialTypeResource){

        if (materialTypeRepository.existsById(materialTypeResource.getId())) {
            MaterialType materialType = new MaterialType();
            materialType.setNameType(materialTypeResource.getNameType());
            materialTypeRepository.save(materialType);
        }
        else {
          System.out.println("No exist the Material Type for add.");
         }
    }

    public void updateMaterialType (MaterialTypeResource materialTypeResource, Long id){
        Optional<MaterialType> materialType = getById(id);
        // && employee.get().getDeleted().equals(false)
        if (materialTypeRepository.existsById(id)) {
            materialType.get().setNameType(materialTypeResource.getNameType());
            materialTypeRepository.save(materialType.get());

        } else {
            System.out.println("No exist the Material Type with id '" + id + "' for update.");
        }
    }
}
