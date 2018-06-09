package com.ssi.ssi.resources;

import com.ssi.ssi.domain.model.AccidentAgent;

public class AccidentAgentResource {

    private final AccidentAgent accidentAgent;

    private Long id;

    private String agentName;

    private Boolean isDeleted;

    public AccidentAgentResource(final AccidentAgent accidentAgent) {
        this.accidentAgent = accidentAgent;
        this.id = accidentAgent.getId();
        this.agentName = accidentAgent.getAgentName();
        this.isDeleted = accidentAgent.getIsDeleted();

    }

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

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
