package com.ssi.ssi.resources;

import com.ssi.ssi.domain.model.Person;

public class AutoCompleteResource {

    private String ci;
    private String firsName;
    private String lastName;

    public AutoCompleteResource(Person person) {
        this.ci = person.getCi();
        this.firsName = person.getFirstName();
        this.lastName = person.getLastName();
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
