package com.ssi.ssi.service;

import com.ssi.ssi.domain.model.Employee;
import com.ssi.ssi.domain.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
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

    public Optional<Employee> findById(Long id){
        return employeeRepository.findById(id);
    }
=======
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return (List<Employee>) employeeRepository.findAll();
    }
    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepository.findById(id);
    }
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }
    public void deleteEmployee(Employee employee){
        employeeRepository.delete(employee);
    }

>>>>>>> 4fa09c4d87a457a8afec93e69d85ad3438139f45
}
