package com.mycompany.dvdstore.api;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.form.MovieForm;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/movie")
@RestController
public class MovieResource {

    //MovieService movieService = new MovieService();
    @Autowired
    MovieServiceInterface movieService;

    public MovieServiceInterface getMovieServiceInterface() {
        return movieService;
    }

    public void setMovieServiceInterface(MovieServiceInterface movieServiceInterface) {
        this.movieService = movieServiceInterface;
    }

    @GetMapping
    public List<Movie> list(){
        return movieService.getMovieList();

    }

    @GetMapping("/{id}")
    public Movie get(@PathVariable("id") long id){
        return movieService.getMovieById(id);
    }

    @PostMapping
    public Movie add(@RequestBody Movie movie) {
        return movieService.registerMovie(movie);
    }
}
