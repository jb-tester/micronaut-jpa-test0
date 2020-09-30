package com.mytests.micronaut.jpa_test0.controllers;

import com.mytests.micronaut.jpa_test0.data.Chins;
import com.mytests.micronaut.jpa_test0.repositories.ChinsRepo;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import javax.inject.Inject;
import java.util.List;

@Controller
public class ChinsController {

    @Inject
    ChinsRepo repo;

    @Get("/all")
    public List<Chins> getAll(){
      return repo.findAll();
    }
    @Get("/bysex/{sex}")
    public List<Chins> sex(String sex){
        return repo.findBySex(sex);
    }
    
    @Get(uri = "/namesbycolor/{color_pattern}")
    public List<String> colors(@PathVariable("color_pattern") String color_pattern){
        return  repo.searchNameByColorContains(color_pattern);
    }
    
}
