/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.ui;

import java.util.Scanner;

/**
 *
 * @author skylarsamperi
 */
public class UserIOConsoleImpl implements UserIO {
    
    private Scanner console= new Scanner (System.in);
    

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public double readDouble(String prompt) {
        while(true){
        try{
        return Double.parseDouble(this.readString(prompt));
        
        }
        catch(NumberFormatException e){
            this.readString("Try again");
            
        }
       }  
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
    while(true){
        try{
        double pick= Double.parseDouble(this.readString(prompt));
            if(pick>= min && pick <= max)
                return pick;
            
        
                  }
        catch(NumberFormatException e){
            this.readString("Try again");
            
        }
       }   
    }

    @Override
    public float readFloat(String prompt) {
            while(true){
                    try{
                        return Float.parseFloat(this.readString(prompt));
        
                            }
                            catch(NumberFormatException e){
                              this.readString("Try again");
            
                                        }
                         }
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
    while(true){
                    try{
                       float pick= Float.parseFloat(this.readString(prompt));
                       if(pick >= min && pick<=max)
                           return pick;
        
                            }
                            catch(NumberFormatException e){
                              this.readString("Try again");
            
                                        }
                         }    }

    @Override
    public int readInt(String prompt) {
while(true){
        try{
        return Integer.parseInt(this.readString(prompt));
        
        }
        catch(NumberFormatException e){
            this.readString("Try again");
            
        }
       }      }

    @Override
    public int readInt(String prompt, int min, int max) {
        while(true){
        try{
        int pick= Integer.parseInt(this.readString(prompt));
            if(pick>= min && pick <= max)
                return pick;
            
        
        }
        catch(NumberFormatException e){
            this.readString("Try again");
            
        }
       }  
    }

    @Override
    public long readLong(String prompt) {
            while(true){
               try{
                     return Long.parseLong(this.readString(prompt));
        
        }
        catch(NumberFormatException e){
            this.readString("Try again");
            
        }
       }      }

    @Override
    public long readLong(String prompt, long min, long max) {
    while(true){
                    try{
                        Long pick= Long.parseLong(this.readString(prompt));
                        if (pick>= min && pick<=max)
                            return pick;
        
                            }
                            catch(NumberFormatException e){
                              this.readString("Try again");
            
             }
         } 
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return console.nextLine();
        
    }
  
    
}
