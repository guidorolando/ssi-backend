package com.ssi.ssi.service;

import com.ssi.ssi.domain.model.PersonalInformation;
import com.ssi.ssi.domain.repository.PersonalInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalInformationService {
    @Autowired
    PersonalInformationRepository personalInformationRepository;


    public List<PersonalInformation> getAllPersonal(){
        return (List<PersonalInformation>) personalInformationRepository.findAll();
    }

    public Optional<PersonalInformation> getId(Long id){
        return  personalInformationRepository.findById(id);
    }

    public PersonalInformation save(PersonalInformation personalInformation){
        return  personalInformationRepository.save(personalInformation);
    }

    public  void delete(PersonalInformation personalInformation){
        personalInformationRepository.delete(personalInformation);
    }
    public void  deleteById(Long id){
        personalInformationRepository.deleteById(id);
    }

    public  boolean isValidatePersonalInformation( PersonalInformation personalInformation){
        boolean isValidate = Boolean.FALSE;
        if(null != personalInformation.getFirstName()){
            isValidate = Boolean.TRUE;
        }
        return isValidate;

    }


}
