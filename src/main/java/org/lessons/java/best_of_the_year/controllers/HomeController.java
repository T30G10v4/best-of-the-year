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

}
