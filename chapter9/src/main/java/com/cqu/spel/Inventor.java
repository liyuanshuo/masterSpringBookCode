package com.cqu.spel;

import com.cqu.PlaceOfBirth;

import java.util.Date;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 19:31
 * @description :  add description here
 */
public class Inventor {

    private String name;
    private String nationality;
    private String[] inventions;
    private Date birthdate;
    private PlaceOfBirth placeOfBirth;

    public Inventor(String nikola_tesla, Date time, String serbian) {}

    public Inventor(String name, String nationality, Date birthdate) {
        this.name = name;
        this.nationality = nationality;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String[] getInventions() {
        return inventions;
    }

    public void setInventions(String[] inventions) {
        this.inventions = inventions;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public PlaceOfBirth getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(PlaceOfBirth placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }
}
