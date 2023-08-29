package com.example.myapplication;

public class Data {
//Constructor to set up collection of dynamic data(place visited and description)
    String title, description;


    public Data() {
    }

    public Data(String title, String description) {
        this.title = title;
        this.description = description;

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

}
