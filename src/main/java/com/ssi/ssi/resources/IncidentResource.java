package com.ssi.ssi.resources;

import java.util.Date;

public class IncidentResource {

    private Long incidentId;
    private Long employeeId;
    private Long incidentTypeId;
    private Long accidentAgentId;
    private Long lesionTypeId;
    private String accidentSite;
    private String workingDay;
    private Date accidentDate;
    private String accidentDay;
    private String accidentTime;
    private String affectedPart;

    public Long getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(Long incidentId) {
        this.incidentId = incidentId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getIncidentTypeId() {
        return incidentTypeId;
    }

    public void setIncidentTypeId(Long incidentTypeId) {
        this.incidentTypeId = incidentTypeId;
    }

    public Long getAccidentAgentId() {
        return accidentAgentId;
    }

    public void setAccidentAgentId(Long accidentAgentId) {
        this.accidentAgentId = accidentAgentId;
    }

    public Long getLesionTypeId() {
        return lesionTypeId;
    }

    public void setLesionTypeId(Long lesionTypeId) {
        this.lesionTypeId = lesionTypeId;
    }

    public String getAccidentSite() {
        return accidentSite;
    }

    public void setAccidentSite(String accidentSite) {
        this.accidentSite = accidentSite;
    }

    public String getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(String workingDay) {
        this.workingDay = workingDay;
    }

    public Date getAccidentDate() {
        return accidentDate;
    }

    public void setAccidentDate(Date accidentDate) {
        this.accidentDate = accidentDate;
    }

    public String getAccidentDay() {
        return accidentDay;
    }

    public void setAccidentDay(String accidentDay) {
        this.accidentDay = accidentDay;
    }

    public String getAccidentTime() {
        return accidentTime;
    }

    public void setAccidentTime(String accidentTime) {
        this.accidentTime = accidentTime;
    }

    public String getAffectedPart() {
        return affectedPart;
    }

    public void setAffectedPart(String affectedPart) {
        this.affectedPart = affectedPart;
    }
}
