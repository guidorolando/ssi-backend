package com.ssi.ssi.web;

import com.ssi.ssi.common.response.rest.SuccessRestResponse;
import com.ssi.ssi.domain.model.Material;
import com.ssi.ssi.request.MaterialRequest;
import com.ssi.ssi.resources.MaterialResource;
import com.ssi.ssi.service.MaterialService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private SuccessRestResponse createMaterial(@RequestBody MaterialRequest materialNew){
        materialService.saveMaterial(materialNew);
        return new SuccessRestResponse();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Material> findMaterialById(@PathVariable Long id){
        Optional<Material> material = materialService.getMaterialById(id);
        if(material.isPresent()){
            return new ResponseEntity<Material>(material.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping( value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteMaterial(@PathVariable Long id) {

        Boolean wasDeleted = materialService.deleteById(id);
        HttpStatus responseStatus = wasDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseStatus);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Material> updateMaterial(@PathVariable Long id, @RequestBody MaterialRequest materialNew){
        Boolean wasUpdated = materialService.updateMaterial(materialNew.getId(), materialNew);
        if (wasUpdated) {
            Optional<Material> materialUp = materialService.getMaterialById(materialNew.getId());
            return new ResponseEntity<Material>(materialUp.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Material>(HttpStatus.NOT_FOUND);
    }
}
