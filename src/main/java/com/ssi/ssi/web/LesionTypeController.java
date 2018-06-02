package com.ssi.ssi.web;

import com.ssi.ssi.domain.model.LesionType;
import com.ssi.ssi.service.LesionTypeService;
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
@RequestMapping("/lesionType")
@Api(value = "LesionType", description = "Lesion Types")
public class LesionTypeController {

    @Autowired
    private LesionTypeService lesionTypeService;

    @RequestMapping(
            method = RequestMethod.POST
    )
    private ResponseEntity<LesionType> createLesionType(@RequestBody LesionType lesionType) {
        return new ResponseEntity<LesionType>(lesionTypeService.createLesionType(lesionType), HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.PUT
    )
    public ResponseEntity<LesionType> updateLesionType(@RequestBody LesionType lesionType) {

        Boolean wasUpdated = lesionTypeService.updateLesionType(lesionType);
        if (wasUpdated) {
            Optional<LesionType> lesionTypeDb = lesionTypeService.findLesionTypeById(lesionType.getId());
            return new ResponseEntity<LesionType>(lesionTypeDb.get(), HttpStatus.OK);
        }

        return new ResponseEntity<LesionType>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(
            method = RequestMethod.GET
    )
    public List<LesionType> getAllLesionTypes() {

        List<LesionType> lesionTypeList = new ArrayList<>();

        lesionTypeService.getAllLesionTypes().forEach(
                lesionType -> lesionTypeList.add(lesionType)
        );

        return lesionTypeList;

    }
}
