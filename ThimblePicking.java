/**
 * CPSC 340: Software Engineering
 * Thimble Picking
 * 
 * @author Stephen Antogiovanni
 * @version 1.0
 * @since 11/28/2022
 */ 

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

// S11: If the hands picked match, Player 1 gets a point. Display “User1 wins a point”; otherwise, Player 2 gets a point. Display “User2 wins a point”. If playing against computer, display “User1 loses”


public class ThimblePicking {

    public static void main(String args[]) throws IOException {

        System.out.println("User1 will pick a hand to hide a thimble and the computer will have to guess what hand it is in.\n");
        System.out.println("If guess is correct, computer receives a point, otherwise User1 receives a point.\n");
        System.out.println("Follow the instructions that will be displayed as you play.\n");
        System.out.println("If playing against the computer, the choice numbers will be generated automatically. Good Luck!\n");

        Scanner sc = new Scanner(System.in);
       
        int min_num_rounds = 1;
        int number_rounds = 0;

        boolean flag_1 = true;

        while (flag_1) {

            System.out.println("How many rounds do you want to play ? You will play to the best of that number of rounds. Number of rounds must be odd.\n");
            number_rounds = sc.nextInt();

            if (number_rounds < min_num_rounds || number_rounds % 2 == 0){
                System.out.println("\nInsert Positive and Odd Integer\n");
            }
            else flag_1 = false;
        }
       

        int user_points = 0;
        int computer_points = 0;

        //System.out.println("number of rounds: " + number_rounds);

        for (int i=1; i<=number_rounds; i++){

            System.out.println("\nRound " + i + "\n"); 

            System.out.println("Pick a hand. Insert 1 for left hand and 0 for right hand\n");

            int hand_choice = sc.nextInt();

            sc.close();

            if (hand_choice == 0){

                System.out.println("You chose the right hand\n");
            }

            else if (hand_choice == 1) {

                System.out.println("You chose the left hand\n");
            }


            System.out.println("Guess what hand the thimble is in. Insert 1 for left hand and 0 for right hand.\n");

            Random rand = new Random();
            int max_num = 2;
            int randomNum = rand.nextInt(max_num);


            if (randomNum == 0){

                System.out.println("You chose the right hand\n");
            }

            else if (randomNum == 1) {

                System.out.println("You chose the left hand\n");
            }



            if (randomNum == hand_choice){

                System.out.println("User1 loses\n");
                computer_points++;

            }

            else if (randomNum != hand_choice){

                System.out.println("User1 wins a point\n");
                user_points++;

            }

            System.out.println("User has " + user_points + "points and Computer has " + computer_points + "points\n");
           

        
            int majority_points = (int)(Math.ceil(number_rounds / 2));

            if (user_points == majority_points){

                System.out.println("You Win Thimble Picking Game\n");

            }

            else if (computer_points == majority_points){

                System.out.println("You Lose Thimble Picking Game\n");

            }

        }

        


        


        // A02 @S06 User1 inserts a number other than 1 or 0 when choosing left or right.
        // A02.1: Display “Insert Valid Number (0 or 1):”. Go back to S06.


        // A03: @S09 User2 inserts a number other than 1 or 0 when choosing left or right.
        // A03.1: Display “Insert Valid Number (0 or 1): ”. Go back to S09.

    

    }


}