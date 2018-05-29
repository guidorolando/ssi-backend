package com.ssi.ssi.domain.repository;

import com.ssi.ssi.domain.model.Area;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AreaRepository  extends CrudRepository <Area,Long>{

}


