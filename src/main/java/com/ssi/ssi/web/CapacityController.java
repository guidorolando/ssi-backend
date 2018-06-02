package com.ssi.ssi.web;

import com.ssi.ssi.common.response.rest.ListRestResponse;
import com.ssi.ssi.resources.CapacityResource;
import com.ssi.ssi.resources.EmployeeResource;
import com.ssi.ssi.service.CapacityService;
import com.ssi.ssi.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Api(value = "capacity" , description = "capacity")
@RestController
@RequestMapping(value = "/capacity")
public class CapacityController {
    @Autowired
    private CapacityService capacityService;

    @ApiOperation(value = "Get all capacity")
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ListRestResponse<CapacityResource> getAll(){
        final List<CapacityResource> collection = capacityService.getAll().stream().map(CapacityResource::new).collect(Collectors.toList());;
        return new ListRestResponse<>(collection);
    }


}
