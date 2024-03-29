package com.mytests.micronaut.jpa_test0.repositories;

import com.mytests.micronaut.jpa_test0.data.Chins;
import com.mytests.micronaut.jpa_test0.data.ChinsDTO;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository("default")
public interface ChinsRepo extends CrudRepository<Chins, Integer> {

    List<Chins> findAll();

    List<ChinsDTO> findByColorContains(String color); // DTO projections: https://youtrack.jetbrains.com/issue/IDEA-252185
    
    // https://youtrack.jetbrains.com/issue/IDEA-251991
    List<String> listName();   // 'list[projection][OrderBy]' format is not supported

    List<Chins> findBySex(String sex);

    List<String> searchNameByColorContains(String color);
    
    // https://youtrack.jetbrains.com/issue/IDEA-251990
    List<Chins> queryOrderByNameDesc(); // related to the below case, 'Desc'/'Asc' is reported as error
    
    List<Chins> findOrderByName(); // '<find, query, get...>OrderBy' format is not supported: completion doesn't work, parameter is required by inspection though it is not required here

    List<Chins> findBySexOrderByNameAndColor(String sex); // multiple orderBy clause

    // https://youtrack.jetbrains.com/issue/IDEA-299965
    List<Chins> findAllOrderBySexAndName();


}
