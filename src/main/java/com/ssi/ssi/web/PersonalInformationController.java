package com.ssi.ssi.web;

import com.ssi.ssi.domain.model.PersonalInformation;
import com.ssi.ssi.resources.PersonalInformationResource;
import com.ssi.ssi.service.PersonalInformationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Api(value = "personalInformation" , description = "personalInformation")
@RestController
@RequestMapping(value = "/personalInformation")
public class PersonalInformationController {
    @Autowired
    PersonalInformationService personalInformationService;



    @RequestMapping(
            method = RequestMethod.POST,
            value = "/createPersonalInformation"
    )
    public ResponseEntity<PersonalInformation> createPersonalInformation(@RequestBody PersonalInformationResource personalInformationResource) {
        return new ResponseEntity<PersonalInformation>(personalInformationService.createPersonalInformation(personalInformationResource), HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/updatePersonalInformation"
    )
    public ResponseEntity<PersonalInformation> updatePersonalInformation(@RequestBody PersonalInformationResource personalInformationResource) {

        //Boolean wasUpdated =  personalInformationService.updatePersonalInformation(personalInformationResource);
        Boolean wasUpdated =  personalInformationService.updatePersonalInformation(personalInformationResource);
        if(wasUpdated){
            Optional<PersonalInformation> personalInformation = personalInformationService.findEmployeeById(personalInformationResource.getEmployeeTypeId());
            return new ResponseEntity<PersonalInformation>(personalInformation.get(), HttpStatus.OK);
        }

        return new ResponseEntity<PersonalInformation>(HttpStatus.NOT_FOUND);
    }









    /*

    @GetMapping
    public ResponseEntity<List<PersonalInformationResource>> getAllPersonal() {
        final List<PersonalInformationResource> collection = personalInformationService.getAllPersonal().stream().map(PersonalInformationResource::new).collect(Collectors.toList());
        return ResponseEntity.ok(collection);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalInformationResource> get(@PathVariable final long id) {
        return personalInformationService.getId(id).map(p -> ResponseEntity.ok(new PersonalInformationResource(p))).orElseThrow(() -> new MessageNotFountException(id));
    }

    @PostMapping
    public ResponseEntity<PersonalInformationResource> post(@RequestBody final PersonalInformation personalInformationFromRequest) {
        final PersonalInformation personalInformation = personalInformationService.save(personalInformationFromRequest);
        return ResponseEntity.ok(new PersonalInformationResource(personalInformation));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonalInformationResource> put(@PathVariable("id") final long id, @RequestBody PersonalInformation personalInformationFromRequest) {
        final PersonalInformation personalInformation = personalInformationFromRequest;
        final PersonalInformationResource resource;
        boolean isvalidate = personalInformationService.isValidatePersonalInformation(personalInformation);
        if(isvalidate){
            personalInformationService.save(personalInformation);
            resource = new PersonalInformationResource(personalInformation);
            return ResponseEntity.ok(resource);
        }

        return new ResponseEntity(personalInformation,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") final long id) {
        return personalInformationService.getId(id).map(p -> {
            personalInformationService.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElseThrow(() -> new MessageNotFountException(id));
    }

*/





}
