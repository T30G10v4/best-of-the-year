package org.lessons.java.best_of_the_year.models;

import java.util.Random;

public class Song {

    private int id;
    private String title;

    public Song(int id, String title) {

        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
