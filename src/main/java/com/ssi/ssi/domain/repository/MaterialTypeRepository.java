package com.ssi.ssi.domain.repository;

import com.ssi.ssi.domain.model.MaterialType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialTypeRepository extends CrudRepository<MaterialType, Long> {
}
