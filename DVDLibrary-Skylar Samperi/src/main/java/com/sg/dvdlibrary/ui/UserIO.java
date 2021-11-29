/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

/**
 *
 * @author skylarsamperi
 */
public interface UserIO { //the list that tells us what our code can do, has to be ble to pritn
    void print(String msg);
    
    double readDouble(String prompt);
    
    double readDouble(String prompt, double min, double max);
    
    float readFloat(String prompt);
    
    float readFloat(String prompt, float min, float max);    
    
    int readInt(String prompt);
    
    int readInt(String prompt, int min, int max);    
    
    long readLong(String prompt);
    
    long readLong(String prompt, long min, long max);   
    
    String readString(String prompt); 
    
}
