package com.ssi.ssi.service;


import com.ssi.ssi.domain.model.Area;
import com.ssi.ssi.domain.repository.AreaRepository;
import com.ssi.ssi.resources.AreaResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.ssi.ssi.domain.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AreaService {


    @Autowired
    private  AreaRepository areaRepository;

    public  List<Area> getAll(){
        return (List<Area>) areaRepository.findAll();
    }

    public Optional<Area> getId(Long id){
        return  areaRepository.findById(id);
    }


    public Area save(Area area){
        return  areaRepository.save(area);
    }

    public  void delete(Area area){
        areaRepository.delete(area);
    }
    public void  deleteById(Long id){
        areaRepository.deleteById(id);
    }


    public  boolean isValidateArea( Area area){
        boolean isValidate = Boolean.FALSE;
        if(null != area.getName()){
            isValidate = Boolean.TRUE;
        }
        return isValidate;

    }



}
