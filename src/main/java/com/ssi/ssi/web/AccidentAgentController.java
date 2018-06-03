package com.ssi.ssi.web;

import com.ssi.ssi.common.response.rest.SuccessRestResponse;
import com.ssi.ssi.domain.model.AccidentAgent;
import com.ssi.ssi.service.AccidentAgentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "Delete Accident Agent")
    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE
    )
    public SuccessRestResponse remove(@PathVariable Long id) {
        accidentAgentService.delete(id);
        return new SuccessRestResponse();
    }

    @ApiOperation(value = "Get accident agent by Id")
    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET
    )
    public ResponseEntity<AccidentAgent> getById(@PathVariable Long id) {
        Optional<AccidentAgent> accidentAgent = accidentAgentService.findAccidentAgentById(id);
        if (accidentAgent.isPresent()) {
            return new ResponseEntity<AccidentAgent>(accidentAgent.get(), HttpStatus.OK);
        }

        return new ResponseEntity<AccidentAgent>(HttpStatus.NOT_FOUND);
    }
}
