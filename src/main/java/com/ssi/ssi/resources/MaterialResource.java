package com.ssi.ssi.resources;


import com.ssi.ssi.domain.model.Material;
import com.ssi.ssi.domain.model.MaterialType;


public class MaterialResource {

    private final Material material;

    private Long id;

    private String name;

    private String description;

    private MaterialType matType;


    public MaterialResource(final Material material) {
        this.material = material;
        this.id = material.getId();
        this.name = material.getName();
        this.description = material.getMatDescription();
        this.matType = material.getMaterialType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String matName) {
        this.name = matName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MaterialType getMatType() {
        return matType;
    }

    public void setMatType(MaterialType matType) {
        this.matType = matType;
    }
}
