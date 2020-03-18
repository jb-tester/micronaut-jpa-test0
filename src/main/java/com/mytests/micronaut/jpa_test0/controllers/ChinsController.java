package com.mytests.micronaut.jpa_test0.controllers;

import com.mytests.micronaut.jpa_test0.data.Chins;
import com.mytests.micronaut.jpa_test0.repositories.ChinsRepo;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

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
}
