package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    HashMap<String,Movie> movieHashMap = new HashMap<>();
    HashMap<String,Director> directorHashMap = new HashMap<>();
    HashMap<String, List<String>> pairHashMap = new HashMap<>();

    public void addMovie(Movie movie){
        movieHashMap.put(movie.getName(), movie);
    }

    public void addDirector(Director director){
        directorHashMap.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movieName, String directorName){
        if(pairHashMap.containsKey(directorName)){
            pairHashMap.get(directorName).add(movieName);
        }
        else{
            List<String> list = new ArrayList<>();
            list.add(movieName);
            pairHashMap.put(directorName,list);
        }
    }

//    public void addMovieDirectorPair(String movie , String director) {
//        List<String> currentmovies = new ArrayList<>();
//        if (movieHashMap.containsKey(movie) && directorHashMap.containsKey(director)) {
//            if(pairHashMap.containsKey(director))
//            {
//                currentmovies = pairHashMap.get(director) ;
//            }
//            currentmovies.add(movie) ;
//            pairHashMap.put(director, currentmovies) ;
//        }
//    }

    public Movie getMovieByName(String name){
        return movieHashMap.get(name);
    }

    public Director getDirectorByName(String name){
        return directorHashMap.get(name);
    }

    public List<String> getMoviesByDirectorName(String name){
        return pairHashMap.get(name);
    }

    public List<String> findAllMovies(){
        List<String> list = new ArrayList<>();
        for(String s : movieHashMap.keySet()){
            list.add(s);
        }

        return list;
    }

    public void deleteDirectorByName(String name){

        //deleting from movieHashmap
        List<String> movieList = pairHashMap.get(name);
        for(String s : movieList){
            movieHashMap.remove(s);
        }
        //deleting from directorHashmap
        directorHashMap.remove(name);
        //deleting from pairHashMap
        pairHashMap.remove(name);

    }

    public void deleteAllDirectors(){
        for(String directorName : pairHashMap.keySet()){
            deleteDirectorByName(directorName);
        }
    }

}
