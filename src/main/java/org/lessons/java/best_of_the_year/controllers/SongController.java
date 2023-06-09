package org.lessons.java.best_of_the_year.controllers;

import org.lessons.java.best_of_the_year.models.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {

    @GetMapping
    public String songs(Model model){

        List<Song> songTitles = getBestSongs();

        model.addAttribute("list", songTitles);
        return "songs";

    }

    @GetMapping("/{songId}")
    public String songDetail(@PathVariable int songId, Model model){

        Boolean found = false;
        for (Song s: getBestSongs()) {

            if(s.getId() == songId)
            {
                model.addAttribute("song", s);
                found = true;
            }
        }

        if(!found)  return "404";
        return "song-detail";
    }

    private List<Song> getBestSongs() {

        List<Song> songTitles = new ArrayList<>();

        for(int i = 1; i<6; i++){

            songTitles.add(new Song(i, "Unforgiven "+i));

        }

        return songTitles;

    }


}
