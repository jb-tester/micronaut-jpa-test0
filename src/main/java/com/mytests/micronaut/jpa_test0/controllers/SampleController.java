package com.mytests.micronaut.jpa_test0.controllers;

import com.mytests.micronaut.jpa_test0.data.Sample;
import com.mytests.micronaut.jpa_test0.repositories.SampleRepository;
import io.micronaut.context.event.ApplicationEventPublisher;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.Slice;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.transaction.annotation.TransactionalEventListener;

import jakarta.inject.Inject;

import javax.transaction.Transactional;
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

    @Inject ApplicationEventPublisher eventPublisher;
    
    @Transactional
    @Post("/add/{v}/{s}/{c}")
    public void addSample(@PathVariable int v, @PathVariable String s, @PathVariable String c){
        Sample sample = new Sample(v, s, c);
        repo.save(sample) ;
        AddSampleEvent sampleEvent = new AddSampleEvent(sample);
        eventPublisher.publishEvent(sampleEvent);
        eventPublisher.publishEvent(new DummyEvent(eventPublisher.getClass().toString()));
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
       return repo.findColorByVersion(vers, Pageable.from(0,3));
    }
    @Get("/explicit/{vers}")
    public Page<Sample> explicitQuery(@PathVariable("vers") Integer vers) {
        return repo.explicitQuery(vers, Pageable.from(0,3));
    }
    @Get("/native/{vers}")
    public Page<Sample> nativeQuery(@PathVariable("vers") Integer vers) {
        return repo.nativeQuery(vers, Pageable.from(0,3));
    }

    @TransactionalEventListener
    void onNewSampleEvent(AddSampleEvent event) {
        System.out.println("new sample added: " + event.getSample().toString());
    }
    @TransactionalEventListener
    void onDummyEvent(DummyEvent event) {
        System.out.println("*******" + event.getMessage()+"********");
    }
}
