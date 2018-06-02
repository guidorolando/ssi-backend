package com.ssi.ssi.web;

import com.ssi.ssi.domain.model.AccidentAgent;
import com.ssi.ssi.service.AccidentAgentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accidentAgent")
@Api(value = "AccidentAgent", description = "create a accident agent")
public class AccidentAgentController {

    @Autowired
    private AccidentAgentService accidentAgentService;

    @RequestMapping(
            method = RequestMethod.POST
    )
    private ResponseEntity<AccidentAgent> createAccidentAgent(@RequestBody AccidentAgent accidentAgent) {
        return new ResponseEntity<AccidentAgent>(accidentAgentService.createAccidentAgent(accidentAgent), HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.PUT
    )
    public ResponseEntity<AccidentAgent> updateAccidentAgent(@RequestBody AccidentAgent accidentAgent) {

        Boolean wasUpdated = accidentAgentService.updateAccidentAgent(accidentAgent);
        if (wasUpdated) {
            Optional<AccidentAgent> accidentAgentDb = accidentAgentService.findAccidentAgentById(accidentAgent.getId());
            return new ResponseEntity<AccidentAgent>(accidentAgentDb.get(), HttpStatus.OK);
        }

        return new ResponseEntity<AccidentAgent>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(
            method = RequestMethod.GET
    )
    public List<AccidentAgent> getAllAccidentAgents() {

        List<AccidentAgent> accidentAgents = new ArrayList<>();

        accidentAgentService.getAllAccidentAgents().forEach(
                accidentAgent -> accidentAgents.add(accidentAgent)
        );

        return accidentAgents;

    }
}
