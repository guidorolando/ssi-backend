package com.ssi.ssi.resources;

import com.ssi.ssi.domain.model.*;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

public class PersonalInformationResource {

    private Long areaId;
    private Long capacityId;
    private Long employeeTypeId;
    private Boolean isDeleted;

    public Long getAreaId() {
        return areaId;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getCapacityId() {
        return capacityId;
    }

    public void setCapacityId(Long capacityId) {
        this.capacityId = capacityId;
    }

    public Long getEmployeeTypeId() {
        return employeeTypeId;
    }

    public void setEmployeeTypeId(Long employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
    }
}
