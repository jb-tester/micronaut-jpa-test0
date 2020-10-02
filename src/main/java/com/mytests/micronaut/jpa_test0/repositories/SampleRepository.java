package com.mytests.micronaut.jpa_test0.repositories;

import com.mytests.micronaut.jpa_test0.data.Sample;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.Slice;
import io.micronaut.data.repository.PageableRepository;

import java.util.List;

/**
 * *
 * <p>Created by irina on 02.10.2020.</p>
 * <p>Project: micronaut-jpa-test0</p>
 * *
 */
@Repository("default")
public interface SampleRepository extends PageableRepository<Sample,Integer > {

    
    Page<Sample> getByColor(String color, Pageable pageable);

    // for the next 2 methods the pageable parameter is removed by intention if the required property-backing parameter is missing;
    // the method of Slice<T> type should get the intention to add the pageable parameter if it is missing
    Slice<Sample> findByVersion(Integer version, Pageable pageable);
    
    List<Sample> findBySampleContains(String sample, Pageable pageable);

// if the return method is Page<Sample>, intention changes it to Integer, not to Page<Integer>    
    Page<String> findColorByVersion(Integer version, Pageable pageable);
    
    
}
