package com.ssi.ssi.service;

import com.ssi.ssi.domain.model.Employee;
import com.ssi.ssi.domain.model.Incident;
import com.ssi.ssi.domain.model.IncidentType;
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

    public Optional<Incident> findIncidentById(Long id) {
        return incidentRepository.findById(id);
    }


    public Incident createIncident(IncidentResource incidentResource) {

        Optional<Employee> employeeDb = employeeService.findById(incidentResource.getEmployeeId());
        Optional<IncidentType> incidentTypeDb = incidentTypeService.findIncidentTypeById(incidentResource.getIncidentTypeId());
        if(employeeDb.isPresent() && incidentTypeDb.isPresent()){
            Incident incident = new Incident();
            incident.setIncidentType(incidentTypeDb.get());
            incident.setEmployee(employeeDb.get());
            return incidentRepository.save(incident);
        }

        return new Incident();

    }

    public Boolean updateIncident(IncidentResource incidentResource) {

        Boolean wasUpdated = Boolean.FALSE;

        Optional<Incident> incidentDb = findIncidentById(incidentResource.getIncidentId());
        Optional<IncidentType> incidentTypeDb = incidentTypeService.findIncidentTypeById(incidentResource.getIncidentTypeId());
        if (incidentDb.isPresent() && incidentTypeDb.isPresent()) {
            incidentDb.get().setIncidentType(incidentTypeDb.get());
            incidentRepository.save(incidentDb.get());
            wasUpdated = Boolean.TRUE;
        }

        return wasUpdated;
    }

    public Iterable<Incident> getAllIncident() {
        return incidentRepository.findAll();
    }
}
