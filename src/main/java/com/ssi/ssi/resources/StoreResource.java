package com.ssi.ssi.resources;

import com.ssi.ssi.domain.model.Material;
import com.ssi.ssi.domain.model.Store;


public class StoreResource {
    private  final Store store;
    private Long id;
    private String name;
    private Material material;
    private Integer quantity;

    

    public  StoreResource(final Store store){
        this.store = store;
        this.id = store.getId();
        this.name = store.getName();
        this.quantity = store.getQuantity();
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

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
