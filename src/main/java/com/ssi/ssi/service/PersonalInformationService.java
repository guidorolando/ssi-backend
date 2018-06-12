package com.ssi.ssi.service;

import com.ssi.ssi.domain.model.*;
import com.ssi.ssi.domain.repository.PersonalInformationRepository;
import com.ssi.ssi.resources.PersonalInformationResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonalInformationService {
    @Autowired
    PersonalInformationRepository personalInformationRepository;

    @Autowired
    EmployeeTypeService employeeTypeService;

    @Autowired
    AreaService areaService;

    @Autowired
    CapacityService capacityService;


    public Optional<PersonalInformation> findEmployeeById(Long id) {

        return personalInformationRepository.findById(id);
    }

    public PersonalInformation createPersonalInformation(PersonalInformationResource personalInformationResource) {

        Optional<Area> areaDb = areaService.getId(personalInformationResource.getAreaId());
        Optional<Capacity> capacityDb = capacityService.getId(personalInformationResource.getCapacityId());
        Optional<EmployeeType> employeeTypeDb = employeeTypeService.findById(personalInformationResource.getEmployeeTypeId());


        if(areaDb.isPresent() && capacityDb.isPresent() && employeeTypeDb.isPresent()){
            PersonalInformation personalInformation = new PersonalInformation();
            personalInformation.setArea(areaDb.get());
            personalInformation.setCapacity(capacityDb.get());
           // personalInformation.setEmployeeType((employeeTypeDb.get()));
            personalInformation.setDeleted(Boolean.FALSE);
            return personalInformationRepository.save(personalInformation);
        }

        return new PersonalInformation();

    }


    public Boolean updatePersonalInformation(PersonalInformationResource personResource) {

        Boolean wasUpdated = Boolean.FALSE;

        Optional<PersonalInformation> personalInformationDb = findEmployeeById(personResource.getEmployeeTypeId());
       // List<EmployeeType> employeeTypeDb = employeeTypeService.findById(personResource.getEmployeeTypeId());

         if (personalInformationDb.isPresent()) {
            // personalInformationDb.get().setEmployeeType(employeeTypeDb.);
             personalInformationRepository.save(personalInformationDb.get());
            wasUpdated = Boolean.TRUE;
        }

        return wasUpdated;
    }

    public Iterable<PersonalInformation> getAllPersonalInformation() {
        return personalInformationRepository.findAll();
    }










/*
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

*/


}
