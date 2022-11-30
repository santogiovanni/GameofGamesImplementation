/*
* GetInput.java: Bunch of methods to gets input from the user, insuring that the input is valid (correct type and in the value range specified)
* CS340
*
* @author Kiet Ha
* @version 1.0.1b
* @11/28/2022
*
*/

import java.util.Scanner;

public class GetInput {

  public static int playGamesInput() {
   Scanner s = new Scanner(System.in);
   while (true) {
     try {
       int num = Integer.parseInt(s.nextLine()); //checking if user inputs string instead if so it prompts in the catch phase
       if (num <= 0 || num > 5) System.out.println("Insert valid integer number between 1 and 5 inclusive: "); //checking if int is 1,2,3,4 or 5
       else return num;
   } catch (Exception e) {
     System.out.println("Insert valid integer number between 1 and 5 inclusive: ");
   }
 }
}

  public static String quittingGame() {
   Scanner s = new Scanner(System.in);
   String quit = s.nextLine();
   while (true) {
     if (quit.equals("Y") || quit.equals("N")) {
       return quit;
     }
     else { //if it isn't Y or N
       System.out.println("Please enter “Y” or “N” (case sensitive): ");
       quit = s.nextLine();
     }
   }
 }

 public static int PosAndOddInput() {
   Scanner s = new Scanner(System.in);
   System.out.println("How many rounds do you want to play ? You will play to the best of that number of rounds. Number of rounds must be odd.\n");
   int numRounds = s.nextInt();
   //while loop occurs if specifications for round are not met
   while(numRounds < 1 || (numRounds%2) == 0){
       System.out.println("Insert Positive and Odd Integer\n");
       numRounds = s.nextInt();
   }
   return numRounds;
 }

}
