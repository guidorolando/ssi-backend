package com.ssi.ssi.service;

import com.ssi.ssi.domain.model.Employee;
import com.ssi.ssi.domain.repository.EmployeeRepository;
import com.ssi.ssi.request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @autor Marco Herrera.
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public void addEmployee(EmployeeRequest employeeRequest){
        Employee employee = new Employee();
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setCi(employeeRequest.getCi());
        employee.setGender(employeeRequest.getGender());
        employee.setAddress(employeeRequest.getAddress());
        employee.setPhone(employeeRequest.getPhone());
        employee.setBirthDate(employeeRequest.getBirthDate());
        employee.setSalary(employeeRequest.getSalary());
        employeeRepository.save(employee);
    }
}
