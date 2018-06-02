package com.ssi.ssi.domain.repository;

import com.ssi.ssi.domain.model.Incident;
import org.springframework.data.repository.CrudRepository;

public interface IncidentRepository extends CrudRepository<Incident, Long> {
}
