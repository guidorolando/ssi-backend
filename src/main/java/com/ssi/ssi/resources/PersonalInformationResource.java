package com.ssi.ssi.resources;

import com.ssi.ssi.domain.model.Person;
import com.ssi.ssi.domain.model.PersonalInformation;
import com.ssi.ssi.domain.model.Responsibility;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

public class PersonalInformationResource {

    private final PersonalInformation personalInformation;

    private Long id;

    private String legalName;

    private String area;

    private String capacity;

    private String employeeType;

    private String observations;

    private Date registrationDate;

    public PersonalInformationResource(final PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
        this.id = personalInformation.getId();
        this.legalName =personalInformation.getLegalName();
        this.area = personalInformation.getArea();
        this.capacity = personalInformation.getCapacity();
        this.employeeType = personalInformation.getEmployeeType();
        this.observations = personalInformation.getObservations();
        this.registrationDate = personalInformation.getRegistrationDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
