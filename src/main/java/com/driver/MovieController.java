package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/movies")

public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("Movie added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        movieService.addDirector(director);
        return new ResponseEntity("Director added successfully",HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movieName, @RequestParam("director") String directorNAme){
        movieService.addMovieDirectorPair(movieName,directorNAme);
        return new ResponseEntity<>("Movie-Director Pair added successfully ",HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name){
        Movie response = movieService.getMovieByName(name);
        return new ResponseEntity<>(response, HttpStatus.FOUND );
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name){
        Director response = movieService.getDirectorByName(name);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String director){
        List<String> response = movieService.getMoviesByDirectorNAme(director);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> response = movieService.findAllMovies();
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam() String name){
        movieService.deleteDirectorByName(name);
        return new ResponseEntity<>("Director and its movies successfully deleted",HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("All director and their movies deleted successfully",HttpStatus.ACCEPTED);
    }

}
