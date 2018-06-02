package com.ssi.ssi.domain.repository;

import com.ssi.ssi.domain.model.EmployeeType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @autor Marco Herrera.
 */
@Repository
public interface EmployeeTypeRepository extends CrudRepository<EmployeeType, Long>{
    @Query("select empType from EmployeeType empType where lower(empType.name) like CONCAT('%',:name,'%')")
    List<EmployeeType> searchByName(@Param("name") String name);
}
