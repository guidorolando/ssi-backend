package com.ssi.ssi.domain.repository;

import com.ssi.ssi.domain.model.IncidentType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IncidentTypeRepository extends CrudRepository<IncidentType, Long> {

    @Query("SELECT incidentType FROM IncidentType incidentType WHERE incidentType.isDeleted=0 ")
    List<IncidentType> findAll();
}
