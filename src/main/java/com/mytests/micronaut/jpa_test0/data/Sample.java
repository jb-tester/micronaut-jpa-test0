package com.mytests.micronaut.jpa_test0.data;

import javax.persistence.*;

/**
 * *
 * <p>Created by irina on 02.10.2020.</p>
 * <p>Project: micronaut-jpa-test0</p>
 * *
 */
@Entity
@Table(name = "sample", schema = "jbtests")
public class Sample {
    private int id;
    private Integer version;
    private String sample;
    private String color;

    public Sample(Integer version, String sample, String color) {
        this.version = version;
        this.sample = sample;
        this.color = color;
    }

    public Sample() {
        
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "version")
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Basic
    @Column(name = "sample")
    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    @Basic
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Sample: " +
                "id=" + id +
                ", version=" + version +
                ", sample='" + sample + 
                ", color='" + color;
    }
}
