package com.ssi.ssi.web;

import com.ssi.ssi.common.response.rest.ListRestResponse;
import com.ssi.ssi.common.response.rest.SingleRestResponse;
import com.ssi.ssi.resources.AssignmentResource;
import com.ssi.ssi.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {
    @Autowired
    private AssignmentService assignmentService;

    @RequestMapping(method = RequestMethod.GET)
    public ListRestResponse<AssignmentResource> getAll() {
        final List<AssignmentResource> collection = assignmentService.getAssignmentAll().stream().map(AssignmentResource::new).collect(Collectors.toList());
        return new ListRestResponse<>(collection);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}")
    public SingleRestResponse<AssignmentResource> getById(Long id) {
        final AssignmentResource assignmentResource = assignmentService.getAssignmentById(id).map(AssignmentResource::new).get();
        return new SingleRestResponse<>(assignmentResource);
    }

}
