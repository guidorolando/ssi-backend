package com.ssi.ssi.web;

import com.ssi.ssi.common.response.rest.SuccessRestResponse;
import com.ssi.ssi.domain.model.MaterialType;
import com.ssi.ssi.domain.repository.exception.MaterialTypeNotFountException;
import com.ssi.ssi.request.EmployeeRequest;
import com.ssi.ssi.resources.MaterialTypeResource;
import com.ssi.ssi.service.MaterialTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(value = "materialType", description = "materialType")
@RestController
@RequestMapping(value = "/materialType")
public class MaterialTypeController {

    @Autowired
    private MaterialTypeService materialTypeService;

    @PostMapping("/materialType")
    public ResponseEntity<MaterialTypeResource> createMaterialType(@RequestBody final MaterialType materialTypeFromRequest) {
        final MaterialType materialType = materialTypeService.save(materialTypeFromRequest);
        return ResponseEntity.ok(new MaterialTypeResource(materialType));
    }

    @GetMapping("/materialType")
    public ResponseEntity<List<MaterialTypeResource>> getAllMaterialType() {
        final List<MaterialTypeResource> collection = materialTypeService.getAll().stream().map(
                MaterialTypeResource::new).collect(Collectors.toList());
        return ResponseEntity.ok(collection);
    }

    @GetMapping("/materialType/{id}")
    public ResponseEntity<MaterialTypeResource> getByIdMaterialType(@PathVariable final long id) {
        return materialTypeService.getById(id).map(p -> ResponseEntity.ok(new MaterialTypeResource(p))).orElseThrow(() -> new MaterialTypeNotFountException(id));
    }

    @DeleteMapping("/materialType/{id}")
    public ResponseEntity<?> deleteMaterialType(@PathVariable("id") final long id) {
        return materialTypeService.getById(id).map(p -> {
            materialTypeService.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElseThrow(() -> new MaterialTypeNotFountException(id));
    }
    /* Method for create Material Type*/
    @ApiOperation(value = "Create new materialType")
    @RequestMapping(
            method = RequestMethod.POST)
    public SuccessRestResponse createMaterialType(@RequestBody MaterialTypeResource materialTypeResource){
        materialTypeService.addMaterialType(materialTypeResource);
        return new SuccessRestResponse();
    }
    /* Method for update Material Type*/
    @ApiOperation(value = "Update MaterialType")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public SuccessRestResponse updateMaterialType(@RequestBody MaterialTypeResource materialTypeResource, @PathVariable Long id){
        materialTypeService.updateMaterialType(materialTypeResource, id);
        return new SuccessRestResponse();
    }
    /* Method for delete Material Type*/
    @ApiOperation(value = "Delete MaterialType")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public SuccessRestResponse removeMaterialType(@PathVariable Long id){

        materialTypeService.deleteById(id);
        return new SuccessRestResponse();
    }

    public Boolean isRelation (Long id) {
        Boolean relation = Boolean.FALSE;

        return relation;
    }
}
