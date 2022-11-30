/*
* PlayGames.java: The driver loop that displays the menu and controls the overall progress of the Game of Games
* CS340
*
* @author Kiet Ha
* @version 1.0.4b
* @11/28/2022
*
*/

//TO DO:
// 1. Add global score for user and computer (DONE)
// 2. Add methods to call the games (1 game left)
// 3. Error case for invalid input (DONE)
// 4. TIE CASE (DONE)


import java.util.*;
import java.io.IOException;

public class PlayGames extends GetInput {
  /* Instance variables */
  static String thimble = "Thimble Picking";
  static String coin = "Coin Toss";
  static String guess = "Guess the Number";
  static String eao = "Even and Odd";
  static String red = "Find the Red Thread";
  static int globalUserPts = 0;
  static int globalComputerPts = 0;

  /* Driver method */
  public static void main(String args[]) throws IOException {
    boolean flag = true;


    System.out.println("Welcome to Game of Games! Pick a game on the menu by inputting the number of that game. As you play, your points will be accumulated and displayed. At the end, whoever has more points, wins. You can play as many times as you want! When you are done press 'Quit Game of Games.' Enjoy! \n");
    System.out.println("Here's a list of avaliable games:\n 1. Thimble Picking \n 2. Coin Toss \n 3. Guess the Number \n 4. Even and Odd \n 5. Find the Red Thread \n");
    System.out.println("Enter the number of the game you want to play as an integer between 1-5: ");

    /* This while loop is used to call the games and continue 
    calling games if the user wants to continue playing */
    while (flag) {
      int num = playGamesInput();
      switch (num) {
        case 1:
          ThimblePicking.main(null); //calling the main method in each class with null as argument
          break;
        case 2:
          CoinFlip.main(null);
          break;
        case 3:
          GuessTheNumber.main(null);
          break;
        case 4:
          EvenOdd.main(null);
          break;
        case 5:
          System.out.println(red);
          break;
      }
      System.out.println("\n\nThanks for playing " + intToGame(num) + ". Do you want to play another game (Y/N - case sensitive)?: ");

      if (quittingGame().equals("N")) {
        if (globalUserPts > globalComputerPts) System.out.println("\nCongratulations. User 1 won with " + globalUserPts + " Points.");
        else if (globalComputerPts > globalUserPts) System.out.println("\nCongratulations. Computer won with " + globalComputerPts + " Points.");
        else System.out.println("Thanks for participating in the Games of Games. The players are tied with " + globalUserPts + " points each. Bye!");

        if (globalUserPts > globalComputerPts)
          System.out.println("Thanks for participating in Game of Games. The winner is player with points "+ globalUserPts + "... Bye!\n");
        else if (globalComputerPts > globalUserPts)
          System.out.println("Thanks for participating in Game of Games. The winner is computer with points "+ globalComputerPts + "... Bye!\n");

        flag = false; //exiting loop when they choose N (stop playing the game)
      }
      else System.out.println("Enter the number of the game you want to play as an integer between 1-5: "); //otherwise we reprompt them
    }
  }

 //This method is used to convert whatever game they chose in an integer to a title of the game in a string (could also be done with ENUM)
  public static String intToGame(int num) {
    switch (num) {
      case 1:
        return thimble;
      case 2:
        return coin;
      case 3:
        return guess;
      case 4:
        return eao;
      case 5:
        return red;
    }
    return null; //this WON'T ever happen cause input is checked in GetInput()
  }
}
