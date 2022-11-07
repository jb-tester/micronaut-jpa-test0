package com.mytests.micronaut.jpa_test0.controllers;

/**
 * *
 * <p>Created by irina on 11/4/2022.</p>
 * <p>Project: micronaut-jpa-test0</p>
 * *
 */
public class DummyEvent {
    String message;

    public DummyEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
