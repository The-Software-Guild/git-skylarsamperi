
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author skylarsamperi
 */
public class HealthyHearts {
    public static void main (String [] args){
        System.out.println("What is your age? "); 
        Scanner scanner= new Scanner(System.in); //Initializes the scanner
        int userAge= Integer.parseInt(scanner.nextLine()); 
        
        int MaxHR= 220- userAge;
        int minTargetHeartRate= (MaxHR/2);
        double maxTargetHeartRate= (MaxHR * .85 );
        int mTHR= (int)Math.round(maxTargetHeartRate); 
        
        System.out.println("Your maximum heart rate should be " + MaxHR + " beats per minute");
        
        System.out.println("Your target HR Zone is " +minTargetHeartRate +" - "+  mTHR + " beats per minute "   );
        
        
    }
    
}
