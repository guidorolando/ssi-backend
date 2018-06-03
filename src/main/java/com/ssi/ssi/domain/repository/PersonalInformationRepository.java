package com.ssi.ssi.domain.repository;

import com.ssi.ssi.domain.model.Capacity;
import com.ssi.ssi.domain.model.PersonalInformation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonalInformationRepository extends CrudRepository<PersonalInformation,Long> {
    @Query("SELECT personalInformation FROM PersonalInformation personalInformation WHERE personalInformation.isDeleted=0 ")
    List<PersonalInformation> getAll();
}
