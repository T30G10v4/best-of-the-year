package org.lessons.java.best_of_the_year.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/movies")
    public String movies(Model model, @RequestParam(name = "movieList") String movieList){


        model.addAttribute("movieList", movieList);
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
