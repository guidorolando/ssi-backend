package com.ssi.ssi.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "accident_agent")
public class AccidentAgent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "agent_name")
    private String agentName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }
}
