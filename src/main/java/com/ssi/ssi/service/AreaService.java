package com.ssi.ssi.service;


import com.ssi.ssi.domain.model.Area;
import com.ssi.ssi.domain.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaService {


    @Autowired
    private  AreaRepository areaRepository;


    public Area createArea(Area area) {
        area.setDeleted(false);
        return areaRepository.save(area);
    }

    public Optional<Area> findAreaById(Long id) {
        return areaRepository.findById(id);
    }

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
        //areaRepository.deleteById(id);

        Optional<Area> areaDb = findAreaById(id);
        if (areaDb.isPresent()) {
            areaDb.get().setDeleted(Boolean.TRUE);
            areaRepository.save(areaDb.get());
        }


    }


    public  boolean isValidateArea( Area area){
        boolean isValidate = Boolean.FALSE;
        if(null != area.getName()){
            isValidate = Boolean.TRUE;
        }
        return isValidate;

    }



}
