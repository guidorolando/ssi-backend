package com.ssi.ssi.resources;

import com.ssi.ssi.domain.model.AccidentAgent;

public class AccidentAgentResource 
{

    private AccidentAgent accidentAgent = null;

    private Long id;

    private String agentName;

    public IncidentTypeResource() 
	{
        super();
    }
    public AccidentAgentResource (final AccidentAgent accidentAgent) 
	{
        this.accidentAgent = accidentAgent;
        this.id = accidentAgent.getId();
        this.agentName = incidentType.getAgentName();
      

    }

    public String getAgentName() 
	{
        return agentName;
    }

    public Long getId() 
	{
        return id;
    }

    public void setId(Long id) 
	{
        this.id = id;
    }

    public void setAgentName(String agentName)
	 {
        this.agentName = agentName;
    }
}