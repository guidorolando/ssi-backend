package com.ssi.ssi.domain.repository;

import com.ssi.ssi.domain.model.Employee;
import org.springframework.data.repository.CrudRepository;
<<<<<<< HEAD

/**
 * @autor Marco Herrera.
 */
=======
import org.springframework.stereotype.Repository;

@Repository
>>>>>>> 4fa09c4d87a457a8afec93e69d85ad3438139f45
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
