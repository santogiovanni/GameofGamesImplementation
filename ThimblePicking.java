/**
 * CPSC 340: Software Engineering
 * Game 1: Thimble Picking
 * 
 * @author Stephen Antogiovanni
 * @version 1.0
 * @since 11/28/2022
 */ 

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class ThimblePicking {

    public static void main(String args[]) throws IOException {

        System.out.println("User1 will pick a hand to hide a thimble and the computer will have to guess what hand it is in.\n");
        System.out.println("If guess is correct, computer receives a point, otherwise User1 receives a point.\n");
        System.out.println("Follow the instructions that will be displayed as you play.\n");
        System.out.println("If playing against the computer, the choice numbers will be generated automatically. Good Luck!\n");

        Scanner sc = new Scanner(System.in);
       
        int min_num_rounds = 1;
        int number_rounds = 0;
        int user_points = 0;
        int computer_points = 0;
        boolean flag_1 = true;

        while (flag_1) {

            System.out.println("How many rounds do you want to play ? You will play to the best of that number of rounds. Number of rounds must be odd.\n");
            number_rounds = sc.nextInt();

            // checking for negative number or even input
            if (number_rounds < min_num_rounds || number_rounds % 2 == 0){
                System.out.println("\nInsert Positive and Odd Integer\n");
            }
            else flag_1 = false;
        }
       
        for (int i=1; i<=number_rounds; i++){

            int hand_choice = 0;
            int randomNum = 0;
            int max_num = 2;
            boolean flag_2 = true;
            boolean flag_3 = true;

            System.out.println("\nRound " + i + "\n"); 
            
            while (flag_2){

                System.out.println("Pick a hand. Insert 1 for left hand and 0 for right hand\n");
                hand_choice = sc.nextInt();

                if (hand_choice == 0){
                    System.out.println("\nYou chose the right hand\n");
                    break;
                }

                else if (hand_choice == 1) {
                    System.out.println("\nYou chose the left hand\n");
                    break;
                }

                // checking if user input is not 1 or 0
                else if (hand_choice != 1 || hand_choice != 0){
                    System.out.println("\nInsert Valid Number (0 or 1)\n");
                }

                else flag_2 = false; 
            }
            
            while (flag_3){

                System.out.println("Guess what hand the thimble is in. Insert 1 for left hand and 0 for right hand.\n");
                Random rand = new Random();
                randomNum = rand.nextInt(max_num);

                if (randomNum == 0){
                    System.out.println("You chose the right hand\n");
                    break;
                }

                else if (randomNum == 1) {
                    System.out.println("You chose the left hand\n");
                    break;
                }

                // checking if random computer choice is not 0 or 1
                else if (randomNum != 0 || randomNum != 1){
                    System.out.println("\nInsert Valid Number (0 or 1)\n");
                }

                else flag_3 = false;
                sc.close();
            }
            
            
            // await response from client for clarification on display messages
            if (randomNum == hand_choice){
                System.out.println("User1 loses\n");
                computer_points++;
            }

            else if (randomNum != hand_choice){
                System.out.println("User1 wins a point\n");
                user_points++;
            }

            System.out.println("User has " + user_points + " points and Computer has " + computer_points + " points\n");
                
            int majority_points = (int)(Math.ceil((double)number_rounds / 2));

            if (user_points >= majority_points){
                System.out.println("You Win Thimble Picking Game\n");
            }

            else if (computer_points >= majority_points){
                System.out.println("You Lose Thimble Picking Game\n");
            }
        }
    }
}