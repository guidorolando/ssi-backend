package com.ssi.ssi.service;

import com.ssi.ssi.domain.model.Employee;
import com.ssi.ssi.domain.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @autor Marco Herrera.
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll(){
        return (List<Employee>) employeeRepository.findAll();
    }
}
