package com.ssi.ssi.web;


import com.ssi.ssi.resources.AutoCompleteResource;
import com.ssi.ssi.service.AutoCompleteService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Autocomplete")
@Api(value="Autocomplete", description="find person")
public class AutoCompleteController {

    @Autowired
    private AutoCompleteService autoCompleteService;


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{search}"
    )
    public List<AutoCompleteResource> findAllPersonsByParameter(@PathVariable("search") String search){

        List<AutoCompleteResource> autoCompleteResources = new ArrayList<>();

        autoCompleteService.findAllPersonsByParameter(search).forEach(
                employee -> autoCompleteResources.add( new AutoCompleteResource(employee))
        );

        return autoCompleteResources;
    }


}
