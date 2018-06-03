package com.ssi.ssi.domain.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "personal_information")
public class PersonalInformation {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "legal_name")
    private String legalName;

    @ManyToOne
    private Area area;

    @ManyToOne
    private Capacity capacity;


    @ManyToMany
    @JoinTable(name = "personal_information_employee_type",
            joinColumns = {@JoinColumn(name = "personal_information_id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_type_id")})
    private List<EmployeeType> employeeType;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }


    public List<EmployeeType> getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(List<EmployeeType> employeeType) {
        this.employeeType = employeeType;
    }


    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }
}
