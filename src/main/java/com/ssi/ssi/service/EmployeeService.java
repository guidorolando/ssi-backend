package com.ssi.ssi.service;

import com.ssi.ssi.domain.model.Employee;
import com.ssi.ssi.domain.model.EmployeeType;
import com.ssi.ssi.domain.repository.EmployeeRepository;
import com.ssi.ssi.domain.repository.EmployeeTypeRepository;
import com.ssi.ssi.request.EmployeeRequest;
import com.ssi.ssi.resources.EmployeeResource;
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

    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public List<Employee> getAll() {
        return (List<Employee>) employeeRepository.getAll();
    }

    public Employee findById(Long id) {
        Employee employee = employeeRepository.getEmployee(id);
        if(employee != null){
            return employee;
        }else {
            return null;
        }
    }

    public List<Employee> findByText(String name){
        return (List<Employee>) employeeRepository.searchByText(name);
    }

    public void addEmployee(EmployeeRequest employeeRequest){
        if(employeeTypeRepository.existsById(employeeRequest.getEmployeeTypeId())) {

            Optional<EmployeeType> employeeType = employeeTypeRepository.findById(employeeRequest.getEmployeeTypeId());

            Employee employee = new Employee();
            employee.setFirstName(employeeRequest.getFirstName());
            employee.setLastName(employeeRequest.getLastName());
            employee.setCi(employeeRequest.getCi());
            employee.setGender(employeeRequest.getGender());
            employee.setAddress(employeeRequest.getAddress());
            employee.setPhone(employeeRequest.getPhone());
            employee.setBirthDate(employeeRequest.getBirthDate());
            employee.setSalary(employeeRequest.getSalary());
            employee.setEmail(employeeRequest.getEmail());
            employee.setEmployeeType(employeeType.get());
            employee.setDeleted(false);
            employeeRepository.createEmployee(employee.getAddress(),employee.getBirthDate(),employee.getCi(),employee.getEmail(),employee.getFirstName(),employee.getGender().toString(),employee.getLastName(),employee.getPhone(),employee.getSalary(),employee.getEmployeeType().getId());
        }else{
            System.out.println("The Employe Type Id, not exist for a valid registry.");
        }
    }

    public void upDateEmployee(EmployeeRequest employeeRequest, Long id){
        Employee employee = findById(id);
        if (employeeRepository.existsById(id) && employee.getDeleted().equals(false)) {
            if(employeeTypeRepository.existsById(employeeRequest.getEmployeeTypeId())) {
                Optional<EmployeeType> employeeType = employeeTypeRepository.findById(employeeRequest.getEmployeeTypeId());

                //Optional<Employee> employee = findById(id);

                employee.setFirstName(employeeRequest.getFirstName());
                employee.setLastName(employeeRequest.getLastName());
                employee.setCi(employeeRequest.getCi());
                employee.setGender(employeeRequest.getGender());
                employee.setAddress(employeeRequest.getAddress());
                employee.setPhone(employeeRequest.getPhone());
                employee.setBirthDate(employeeRequest.getBirthDate());
                employee.setSalary(employeeRequest.getSalary());
                employee.setEmail(employeeRequest.getEmail());
                employee.setEmployeeType(employeeType.get());
                employeeRepository.save(employee);
            } else {
                System.out.println("The Employe Type Id, not exist for a valid registry.");
            }
        } else {
            System.out.println("No exist the Employee with id '" + id + "' for upDate.");
        }
    }

    public void deleteEmployeeById(Long id){
        if(employeeRepository.existsById(id)) {
            Employee employee = findById(id);
            employee.setDeleted(Boolean.TRUE);
            employeeRepository.save(employee);
            System.out.println("The Employee with id '" + id + "' is deleted.");
        }
        else
        {
            System.out.println("No exist the Employee with id '" + id + "' for delete.");
        }
    }

    public EmployeeResource builderEmployeeResource(Employee employee) {
        EmployeeResource instance = new EmployeeResource(employee);
        instance.setEmployeeType(instance.build(employee.getEmployeeType()));
        return instance;
    }
}
