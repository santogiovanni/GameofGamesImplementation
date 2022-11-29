/*
* PlayGames.java: The driver loop that displays the menu and controls the overall progress of the Game of Games
* CS340
*
* @author Kiet Ha
* @version 1.0.1b
* @11/28/2022
*
*/

//TO DO:
// 1. Add global score for user and computer
// 2. Add methods to call the games
// 3. Error case for invalid input (DONE)
// 4. TIE CASE

import java.util.*;
import java.io.IOException;

public class PlayGames extends GetInput {
  static String thimble = "Thimble Picking";
  static String coin = "Coin Toss";
  static String guess = "Guess the Number";
  static String eao = "Even and Odd";
  static String red = "Find the Red Thread";

  public static void main(String args[]) throws IOException {
    boolean flag = true;


    System.out.println("Welcome to Game of Games! Pick a game on the menu by inputting the number of that game. As you play, your points will be accumulated and displayed. At the end, whoever has more points, wins. You can play as many times as you want! When you are done press 'Quit Game of Games.' Enjoy! \n");
    System.out.println("Here's a list of avaliable games:\n 1. Thimble Picking \n 2. Coin Toss \n 3. Guess the Number \n 4. Even and Odd \n 5. Find the Red Thread \n");
    System.out.println("Enter the number of the game you want to play as an integer between 1-5: ");

    while (flag) {
      int num = playGamesInput();
      switch (num) {
        case 1:
          System.out.println(thimble); //Using s.o.p instead of calling the game for beta version
          break;
        case 2:
          System.out.println(coin);
          break;
        case 3:
          System.out.println(guess);
          break;
        case 4:
          System.out.println(eao);
          break;
        case 5:
          System.out.println(red);
          break;
      }
      System.out.println("Thanks for playing " + intToGame(num) + ". Do you want to play another game (Y/N - case sensitive)?: ");
      if (quittingGame().equals("N")) {
        System.out.println("Congratulations. Player/Computer won with # Points.");
        System.out.println("Thanks for participating in Game of Games. The winner is player/computer with points #. Bye!\n");
        flag = false;
      }
      else System.out.println("Enter the number of the game you want to play as an integer between 1-5: ");
    }
  }

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
    return ""; //this won't ever happen cause input is checked in GetInput()
  }
}
