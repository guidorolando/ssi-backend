package com.ssi.ssi.service;


import com.ssi.ssi.domain.model.Assignment;
import com.ssi.ssi.domain.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;

    public List<Assignment> getAssignmentAll(){
        return (List<Assignment>) assignmentRepository.findAll();
    }
    public Optional<Assignment> getAssignmentById(Long id){
        return assignmentRepository.findById(id);
    }

    public void createAssignment( Assignment assignment){

    }
}
