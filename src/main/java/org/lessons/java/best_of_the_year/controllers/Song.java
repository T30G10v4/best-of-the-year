package org.lessons.java.best_of_the_year.controllers;

import java.util.Random;

public class Song {

    private int id;
    private String title;

    public Song(String title) {
        Random rnd = new Random();
        this.id = rnd.nextInt(999999);
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
