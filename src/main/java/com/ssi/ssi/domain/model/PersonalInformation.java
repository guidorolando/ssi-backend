package com.ssi.ssi.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "personal_information")
public class PersonalInformation {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @ManyToOne
    private Area area;

    @ManyToOne
    private Capacity capacity;


    @ManyToMany
    @JoinTable(name = "personal_information_employee_type",
            joinColumns = {@JoinColumn(name = "personal_information_id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_type_id")})
    private List<EmployeeType> employeeType;


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

//    public EmployeeType getEmployeeType() {
//        return employeeType;
//    }
//
//    public void setEmployeeType(EmployeeType employeeType) {
//        this.employeeType = employeeType;
//    }


    public List<EmployeeType> getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(List<EmployeeType> employeeType) {
        this.employeeType = employeeType;
    }
}
