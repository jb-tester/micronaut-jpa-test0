package com.mytests.micronaut.jpa_test0.controllers;

import com.mytests.micronaut.jpa_test0.data.Sample;
import com.mytests.micronaut.jpa_test0.repositories.SampleRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.Slice;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;
import java.util.List;

/**
 * *
 * <p>Created by irina on 02.10.2020.</p>
 * <p>Project: micronaut-jpa-test0</p>
 * *
 */
@Controller("/samples")
public class SampleController {
     @Inject
    SampleRepository repo;
     
    @Post("/add/{v}/{s}/{c}")
    public void addSample(@PathVariable int v, @PathVariable String s, @PathVariable String c){
       repo.save(new Sample(v,s, c)) ;
    }

    @Get("/bycolor/{color}")
    public Page<Sample> getByColor(@PathVariable("color") String color) {
        return repo.getByColor(color, Pageable.from(0,3));
    }

    @Get("/byversion/{vers}")
    public Slice<Sample> getbyversion(@PathVariable("vers") Integer vers) {
        return repo.findByVersion(vers, Pageable.from(0,3));
    }

    @Get("/bysample/{s}")
    public List<Sample> getbysample(@PathVariable("s") String s) {
        return repo.findBySampleContains(s,Pageable.from(0,3));
    }

    @Get("/colorbyversion/{vers}")
    public Page<String> getcolorbyversion(@PathVariable("vers") Integer vers) {
       // return repo.findColorByVersion(vers, Pageable.from(0,3));
    }
}
