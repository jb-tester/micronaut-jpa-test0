package com.mytests.micronaut.jpa_test0.repositories;

import com.mytests.micronaut.jpa_test0.data.Contact;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

/**
 * *
 * <p>Created by irina on 30.09.2020.</p>
 * <p>Project: micronaut-jpa-test0</p>
 * *
 */
@Repository("contacts")
public interface ContactsRepo extends CrudRepository<Contact, Integer> {
    
    List<Contact> findByFirstnameNotEquals(String firstname);
    
    String retrieveLastnameByEmailContains(String email);
    
    String getEmailByLastnameAndFirstnameIlike(String lastname, String firstname);
    
    @Executable
    Contact find(String firstname, String lastname);   // no support for parameters validation in the simple  query methods that don't use 'By' syntax
}
