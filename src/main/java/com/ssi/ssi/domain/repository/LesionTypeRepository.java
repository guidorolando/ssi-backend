package com.ssi.ssi.domain.repository;

import com.ssi.ssi.domain.model.LesionType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LesionTypeRepository extends CrudRepository<LesionType, Long> {
    @Query("SELECT lesionType FROM LesionType lesionType WHERE lesionType.isDeleted=0 ")
    List<LesionType> findAll();
}
