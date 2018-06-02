package com.ssi.ssi.service;

import com.ssi.ssi.domain.model.Person;
import com.ssi.ssi.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoCompleteService {

    @Autowired
    private PersonRepository personRepository;


    public Iterable<Person> findAllPersonsByParameter(String search) {
        return personRepository.findByFirstNameLikeAndCiLike(search, search, search);
    }
}
