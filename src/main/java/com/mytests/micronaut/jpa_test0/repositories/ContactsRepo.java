package com.mytests.micronaut.jpa_test0.repositories;

import com.mytests.micronaut.jpa_test0.data.Contact;
import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Query;
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
// https://youtrack.jetbrains.com/issue/IDEA-251994
@Repository("contacts")   // no reference to datasource configuration in application.properties
public interface ContactsRepo extends CrudRepository<Contact, Integer> {

    // https://youtrack.jetbrains.com/issue/IDEA-251891
    List<Contact> findByFirstnameNotEquals(String firstname); // 'Not' is shown as error

    // https://youtrack.jetbrains.com/issue/IDEA-251992
    String retrieveLastnameByEmailContains(String email); // projection part of name is not validated though it is completed

    String getEmailByLastnameAndFirstnameIlike(String lastname, String firstname);

    // https://youtrack.jetbrains.com/issue/IDEA-251993
    @Executable
    Contact find(String firstname, String lastname);   // no support for parameters validation in the simple  query methods that don't use 'By' syntax

    @Query(nativeQuery = true, value = "select * from contact s")
    List<Contact> nativeQuery();

    Contact findFirstOrderByIdDesc(); //https://youtrack.jetbrains.com/issue/IDEA-277095

    List<Contact> findOrderByEmailDesc(); //https://youtrack.jetbrains.com/issue/IDEA-277095



    // Integer findMaxId();  // doesn't work
}

