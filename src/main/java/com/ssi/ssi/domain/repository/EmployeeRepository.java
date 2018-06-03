package com.ssi.ssi.domain.repository;

import com.ssi.ssi.domain.model.Employee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @autor Marco Herrera.
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Query("SELECT employee FROM Employee employee WHERE employee.isDeleted=0 ")
    List<Employee> getAll();

    @Query("SELECT employee FROM Employee employee WHERE employee.id = :id and employee.isDeleted=0 ")
    Optional<Employee> findById(@Param("id") Long id);

    @Query("select employee from Employee employee where employee.firstName like CONCAT('%',:name,'%') or employee.email like CONCAT('%',:name,'%')")
    List<Employee> searchByText(@Param("name") String name);

    @Query("SELECT employee FROM Employee employee WHERE employee.firstName like CONCAT('%',:search,'%') OR employee.lastName like CONCAT('%',:search,'%') OR employee.ci like CONCAT('%',:search,'%')")
    List<Employee> findEmployee(@Param("search") String search);
}
