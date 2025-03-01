package com.bhishma.Globetrotter.entity;

import java.util.List;


public class Request {

    private String city;
    private String country;

    private List<String> clue;
    private List<String> funfact;
    private List<String> trivia;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getClue() {
        return clue;
    }

    public void setClue(List<String> clue) {
        this.clue = clue;
    }

    public List<String> getFunfact() {
        return funfact;
    }

    public void setFunfact(List<String> funfact) {
        this.funfact = funfact;
    }

    public List<String> getTrivia() {
        return trivia;
    }

    public void setTrivia(List<String> trivia) {
        this.trivia = trivia;
    }
}
