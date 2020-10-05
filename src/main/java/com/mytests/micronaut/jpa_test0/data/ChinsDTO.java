package com.mytests.micronaut.jpa_test0.data;

import io.micronaut.core.annotation.Introspected;

/**
 * *
 * <p>Created by irina on 05.10.2020.</p>
 * <p>Project: micronaut-jpa-test0</p>
 * *
 */
@Introspected
public class ChinsDTO {
    private String name;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
