package com.ssi.ssi.web;

import com.ssi.ssi.domain.model.Area;
import com.ssi.ssi.domain.repository.exception.MessageNotFountException;
import com.ssi.ssi.resources.AreaResource;
import com.ssi.ssi.service.AreaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@Api(value = "area" , description = "area")
@RestController
@RequestMapping(value = "/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping
    public ResponseEntity<List<AreaResource>> getAll(){
        final List<AreaResource> collection = areaService.getAll().stream().map(AreaResource::new).collect(Collectors.toList());
        return ResponseEntity.ok(collection);
    }

//    @RequestMapping(
//            method = RequestMethod.POST
//    )
//    private ResponseEntity<Area> createArea(@RequestBody Area area) {
//        return new ResponseEntity<Area>(areaService.createArea(area), HttpStatus.CREATED);
//    }


    @GetMapping("/{id}")
    public ResponseEntity<AreaResource> get(@PathVariable final long id) {
        return areaService.getId(id).map(p -> ResponseEntity.ok(new AreaResource(p))).orElseThrow(() -> new MessageNotFountException(id));
    }

    @PostMapping
    public ResponseEntity<AreaResource> post(@RequestBody final Area areaFromRequest) {
        final Area area = areaService.save(areaFromRequest);
        return ResponseEntity.ok(new AreaResource(area));
    }


    @PutMapping("/{id}")
    public ResponseEntity<AreaResource> put(@PathVariable("id") final long id, @RequestBody Area areaFromRequest) {
        final Area area = areaFromRequest;
        final AreaResource resource;
        boolean isvalidate = areaService.isValidateArea(area);
        if(isvalidate){
            areaService.save(area);
            resource = new AreaResource(area);
            return ResponseEntity.ok(resource);
        }

        return new ResponseEntity(area,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") final long id) {
        return areaService.getId(id).map(p -> {
            areaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElseThrow(() -> new MessageNotFountException(id));
    }


}

