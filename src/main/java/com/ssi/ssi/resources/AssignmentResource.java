package com.ssi.ssi.resources;

import com.ssi.ssi.domain.model.Assignment;

import java.util.Date;

public class AssignmentResource {
    private Long id;
    private Long materialId;
    private Long employeeId;
    private Date assignmentDate;
    private Integer quantity;


    /*public AssignmentResource (Assignment assignment){
        this.assignment = assignment;
        this.id = assignment.getId();
        this.quantity = assignment.getQuantity();
        this.AssignmentDate = assignment.getAssignmentDate();

    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Date getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(Date assignmentDate) {
        this.assignmentDate = assignmentDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}
