package com.ssi.ssi.resources;

import com.ssi.ssi.domain.model.Capacity;
import com.ssi.ssi.domain.model.Employee;
import com.ssi.ssi.domain.model.EmployeeType;

import java.util.List;

public class EmployeeResourse {

    private final Employee employee;

    private Long id;
    private Double salary;
    private EmployeeType employeeType;
    private List<Capacity> capacities;

    public EmployeeResourse(final Employee employee) {
        this.employee = employee;

        this.id = employee.getId();
        this.salary = employee.getSalary();
        this.employeeType = employee.getEmployeeType();
        this.capacities = employee.getCapacities();
    }

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
