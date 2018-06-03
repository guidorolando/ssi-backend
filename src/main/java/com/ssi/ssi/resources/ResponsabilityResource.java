package com.ssi.ssi.resources;

import com.ssi.ssi.domain.model.Capacity;
import com.ssi.ssi.domain.model.EmployeeType;
import com.ssi.ssi.domain.model.Responsibility;


public class ResponsabilityResource {

    final Responsibility responsibility;
    private Long id;
    private String name;
    private String description;
    private Boolean isDeleted;


    public ResponsabilityResource(final Responsibility responsibility) {
        this.responsibility = responsibility;
        this.id = responsibility.getId();
        this.name = responsibility.getName();
        this.description =responsibility.getDescription();
        this.isDeleted = responsibility.getDeleted();

    }


    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
