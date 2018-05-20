package com.ssi.ssi.domain.repository;

import com.ssi.ssi.domain.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
