package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Movie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author skylarsamperi
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao{

    @Override
    public Movie addMovieTitle(String movieTitle, Movie movie) {
         Movie prevMovie= movies.put(movieTitle, movie);
        return prevMovie;
    }
  
    @Override
    public List<Movie> getAllMovies() { //converts the collection of movies into a list using the return method
        return new ArrayList<Movie>(movies.values());
    }

    @Override
    public Movie getMovieTitle(String movieTitle) {
        return movies.get(movieTitle);
    }
    
    @Override
    public Movie removeMovieTitle(String movieTitle) {
        Movie removedMovie= movies.remove(movieTitle);
        return removedMovie;
    }


    private Map<String, Movie> movies= new HashMap<>();



    
}
