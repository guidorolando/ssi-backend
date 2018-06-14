package com.ssi.ssi.domain.repository;

import com.ssi.ssi.domain.model.Material;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends CrudRepository<Material, Long>{
}
