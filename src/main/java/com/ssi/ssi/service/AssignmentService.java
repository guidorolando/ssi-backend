package com.ssi.ssi.service;


import com.ssi.ssi.domain.model.Assignment;
import com.ssi.ssi.domain.model.Employee;
import com.ssi.ssi.domain.model.Material;
import com.ssi.ssi.domain.repository.AssignmentRepository;
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
    private MaterialService materialService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private StoreService storeService;

    public List<Assignment> getAssignmentAll(){
        return (List<Assignment>) assignmentRepository.findAll();
    }
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
    }
    public Assignment createAssignment( AssignmentResource assignmentResource, Integer quantity){
        Optional<Material> materialId = materialService.getMaterialById(assignmentResource.getMaterialId());
        Optional<Employee> employeeId = employeeService.findById(assignmentResource.getEmployeeId());

        /*if(materialId.isPresent() && employeeId.isPresent() && stockCheck(materialId.get(),quantity)){
            Assignment assignment = new Assignment();
            assignment.setMaterial(materialId.get());
            assignment.setEmployee(employeeId.get());
            assignment.setQuantity(assignmentResource.getQuantity());
            assignment.setAssignmentDate(assignmentResource.getAssignmentDate());

        }*/
        return null;
    }
}
