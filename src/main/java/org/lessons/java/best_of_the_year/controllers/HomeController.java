package org.lessons.java.best_of_the_year.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/movies")
    public String movies(){

        return "movies";

    }

    @GetMapping("/songs")
    public String songs() {

        return "songs";
    }

    private List<Movie> getBestMovies(){
        List <Movie> movies = new ArrayList<>();

        for(int i = 0; i < 5; i++) {

            movies.add(new Movie("Arma Letale "+i));


        }

        return movies;
    }

    private List<Song> getBestSongs(){
        List <Song> songs = new ArrayList<>();

        for(int i = 0; i < 5; i++) {

            songs.add(new Song("Unforgiven "+i));


        }

        return songs;
    }

}
