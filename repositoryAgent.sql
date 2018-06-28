package com.ssi.ssi.domain.repository;

import com.ssi.ssi.domain.model.AccidentAgent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface AccidentAgentRepository extends CrudRepository<AccidentAgent, Long>
 {

    @Procedure(procedureAgentName = "create_accident_agent")
    Long createAccidentAgent(String accidentName);

    @Query(nativeQuery = true, value = "exec get_accident_agent :id")
    AccidentAgent getAccidentAgent(@Param("id") Long id);

    @Query(nativeQuery = true, value = "exec get_all_accident_agent")
    List<AccidentAgent> getAllAccidentAgent();
}