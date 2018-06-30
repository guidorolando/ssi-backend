package com.ssi.ssi.domain.repository;

import com.ssi.ssi.domain.model.Material;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends CrudRepository<Material, Long>{

    @Query(nativeQuery = true, value = "exec get_all_material")
    List<Material> getAllMaterial();
}
