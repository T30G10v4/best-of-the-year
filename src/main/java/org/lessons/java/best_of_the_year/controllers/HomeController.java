package org.lessons.java.best_of_the_year.controllers;



import org.lessons.java.best_of_the_year.models.Movie;
import org.lessons.java.best_of_the_year.models.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(Model model) {
        model.addAttribute("username", "Matteo");
        return "home";
    }

    @GetMapping("/movies")
    public String movies(Model model){


        List<Movie> movies = getBestMovies();
        String movieTitles = "";
        for (Movie m : movies){

            movieTitles+= m.getTitle() + ", ";

        }
        movieTitles = movieTitles.substring(0, movieTitles.length() - 2);
        model.addAttribute("list", movieTitles);
        return "movies";

    }

    @GetMapping("/movies/{movieId}")
    public String movieDetail(@PathVariable int movieId, Model model){

        for(Movie m : getBestMovies()){
            if(m.getId() == movieId){
                // Movie richiesto
                model.addAttribute("movie", m);
            }
        }
        return "movie-detail";
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
