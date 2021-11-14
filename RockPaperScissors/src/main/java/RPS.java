
import java.util.Random;
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

public class RPS {
          

      public static void main (String[] args){
          int computerWins= 0;
          int userWins=0;
          int gameNum=1; 
          int tie=0;
          
          Scanner scanner= new Scanner(System.in); //Reads what a Player Inputs
          
          
          while ((true) && (gameNum <= 10)){ 
              
              Random choice= new Random();
              
              String [] RPS = {"Rock", "Paper", "Scissors"}; //Initializes the computer picking a ranomd choice 
              int randomIndex= choice.nextInt(RPS.length);
              String computerChoice= RPS[randomIndex];
              
              String userMove;
              while (true){
                   System.out.println("This is game number: " + gameNum); //Tells Player what game number we are on 
                  System.out.println("Please enter your move: Rock, Paper or Scissors"); //Initializes a user to pick R P OR S 
                 
                  userMove= scanner.nextLine(); //Reads the players choice 
                              System.out.println("You picked " + userMove);

                  
               if ((userMove.equals("Rock"))||(userMove.equals("Paper"))|| (userMove.equals("Scissors"))) { 
                   break;
                   
                  
              }
              System.out.println(userMove + "is not a valid move."); //Invalid choice --> player will be told 
          
              }
              
              System.out.println("Computer picked: " + computerChoice); // prints out the computers random choice 
              
         
              
              if (userMove.equals(computerChoice)) { 
                System.out.println("The game was a tie!");
                tie++;
                 }
             else if (userMove.equals("Rock")) {
                  if (computerChoice.equals("Paper")) {
                       System.out.println("You lose!");
                        computerWins++;
                    
                  } 
             else if (computerChoice.equals("Scissors")) {
                 System.out.println("You win!");
                    userWins++;
                    }
             }
      
             else if (userMove.equals("Paper")) {
               if (computerChoice.equals("Rock")) {
                   System.out.println("You win!");
                    userWins++;
               } 
               
               else if (computerChoice.equals("Scissors")) {
                     System.out.println("You lose!");
                     computerWins++;
                 }
      }
      
              else if (userMove.equals("Scissors")) {
                 if (computerChoice.equals("Paper")) {
                   System.out.println("You win!");
                      userWins++; 
          
          
                         } 
                else if (computerChoice.equals("Rock")) {
                     System.out.println("You lose!");
                     computerWins++;
                    }
      }
            System.out.println("Total Player Wins: "+ userWins + "|"+  " Total Computer Wins:  "+ computerWins);
            System.out.println("*");
            System.out.println("Number of Ties " + tie); 
             System.out.println("*");
            System.out.println("Number of games Played: "+ gameNum); 
            System.out.println("*");
             System.out.println("Play again? (Yes or No)");
             String playAgain = scanner.nextLine();
             if (!playAgain.equals("Yes")) {
                 System.out.println("Thanks for playing!");
             break;
                    
                }
             else{
                 gameNum++;
             }
             
        }
    scanner.close();
  }                        
}
   
      

    

