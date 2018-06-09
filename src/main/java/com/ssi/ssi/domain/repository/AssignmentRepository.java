package com.ssi.ssi.domain.repository;

import com.ssi.ssi.domain.model.Assignment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository extends CrudRepository<Assignment, Long> {

}
