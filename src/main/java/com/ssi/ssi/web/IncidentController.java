package com.ssi.ssi.web;

import com.ssi.ssi.domain.model.Incident;
import com.ssi.ssi.resources.IncidentResource;
import com.ssi.ssi.service.IncidentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/Incident")
@Api(value = "Incident", description = "Incidents")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/createIncident"
    )
    public ResponseEntity<Incident> createIncident(@RequestBody IncidentResource incidentResource) {
        return new ResponseEntity<Incident>(incidentService.createIncident(incidentResource), HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/updateIncident"
    )
    public ResponseEntity<Incident> updateIncident(@RequestBody IncidentResource incidentResource) {

        Boolean wasUpdated =  incidentService.updateIncident(incidentResource);
        if(wasUpdated){
            Optional<Incident> incident = incidentService.findIncidentById(incidentResource.getIncidentId());
            return new ResponseEntity<Incident>(incident.get(), HttpStatus.OK);
        }

        return new ResponseEntity<Incident>(HttpStatus.NOT_FOUND);
    }
}
