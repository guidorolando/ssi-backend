package com.ssi.ssi.domain.repository;

import com.ssi.ssi.domain.model.EmployeeType;
import com.ssi.ssi.domain.model.MaterialType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialTypeRepository extends CrudRepository<MaterialType, Long> {
    @Query("select empType from MaterialType matType where lower(empType.name) like CONCAT('%',:name,'%')")
    List<EmployeeType> searchById(@Param("name") String name);
}
