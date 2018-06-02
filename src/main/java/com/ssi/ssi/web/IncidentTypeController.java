package com.ssi.ssi.web;

import com.ssi.ssi.domain.model.IncidentType;
import com.ssi.ssi.resources.IncidentTypeResource;
import com.ssi.ssi.service.IncidentTypeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/IncidentType")
@Api(value = "IncidentType", description = "create incident type")
public class IncidentTypeController {

    @Autowired
    private IncidentTypeService incidentTypeService;


    @RequestMapping(
            method = RequestMethod.POST
    )
    private ResponseEntity<IncidentType> createIncidentType(@RequestBody IncidentTypeResource incidentTypeResource) {
        return new ResponseEntity<IncidentType>(incidentTypeService.createIncidentType(incidentTypeResource), HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.PUT
    )
    public ResponseEntity<IncidentType> updateCustomer(@RequestBody IncidentType incidentType) {

        Boolean wasUpdated = incidentTypeService.updateIncidentType(incidentType);
        if (wasUpdated) {
            Optional<IncidentType> incidentTypeDb = incidentTypeService.findIncidentTypeById(incidentType.getId());
            return new ResponseEntity<IncidentType>(incidentTypeDb.get(), HttpStatus.OK);
        }

        return new ResponseEntity<IncidentType>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(
            method = RequestMethod.GET
    )
    public List<IncidentType> findAllIncidentType() {

        List<IncidentType> incidentTypeList = new ArrayList<>();

        incidentTypeService.getAllIncidentType().forEach(
                incidentType -> incidentTypeList.add(incidentType)
        );

        return incidentTypeList;

    }
}
