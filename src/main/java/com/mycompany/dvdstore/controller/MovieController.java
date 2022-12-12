package com.mycompany.dvdstore.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.form.MovieForm;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/movie")
@Controller
public class MovieController {

    //MovieService movieService = new MovieService();
    @Autowired
    MovieServiceInterface movieService;

    public MovieServiceInterface getMovieServiceInterface() {
        return movieService;
    }

    public void setMovieServiceInterface(MovieServiceInterface movieServiceInterface) {
        this.movieService = movieServiceInterface;
    }

   /* @GetMapping("/{id}")
    public String displayMovieCard(@PathVariable("id") long id, Model model){
        model.addAttribute("movie",movieService.getMovieById(id));
        return "movie-details";
    }*/

    @PostMapping("/add")
    public String addMovie(@Valid @ModelAttribute MovieForm form, BindingResult result){
        if (result.hasErrors()){
            return "add-movie-form";
        }
        Movie movie = new Movie();
        movie.setTitle(form.getTitle());
        movie.setGenre(form.getGenre());
        movie.setDescription(form.getDescription());
        movieService.registerMovie(movie);
        return "movie-added";
    }

}
