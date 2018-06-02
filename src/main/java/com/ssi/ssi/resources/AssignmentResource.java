package com.ssi.ssi.resources;

import com.ssi.ssi.domain.model.Assignment;

import java.util.Date;

public class AssignmentResource {
    private Long id;

    private Integer quantity;
    private Date AssignmentDate;
    private Assignment assignment;


    public AssignmentResource (Assignment assignment){
        this.assignment = assignment;
        this.id = assignment.getId();
        this.quantity = assignment.getQuantity();
        this.AssignmentDate = assignment.getAssignmentDate();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getAssignmentDate() {
        return AssignmentDate;
    }

    public void setAssignmentDate(Date assignmentDate) {
        AssignmentDate = assignmentDate;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }
}
