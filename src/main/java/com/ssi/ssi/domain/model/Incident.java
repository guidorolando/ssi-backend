package com.ssi.ssi.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "incident")
public class Incident {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @ManyToMany
    @JoinTable(name = "incident_incident_tag",
            joinColumns = {@JoinColumn(name = "indicent_id")},
            inverseJoinColumns = {@JoinColumn(name = "incident_tags_id")})
    private List<IncidentTag> incidentTags;

    @ManyToOne
    private IncidentType incidentType;

    @ManyToOne
    private Employee employee;

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
}
