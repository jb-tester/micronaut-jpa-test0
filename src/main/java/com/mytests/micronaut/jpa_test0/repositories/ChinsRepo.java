package com.mytests.micronaut.jpa_test0.repositories;

import com.mytests.micronaut.jpa_test0.data.Chins;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository("default")
public interface ChinsRepo extends CrudRepository<Chins, Integer> {

    List<Chins> findAll();
    List<Chins> findBySex(String sex);
    
    List<String> searchNameByColorContains(String color);
}
