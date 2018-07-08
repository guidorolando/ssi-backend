package com.ssi.ssi.service;


import com.ssi.ssi.domain.model.Assignment;
import com.ssi.ssi.domain.model.Employee;
import com.ssi.ssi.domain.model.Material;
import com.ssi.ssi.domain.repository.AssignmentRepository;
import com.ssi.ssi.domain.repository.EmployeeRepository;
import com.ssi.ssi.domain.repository.MaterialRepository;
import com.ssi.ssi.request.AssignmentRequest;
import com.ssi.ssi.resources.AssignmentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private StoreService storeService;

    /*public List<Assignment> getAssignmentAll(){
        return (List<Assignment>) assignmentRepository.findAll();
    }*/
    public Optional<Assignment> getAssignmentById(Long id){
        return assignmentRepository.findById(id);
    }

    public Boolean stockCheck(Long id, Integer quantity){
        Boolean checkStock = Boolean.FALSE;
        //Material mat = storeRepository.;
        if(storeService.getById(id).get().getStock()>=quantity){
            checkStock = Boolean.TRUE;
        }
        //storeService.getById(id).get().getStock()>=quantity
        return checkStock;
    }/*
    public Assignment createAssignment( AssignmentResource assignmentReq){
        Optional<Material> materialId = materialService.getMaterialById(assignmentReq.getMaterial().getId());
        Optional<Employee> employeeId = employeeService.findById(assignmentReq.getEmployee().getId());

        if(materialId.isPresent()){
            Assignment assignment = new Assignment();
            assignment.setMaterial(materialId.get());
            assignment.setEmployee(employeeId.get());
            assignment.setQuantity(assignmentResource.getQuantity());
            assignment.setAssignmentDate(assignmentResource.getAssignmentDate());

        }
    }*/


    public Assignment saveAssignment(Assignment assignment) {
        Material material = materialRepository.findById(assignment.getMaterial().getId()).get();
        assignment.setMaterial(material);
        Employee employee = employeeRepository.findById(assignment.getEmployee().getId()).get();
        assignment.setEmployee(employee);

        return assignmentRepository.save(assignment);
    }

    public List<Assignment> getAllAssignment(){
        return assignmentRepository.getAllAssignment();
    }
}
