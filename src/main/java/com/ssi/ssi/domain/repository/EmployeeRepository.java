package com.ssi.ssi.domain.repository;

import com.ssi.ssi.domain.model.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * @autor Marco Herrera.
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
