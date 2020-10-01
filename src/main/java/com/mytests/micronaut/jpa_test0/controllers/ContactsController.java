package com.mytests.micronaut.jpa_test0.controllers;

import com.mytests.micronaut.jpa_test0.data.Contact;
import com.mytests.micronaut.jpa_test0.repositories.ContactsRepo;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;
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
}
