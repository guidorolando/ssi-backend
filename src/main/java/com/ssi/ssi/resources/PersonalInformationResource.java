package com.ssi.ssi.resources;

import com.ssi.ssi.domain.model.Person;
import com.ssi.ssi.domain.model.PersonalInformation;

import javax.persistence.Column;
import java.util.Date;

public class PersonalInformationResource {

    private final PersonalInformation personalInformation;

    private Long id;

    private String firstName;

    private String lastName;

    private String area;

    private String capacity;

    private String role;

    private String observations;

    private Date registrationDate;

    public PersonalInformationResource(final PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
        this.id = personalInformation.getId();
        this.firstName = personalInformation.getFirstName();
        this.lastName = personalInformation.getLastName();
        this.area = personalInformation.getArea();
        this.capacity = personalInformation.getCapacity();
        this.role = personalInformation.getRole();
        this.observations = personalInformation.getObservations();
        this.registrationDate = personalInformation.getRegistrationDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
