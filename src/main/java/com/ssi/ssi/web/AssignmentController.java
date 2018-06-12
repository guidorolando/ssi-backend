package com.ssi.ssi.web;

import com.ssi.ssi.domain.model.Assignment;
import com.ssi.ssi.resources.AssignmentResource;
import com.ssi.ssi.service.AssignmentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/assignment")
@Api(value="assignment", description="assignments")
public class AssignmentController {
    @Autowired
    private AssignmentService assignmentService;

    /*@RequestMapping(method = RequestMethod.GET)
    public ListRestResponse<AssignmentResource> getAll() {
        final List<AssignmentResource> collection = assignmentService.getAssignmentAll().stream().map(AssignmentResource::new).collect(Collectors.toList());
        return new ListRestResponse<>(collection);
        return null;
    }*/

    /*@RequestMapping(method = RequestMethod.POST, value = "/{id}")
    public SingleRestResponse<AssignmentResource> getById(Long id) {
        final AssignmentResource assignmentResource = assignmentService.getAssignmentById(id).map(AssignmentResource::new).get();
        return new SingleRestResponse<>(assignmentResource);
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ListRestResponse<AssignmentResource> assignmentMaterial(@RequestBody AssignmentResource assignmentResource){
        return null;
    }*/
    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity<AssignmentResource> createAssignment(@RequestBody Assignment assignmentNew) {
        Assignment assignment1 = assignmentService.saveAssignment(assignmentNew);
        return ResponseEntity.ok(new AssignmentResource(assignment1));
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<AssignmentResource> getAllAssignment(){
        List<AssignmentResource> materialResources = new ArrayList<>();
        assignmentService.getAllAssignment().forEach(
                assignment -> materialResources.add(new AssignmentResource(assignment)) );
        return materialResources;
    }
}
