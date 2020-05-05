//Pedro Sallun dice game

import java.util.Scanner;
import java.util.Random;

public class FinalProject 
{
    public static void main(String[] args) 
    {
    
         menubeginning();      
    }
    
       private static void menubeginning()
   {
   
   //here the user can decide what game to play
   
   int gameroption;
   
      System.out.println("--------------------");
		System.out.println("Option 1: Dice Game");
		System.out.println("--------------------");
		System.out.println("Option 2: Exit");
      System.out.println("--------------------");
      
      Scanner input = new Scanner(System.in);
	      System.out.println("Option:");  
         gameroption = input.nextInt(); 
         
     if (gameroption == 1){
     //if he decided to play the game one we will run the game1 menu
          menugame();
         }
         
     else {
     //if not we will juts say thanks 
         System.out.println("Thx");
      }
   
   }
   
   private static void menugame()
     {
      //here the user will give us the information for the game to start

   int numPlayers;
   int rollsPlayers;
   
      System.out.println("--------------------");
		System.out.println("Select how many players");
		System.out.println("--------------------");
		System.out.println("4 players");
		System.out.println("6 players");
		System.out.println("8 players");
		System.out.println("10 players");
      System.out.println("12 players");
      System.out.println("20 players");
      System.out.println("--------------------");
      
      Scanner input = new Scanner(System.in);
	      System.out.println("Enter 4, 6, 8, 10, 12 or 20:");  
         numPlayers = input.nextInt();
         
         if (numPlayers == 4 || numPlayers == 6 || numPlayers == 8 || numPlayers == 10 || numPlayers == 12 ||numPlayers == 20 )
         {
          System.out.println("How many rools per player: ");  
         rollsPlayers = input.nextInt();
         // with the information we will be able to run the dice program
            diceRoll(rollsPlayers, numPlayers);
         }
         
         else
         {
         error();
         }
   }

   private static void diceRoll(int rollsPlayers, int numPlayers )
   {
   //we take all the information from the menugame method and we apply that to creat the dice rolls and store the information on the arrays
    int max = 6;
    int min = 1;
    Random rand = new Random ();
        int [] [] rolls = new int [numPlayers] [rollsPlayers];
        int i;
        int j;
        
  // making the random dice roll generation get storaged on the array
        for ( i = 0; i <= (numPlayers - 1); i++ )
        {
            for (j = 0; j <= (rollsPlayers -1); j++ )
        {
            rolls[i][j] = rand.nextInt((max-min) +1) + min;
                    }
        }
        //now that we have all the numbers stored we need to take this information and make a summary
        summary(rollsPlayers,numPlayers,rolls);
}
        
   private static void summary(int rollsPlayers, int numPlayers, int [][] rolls ){
   // with the information on methof diceRoll storaged on the array rools we will use this data and make a summary
  // priting the array rools 
  
   System.out.println("--------------------------------------");
    System.out.println("6-Sided Dice Roll Summary");
    System.out.println("-------------------------------------");
    System.out.println(" Players \t Rolls\t\t Total\t Average");
    System.out.println("-------------------------------------");
    

    for (int i=0; i < rolls.length;i++)
    {
    int p = i + 1;
    int total = 0;
    
    System.out.print("Player" + p + "\t");
      for (int j = 0; j < rolls[i].length; j++)
      {
      
         System.out.print(" " + rolls[i][j]);
         total = total + rolls[i][j];
         }
         
         System.out.print("\t\t"+total);
         System.out.print("\t\t"+total/rolls[i].length);
         System.out.println();
         
         } 
         endGame(); 
   }  
   
   private static void endGame()
   {
 
   int goBack;
    System.out.println("--------------------");
    System.out.println("The game is over");
    System.out.println("--------------------");
		System.out.println("Option 1: Go to menu");
		System.out.println("--------------------");
		System.out.println("Option 2: Exit");
      System.out.println("--------------------");

   
   Scanner input = new Scanner(System.in);
	      System.out.println("Option:");  
         goBack = input.nextInt(); 
         if (goBack == 1 ){
         menubeginning();
         }
         else if (goBack == 2 ) {
         System.out.print("Thank you for playing with us");
         }
         else {
         error();
         }
   
   
   }
       
   private static void error()
   {
   //in case the user ask for a quantity of players that is not defined on the beggining 
   System.out.print("Choosea a number that fit the options!");
   menubeginning();
   }
  
}