package com.ssi.ssi.request;

import java.util.Date;

public class PersonalInformationRequest {
    private Long id;
    private Date registrationDate;
    private String legalName;
    private Long area_id;
    private Long employee_id;
    private Boolean isDeleted;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public Long getArea_id() {
        return area_id;
    }

    public void setArea_id(Long area_id) {
        this.area_id = area_id;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
