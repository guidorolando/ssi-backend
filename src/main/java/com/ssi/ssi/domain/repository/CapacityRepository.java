package com.ssi.ssi.domain.repository;

import com.ssi.ssi.domain.model.Area;
import com.ssi.ssi.domain.model.Capacity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CapacityRepository extends CrudRepository<Capacity,Long> {
    @Query("SELECT capacity FROM Capacity capacity WHERE capacity.isDeleted=0 ")
    List<Capacity> getAll();

}
