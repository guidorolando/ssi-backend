package com.ssi.ssi.domain.repository;

import com.ssi.ssi.domain.model.IncidentType;
import com.ssi.ssi.domain.model.Responsibility;
import org.springframework.data.repository.CrudRepository;

public interface ResponsabilityRepository extends CrudRepository<Responsibility, Long> {
}
