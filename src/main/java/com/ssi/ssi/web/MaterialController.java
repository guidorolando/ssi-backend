package com.ssi.ssi.web;

import com.ssi.ssi.domain.model.Material;
import com.ssi.ssi.resources.MaterialResource;
import com.ssi.ssi.service.MaterialService;
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

@RestController
@RequestMapping("/Material")
@Api(value="Material", description="Materials")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @RequestMapping(method = RequestMethod.GET)
    public List<MaterialResource> getAllMaterial(){
        List<MaterialResource> materialResources = new ArrayList<>();
        materialService.getAllMaterial().forEach(
                material -> materialResources.add(new MaterialResource(material)) );
        return materialResources;
    }
    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity<MaterialResource> createMaterial(@RequestBody Material materialNew){
        Material material = materialService.saveMaterial(materialNew);
        return ResponseEntity.ok(new MaterialResource(material));
    }

}
