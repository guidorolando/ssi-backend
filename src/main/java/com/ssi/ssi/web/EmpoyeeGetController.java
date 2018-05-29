package com.ssi.ssi.web;

import com.ssi.ssi.resources.EmployeeResource;
import com.ssi.ssi.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @autor Marco Herrera.
 */
@Api(
        tags = AbstractEmployeeController.TAG_NAME,
        description = AbstractEmployeeController.DESCRIPTION
)
@RestController
public class EmpoyeeGetController extends AbstractEmployeeController {
    @Autowired
    private EmployeeService service;

    @ApiOperation(value = "Get all employee")
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ResponseEntity<List<EmployeeResource>> getAll(){
        final List<EmployeeResource> collection = service.getAll().stream().map(EmployeeResource::new).collect(Collectors.toList());;
        return ResponseEntity.ok(collection);
    }


}
