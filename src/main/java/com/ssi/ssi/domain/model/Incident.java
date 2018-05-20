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

}
