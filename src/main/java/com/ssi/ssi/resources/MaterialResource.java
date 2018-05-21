package com.ssi.ssi.resources;

import com.ssi.ssi.domain.model.Material;
import com.ssi.ssi.domain.model.MaterialType;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class MaterialResource {
    private final Material material;
    private Long id;
    private String name;
    private MaterialType materialType;

    public  MaterialResource(final Material material){
        this.material = material;
        this.id = material.getId();
        this.name = material.getName();
        this.materialType = material.getMaterialType();
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

    public void setName(String name) {
        this.name = name;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }
}
