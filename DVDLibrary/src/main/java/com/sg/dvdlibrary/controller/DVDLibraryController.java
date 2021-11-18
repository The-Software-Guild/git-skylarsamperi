/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.sg.dvdlibrary.dto.Movie;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author skylarsamperi
 */
public class DVDLibraryController {
    
    private UserIO io= new UserIOConsoleImpl(); //dependency injection
    private DVDLibraryView view; //dependency injection
    private DVDLibraryDao dao;//dependency injection
    
    public void run() { 
        boolean keepGoing= true; //this loops continues to run until the user quits
        int menuSelection =0;
        while(keepGoing){
            menuSelection = getMenuSelection();
          
          switch (menuSelection){
              case 1:
                  listMovies(); //calls function - same for rest of these cases 
                  break;
              case 2:
                  createMovie();
                    break;
              case 3:
                  viewMovie();
                  break;
              case 4:
                  removeMovie();
                    break;      
                case 5:
                  io.print("EDIT MOVIE");
                  break;
              case 6:
                  keepGoing=false;
                  break;
              default:
                    unknownCommand();
             }
        
         }
        exitMessage();
     }
   private int getMenuSelection(){
       return view.printMenuAndGetSelection();
   }

   
   private void createMovie(){
       view.displayCreateMovieBanner();
       Movie newMovie= view.getNewMovieInfo();
       dao.addMovieTitle(newMovie.getMovieTitle(), newMovie);
       view.displayCreateSuccessBanner();
   }
   private void listMovies(){
       view.displayDisplayAllBanner();
       List<Movie>movieList = dao.getAllMovies();
       view.displayMovieList(movieList); 
   }
   
   private void viewMovie(){
       view.displayDisplayMovieBanner();
       String movieTitle= view.getMovieChoice();
       Movie movie= dao.getMovieTitle(movieTitle);
       view.displayMovie(movie);
       
   }
   private void removeMovie(){
       view.displayRemoveMovieBanner();
       String movieTitle= view.getMovieChoice();
       Movie removedMovie= dao.removeMovieTitle(movieTitle);
       view.displayRemoveResult(removedMovie);
   }
   private void unknownCommand(){
       view.displayUnknownCommandBanner();
   }
   private void exitMessage(){
       view.displayExitBanner();
   }
   public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view){
       this.dao=dao;
       this.view=view;
   }
    
 
} 
