package org.lessons.java.best_of_the_year.controllers;

import org.lessons.java.best_of_the_year.models.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @GetMapping
    public String movies(Model model){

        List<Movie> movieTitles = getBestMovies();

        model.addAttribute("list", movieTitles);
        return "movies";

    }

    @GetMapping("/{movieId}")
    public String movieDetail(@PathVariable int movieId, Model model){

        Boolean found = false;
        for (Movie m: getBestMovies()) {

            if(m.getId() == movieId) {
                model.addAttribute("movie", m);
                found = true;
            }

        }

        if(!found) return "404";

        return "movie-detail";
    }

    private List<Movie> getBestMovies() {

        List<Movie> movieTitles = new ArrayList<>();

        for(int i = 1; i<6; i++){

            movieTitles.add(new Movie(i,"Arma Letale "+i));

        }

        return movieTitles;

    }


}
