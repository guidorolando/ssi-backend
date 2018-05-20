package com.ssi.ssi.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee_type")
public class EmployeeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "employeeType")
    private List<Responsibility> responsibilityList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Responsibility> getResponsibilityList() {
        return responsibilityList;
    }

    public void setResponsibilityList(List<Responsibility> responsibilityList) {
        this.responsibilityList = responsibilityList;
    }
}
