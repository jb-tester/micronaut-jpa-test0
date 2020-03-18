package com.mytests.micronaut.jpa_test0.data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Chins {
    private Integer id;
    private String name;
    private String color;
    private String birthday;
    private Integer weight;
    private String sex;
    private Byte forSale;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "birthday")
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "weight")
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "forSale")
    public Byte getForSale() {
        return forSale;
    }

    public void setForSale(Byte forSale) {
        this.forSale = forSale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chins chins = (Chins) o;
        return Objects.equals(id, chins.id) &&
                Objects.equals(name, chins.name) &&
                Objects.equals(color, chins.color) &&
                Objects.equals(birthday, chins.birthday) &&
                Objects.equals(weight, chins.weight) &&
                Objects.equals(sex, chins.sex) &&
                Objects.equals(forSale, chins.forSale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, color, birthday, weight, sex, forSale);
    }
}
