package com.ssi.ssi.web;

import com.ssi.ssi.domain.model.Employee;
import com.ssi.ssi.domain.repository.exception.EmployeeNotFountException;
import com.ssi.ssi.resources.EmployeeResourse;
import com.ssi.ssi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeResourse>> getAllEmployee() {
        final List<EmployeeResourse> collection = employeeService.getAllEmployees()
                .stream()
                .map(EmployeeResourse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(collection);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResourse> get (@PathVariable final long id) {
        return employeeService.getEmployeeById(id).map(p -> ResponseEntity.ok(new EmployeeResourse(p))).orElseThrow(() -> new EmployeeNotFountException(id));
    }
    @PostMapping
    public ResponseEntity<EmployeeResourse> post(@RequestBody final Employee employeeFromRequest) {
        final Employee employee = employeeService.createEmployee(employeeFromRequest);
        return ResponseEntity.ok(new EmployeeResourse(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResourse> put(@PathVariable("id") final long id, @RequestBody Employee employeeFromRequest) {
        final Employee employee = employeeFromRequest;
        employeeService.createEmployee(employee);
        final EmployeeResourse resourceEmployee = new EmployeeResourse(employee);
        return ResponseEntity.ok(resourceEmployee);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") final long id) {
        return employeeService.getEmployeeById(id).map(p -> {
            employeeService.deleteEmployeeById(id);
            return ResponseEntity.noContent().build();
        }).orElseThrow(() -> new EmployeeNotFountException(id));
    }
}
