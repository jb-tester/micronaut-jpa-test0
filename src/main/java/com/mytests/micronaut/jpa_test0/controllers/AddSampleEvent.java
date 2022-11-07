package com.mytests.micronaut.jpa_test0.controllers;

import com.mytests.micronaut.jpa_test0.data.Sample;

/**
 * *
 * <p>Created by irina on 03.06.2021.</p>
 * <p>Project: micronaut-jpa-test0</p>
 * *
 */
public class AddSampleEvent {
    Sample sample;
    public AddSampleEvent(Sample sample) {
        this.sample = sample;
    }

    public Sample getSample() {
        return sample;
    }
}
