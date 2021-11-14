
import java.util.Scanner;
import java.util.Random;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author skylarsamperi
 */
public class Dogs {
    public static void main (String [] args ){
        System.out.println("What is your dogs name?");
        
        Scanner scanner= new Scanner(System.in); //Initializes the scanner
        String dogName = scanner.nextLine(); //Reads  dog name 
        System.out.println("Well then, I have this highly reliable report on " + dogName + "'s presitigous background right here.");

            Random genetics= new Random(); //generates a random genetic number
            int array []= new int[5];// creates an array 
            int total=100; // declares the total and sets the bounds 
            for (int i=0; i<array.length; i++){ //intializes the array 
                array[i]= genetics.nextInt(total);
                total -= array[i]; //subtracts from the total of the array to ensure it's less than 100
            }
            array[4]= total; 
            System.out.println(dogName + " is : ");
            System.out.println(array[0]+ "% German Sheppard");
            System.out.println(array[1]+ "% Golden Retriever");
            System.out.println(array[2]+ "% Corgi");
            System.out.println(array[3]+ "% American Eskimo");
            System.out.println(array[4]+  "% Yorkie");

            System.out.println("WOW, that's Quite the Dog you got there!");
               
        
        
       

    
           }
        
        }


    
    

