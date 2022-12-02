/**
 * CPSC 340
 * GuessTheNumberBugMode: Includes several bugs that the user can do with GuessTheNumber game
 *
 * @author Kiet Ha
 * @version 1.0
 * @11/30/2022
 */


import java.util.Scanner;   //import scanner
import java.util.Random;    //import random

public class GuessTheNumberBugMode extends PlayGames {

    public static void getInput() {
        Scanner sc = new Scanner(System.in);    //create our scanner object
        //int variables in the program
        int range = 0;
        int numToGuess = 0;
        int numOfGuesses = 0;
        int limit;

        //flags to monitor user input
        boolean rFlag = true;
        boolean tFlag = true;
        boolean oFlag = true;


           // BUG 1: If there is no check for the number being greater than 1
            System.out.println("\nPick the max number of a range starting at 1");
            range = sc.nextInt();   //get user input for range


        while(tFlag){
            System.out.println("Pick a number that the other player will try to guess.");   //prompt for user input
            numToGuess = sc.nextInt();    //get user input for the number the computer will try to guess

            if(numToGuess < 1){     //make sure the user entered a valid input
                System.out.println("Insert Number Within The Range");
            } else{
                tFlag = false;      //if the user gave valid input, set our flag to false so we fall out of the loop
            }
        }

        limit = range / 2;      //make a limit to make sure the number of guesses input is valid

        //BUG 2: Player 2 can guess how many times they want to
        System.out.println("Pick a number of attempts the other player will have to guess your number. Remember, it cannot be more than half the number of values in range.");    //prompt for user input
        numOfGuesses = sc.nextInt();    //get user input for the number of guesses the other person will have


        //this portion of the program will perform the guessing game where the computer "player 2" will atempt to guess the number player 1 chose
        Random rand = new Random();
        int randNum = rand.nextInt(range);
        boolean gFlag = true;
        System.out.println("The range is 1 to "+ range +". You have got "+ numOfGuesses +" attempts. Insert a guess within the range.");
        System.out.println("\nThe number to guess is " + numToGuess);

        while(gFlag){
            //BUG 3: PLAYER 2 can guess the same number twice
            System.out.println("\nPlayer 2 guessed " + randNum);
            if(randNum == numToGuess){
                System.out.println("Player 2 wins!");
                globalComputerPts++;
                gFlag = false;
            } else if(numOfGuesses != 0){
                System.out.println("Wrong guess! You still have attempts left. Guess again!");
                randNum = rand.nextInt(range);
            }

            numOfGuesses--;

            if(numOfGuesses == 0){
                System.out.println("\nThe correct guess is "+ numToGuess +". Player 1 Wins");
                globalUserPts++;
                gFlag = false;
            }
        }

    }



    public static void main(String[] args) {

        System.out.println("\nPlayer 1 will pick a number secretly and store it somewhere. Player 1 will then specify the allowed number of guessing attempts. Attention, the number of guesses cannot be more than half the number of values in range. Player 2 will keep guessing the number until their attempts are over. If Player 2 guesses the number in those attempts, they win. If they don't guess the number within the allowed attempts, they lose and player 1 wins. Good luck!");

        getInput();     //call the getInput function to get all of the input from our user

    }

}
