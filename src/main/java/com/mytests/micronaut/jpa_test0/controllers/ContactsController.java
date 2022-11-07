package com.mytests.micronaut.jpa_test0.controllers;

import com.mytests.micronaut.jpa_test0.data.Contact;
import com.mytests.micronaut.jpa_test0.repositories.ContactsRepo;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import jakarta.inject.Inject;
import java.util.List;

/**
 * *
 * <p>Created by irina on 30.09.2020.</p>
 * <p>Project: micronaut-jpa-test0</p>
 * *
 */
@Controller("/contacts")
public class ContactsController {
    
    @Inject
    ContactsRepo repo;
    
    @Get("/byname/{name}")
    public List<Contact> byname(String name){
      return repo.findByFirstnameNotEquals(name);  
        
    }
    @Get("/bymail/{email}")
    public String bymail(String email){
        return repo.retrieveLastnameByEmailContains(email);

    }

    @Get("/bynames/{lname}.{fname}")
    public String mailbynames(String fname, String lname){
        return repo.getEmailByLastnameAndFirstnameIlike(lname, fname);

    }
    @Get("/bynames2/{lname}.{fname}")
    public Contact bynames(String fname, String lname){
        return repo.find(fname, lname);

    }

    @Get("/native_query")
    public List<Contact> native_query() {
        return repo.nativeQuery();
    }

    @Get("/lastContact")
    public String getLastContact(){
        return "last contact id = "+repo.findFirstOrderByIdDesc().getId();
    }

    @Get("/allOrdered")
    public List<Contact> getAllOrdered(){
        return repo.findOrderByEmailDesc();
    }
}
