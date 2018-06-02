package com.ssi.ssi.web;

import com.ssi.ssi.domain.model.Incident;
import com.ssi.ssi.service.IncidentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Incident> createIncident(@RequestBody Incident incident) {
        return new ResponseEntity<Incident>(incidentService.createIncident(incident), HttpStatus.CREATED);
    }
}
