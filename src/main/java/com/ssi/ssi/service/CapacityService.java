package com.ssi.ssi.service;

import com.ssi.ssi.domain.model.Area;
import com.ssi.ssi.domain.model.Capacity;
import com.ssi.ssi.domain.repository.AreaRepository;
import com.ssi.ssi.domain.repository.CapacityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CapacityService {

    @Autowired
    private CapacityRepository capacityRepository;

    public Capacity createCapacity(Capacity capacity) {
        capacity.setDeleted(false);
        return capacityRepository.save(capacity);
    }

    public List<Capacity> getAll(){
        return (List<Capacity>) capacityRepository.findAll();
    }

    public Optional<Capacity> getId(Long id){
        return  capacityRepository.findById(id);
    }


    public Capacity save(Capacity capacity){
        return  capacityRepository.save(capacity);
    }

    public  void delete(Capacity capacity){
        capacityRepository.delete(capacity);
    }
    public void  deleteById(Long id){
        capacityRepository.deleteById(id);
    }


    public  boolean isValidateArea( Capacity capacity){
        boolean isValidate = Boolean.FALSE;
        if(null != capacity.getName()){
            isValidate = Boolean.TRUE;
        }
        return isValidate;

    }


}
