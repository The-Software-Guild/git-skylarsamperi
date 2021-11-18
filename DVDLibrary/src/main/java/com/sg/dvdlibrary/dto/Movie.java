package com.sg.dvdlibrary.dto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author skylarsamperi
 */
public class Movie {
    private String movieTitle;
    private String releaseDate;
    private String rating;
    private String directorName;
    private String studioName;
    private String userRating; 
    
    
    public Movie(String movieTitle){
        this.movieTitle= movieTitle;
    }
    public String getReleaseDate(){
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate){
        this.releaseDate=releaseDate;
    }
    public String getRating(){
       return rating;
    }
    public void setRating(String rating){
        this.rating= rating;
    }
    public void setDirectorName(String directorName){
        this.directorName=directorName;
    }
    public String getDirectorName(){
        return directorName;
    }
        public String getstudioName(){
       return studioName;
    }
    public void setStudioName(String studioName){
        this.studioName=studioName;
    }
    public String getuserRating(){
        return userRating;
    }
    public void setUserRating(String userRating){
        this.userRating= userRating; 
    }
    
    public String getMovieTitle(){
        return movieTitle;
    }
   


    
    
    
}
