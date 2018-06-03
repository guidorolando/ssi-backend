package com.ssi.ssi.service;

import com.ssi.ssi.domain.model.*;
import com.ssi.ssi.domain.repository.IncidentRepository;
import com.ssi.ssi.resources.IncidentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    @Autowired
    private IncidentTypeService incidentTypeService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private LesionTypeService lesionTypeService;

    @Autowired
    private AccidentAgentService accidentAgentService;

    public Optional<Incident> findIncidentById(Long id) {
        return incidentRepository.findById(id);
    }


    public Incident createIncident(IncidentResource incidentResource) {

        Optional<Employee> employeeDb = employeeService.findById(incidentResource.getEmployeeId());
        Optional<IncidentType> incidentTypeDb = incidentTypeService.findIncidentTypeById(incidentResource.getIncidentTypeId());
        Optional<LesionType> lesionTypeDb = lesionTypeService.findLesionTypeById(incidentResource.getLesionTypeId());
        Optional<AccidentAgent> accidentAgentDb = accidentAgentService.findAccidentAgentById(incidentResource.getAccidentAgentId());
        if(employeeDb.isPresent() && incidentTypeDb.isPresent() && lesionTypeDb.isPresent() && accidentAgentDb.isPresent()){
            Incident incident = new Incident();
            incident.setIncidentType(incidentTypeDb.get());
            incident.setEmployee(employeeDb.get());
            incident.setLesionType(lesionTypeDb.get());
            incident.setAccidentAgent(accidentAgentDb.get());
            incident.setAccidentDate(incidentResource.getAccidentDate());
            incident.setAccidentDay(incidentResource.getAccidentDay());
            incident.setAccidentTime(incidentResource.getAccidentTime());
            incident.setAccidentSite(incidentResource.getAccidentSite());
            incident.setWorkingTurn(incidentResource.getWorkingTurn());
            incident.setAffectedPart(incidentResource.getAffectedPart());
            incident.setIsDeleted(Boolean.FALSE);
            return incidentRepository.save(incident);
        }

        return new Incident();

    }

    public Boolean updateIncident(IncidentResource incidentResource) {

        Boolean wasUpdated = Boolean.FALSE;

        Optional<Incident> incidentDb = findIncidentById(incidentResource.getIncidentId());
        Optional<IncidentType> incidentTypeDb = incidentTypeService.findIncidentTypeById(incidentResource.getIncidentTypeId());
        Optional<AccidentAgent> accidentAgentDb = accidentAgentService.findAccidentAgentById(incidentResource.getAccidentAgentId());
        Optional<LesionType> lesionTypeDb = lesionTypeService.findLesionTypeById(incidentResource.getLesionTypeId());
        if (incidentDb.isPresent() && incidentTypeDb.isPresent() && accidentAgentDb.isPresent() && lesionTypeDb.isPresent()) {
            incidentDb.get().setIncidentType(incidentTypeDb.get());
            incidentDb.get().setAccidentDate(incidentResource.getAccidentDate());
            incidentDb.get().setAccidentDay(incidentResource.getAccidentDay());
            incidentDb.get().setAccidentTime(incidentResource.getAccidentTime());
            incidentDb.get().setAccidentSite(incidentResource.getAccidentSite());
            incidentDb.get().setWorkingTurn(incidentResource.getWorkingTurn());
            incidentDb.get().setAffectedPart(incidentResource.getAffectedPart());
            incidentRepository.save(incidentDb.get());
            wasUpdated = Boolean.TRUE;
        }

        return wasUpdated;
    }

    public Iterable<Incident> getAllIncident() {
        return incidentRepository.findAll();
    }
}
