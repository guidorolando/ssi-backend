package com.ssi.ssi.domain.repository;

import com.ssi.ssi.domain.model.AccidentAgent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccidentAgentRepository extends CrudRepository<AccidentAgent, Long> {

    @Query("SELECT accidentAgent FROM AccidentAgent accidentAgent WHERE accidentAgent.isDeleted=0 ")
    List<AccidentAgent> findAll();
}
