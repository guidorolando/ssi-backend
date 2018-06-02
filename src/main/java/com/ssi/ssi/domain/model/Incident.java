package com.ssi.ssi.domain.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "incident")
public class Incident {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "accident_site")
    private String accidentSite;

    @Column(name = "working_date")
    private String workingDay;

    @Column(name = "accident_date")
    private Date accidentDate;

    @Column(name = "accident_day")
    private String accidentDay;

    @Column(name = "accident_time")
    private String accidentTime;

    @Column(name = "affected_part")
    private String affectedPart;


    @ManyToMany
    @JoinTable(name = "incident_incident_tag",
            joinColumns = {@JoinColumn(name = "indicent_id")},
            inverseJoinColumns = {@JoinColumn(name = "incident_tags_id")})
    private List<IncidentTag> incidentTags;

    @ManyToOne
    private IncidentType incidentType;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private LesionType lesionType;

    @ManyToOne
    private AccidentAgent accidentAgent;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IncidentType getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(IncidentType incidentType) {
        this.incidentType = incidentType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public LesionType getLesionType() {
        return lesionType;
    }

    public void setLesionType(LesionType lesionType) {
        this.lesionType = lesionType;
    }

    public AccidentAgent getAccidentAgent() {
        return accidentAgent;
    }

    public void setAccidentAgent(AccidentAgent accidentAgent) {
        this.accidentAgent = accidentAgent;
    }

    public String getAffectedPart() {
        return affectedPart;
    }

    public void setAffectedPart(String affectedPart) {
        this.affectedPart = affectedPart;
    }
}
