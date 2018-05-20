package com.ssi.ssi.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "salary")
    private Double salary;

    @ManyToOne
    private EmployeeType employeeType;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_capacities",
    joinColumns = {@JoinColumn(name = "employee_id")},
    inverseJoinColumns = {@JoinColumn(name = "capacities_id")})
    private List<Capacity> capacities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public List<Capacity> getCapacities() {
        return capacities;
    }

    public void setCapacities(List<Capacity> capacities) {
        this.capacities = capacities;
    }
}
