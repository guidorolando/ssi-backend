package com.ssi.ssi.domain.repository;

import com.ssi.ssi.domain.model.Material;
import com.ssi.ssi.domain.model.Store;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StoreRepository extends CrudRepository<Store, Long> {

   /*@Query("select store from Store store where mat")
    List<Material> searchByText(@Param("id") Integer id);*/
}
