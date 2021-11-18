/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.Movie;
import java.util.List;

/**
 *
 * @author skylarsamperi
 */
public class DVDLibraryView {
    
    private UserIO io;
    
    public int printMenuAndGetSelection(){ //displays the menu for the user to pick a choice from the list 
        io.print("Main Menu");
        io.print("1. List of Movies");
        io.print("2. Add a Movie");
        io.print("3. View a Movie");
        io.print("4. Remove a Movie");
        io.print("5. Edit a Movie");
        io.print("6. Exit");
        
        return io.readInt("Please select from the above choices.", 1,6);
        
    }

    public Movie getNewMovieInfo(){
        String movieTitle= io.readString("Please enter Movie Title");
        String releaseDate= io.readString("Please enter the Release Date");
        String rating= io.readString("Please enter The AARP Rating");
        String directorName= io.readString("Please enter the Director Name");
        String studioName= io.readString("Please enter the Studio Name");
        String userRating= io.readString("Please enter Your Rating");
        Movie currentMovie= new Movie(movieTitle);
        currentMovie.setReleaseDate(releaseDate);
        currentMovie.setRating(rating);
        currentMovie.setDirectorName(directorName);
        currentMovie.setStudioName(studioName);
        currentMovie.setUserRating(userRating);
        return currentMovie;
    }
    public void displayCreateMovieBanner(){
        io.print("===Add Movie===");
    }
    public void displayCreateSuccessBanner(){
        io.readString("Movie sucessfully added. Please hit enter to continue");
    }
    public void displayMovieList(List<Movie> movieList){
        for(Movie currentMovie : movieList){
            String movieInfo = String.format("#%s : %s %s",
            currentMovie.getMovieTitle(),
            currentMovie.getReleaseDate(),
            currentMovie.getRating(),
            currentMovie.getDirectorName(),
            currentMovie.getstudioName(),
            currentMovie.getuserRating());
            io.print(movieInfo);
        }
        io.readString("Please hit enter to continue");
    }
    public void displayDisplayAllBanner(){
        io.print("=== Display All Movies ===");
    }
    public void displayDisplayMovieBanner(){
        io.print("===Display Movie===");
    }
    public String getMovieChoice(){
        return io.readString("Please enter the Movie Title");
    }
    public void displayMovie(Movie movie){
       if (movie != null){
           io.print(movie.getMovieTitle());
           io.print(movie.getReleaseDate());
           io.print(movie.getRating());
           io.print(movie.getDirectorName());
           io.print(movie.getstudioName());
           io.print(movie.getuserRating()); 
           io.print("");
         }
       else{
           io.print("No such Movie Title");
            }
            io.readString("Please hit enter to continue.");
            }
   
        public void displayRemoveMovieBanner(){
            io.print("===Remove Movie===");
        }
        public void displayRemoveResult(Movie movieRecord){
            if(movieRecord!=null){
                io.print("Movie sucessfully removed");
            }
            else{
                io.print("No such movie title");
            }
            io.readString("Please hit enter to continue.");
        }
        
        public void displayExitBanner(){
            io.print("Goodbye!!");
        }
        public void displayUnknownCommandBanner(){
            io.print("Unknown Command!!!");
        }
        public DVDLibraryView(UserIO io){
            this.io=io;
        }
}
    
    
    

