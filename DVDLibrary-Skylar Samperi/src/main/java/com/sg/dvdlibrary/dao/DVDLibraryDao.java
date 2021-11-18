/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Movie;
import java.util.List;

/**
 *
 * @author skylarsamperi
 */
public interface DVDLibraryDao {
    Movie addMovieTitle(String movieTitle, Movie movie);
    
    List<Movie> getAllMovies();
    
    Movie getMovieTitle(String movieTitle);
    
    Movie removeMovieTitle(String movieTitle);
    
}
