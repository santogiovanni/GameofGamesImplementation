/**
 * CPSC 340: Software Engineering
 * Game 1: Thimble Picking BUG MODE
 *
 * @author Stephen Antogiovanni
 * @version 1.0
 * @since 11/28/2022
 */

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class ThimblePicking extends PlayGames {

    public static void main(String args[]) throws IOException {

        System.out.println("\nUser1 will pick a hand to hide a thimble and the computer will have to guess what hand it is in.\n");
        System.out.println("If guess is correct, computer receives a point, otherwise User1 receives a point.\n");
        System.out.println("Follow the instructions that will be displayed as you play.\n");
        System.out.println("If playing against the computer, the choice numbers will be generated automatically. Good Luck!\n");

        Scanner sc = new Scanner(System.in);

        int min_num_rounds = 1;
        int user_points = 0;
        int computer_points = 0;

        int number_rounds = GetInput.PosAndOddInput(); //getting input

        for (int i=1; i<=number_rounds; i++){

            int hand_choice = 0;
            int randomNum = 0;
            int max_num = 5;            // CHANGE IS ASSOCIATED WITH BUG 3
            boolean flag_2 = true;
            boolean flag_3 = true;

            System.out.println("\nRound " + i + "\n");

            // prompts user to hind the thimble in either left or right hand
            while (flag_2){

                System.out.println("Pick a hand. Insert 1 for left hand and 0 for right hand\n");
                hand_choice = sc.nextInt();

                // BUG 1: INPUT 0 NOW MEANS LEFT HAND (INSTEAD OF PREVIOUS RIGHT)
                if (hand_choice == 0){
                    System.out.println("\nYou chose the left hand\n");
                    break;
                }

                // BUG 2: INPUT 1 NOW MEANS RIGHT HAND (INSTEAD OF PREVIOUS LEFT)
                else if (hand_choice == 1) {
                    System.out.println("\nYou chose the right hand\n");
                    break;
                }

                // checking if user input is not 1 or 0
                else if (hand_choice != 1 || hand_choice != 0){
                    System.out.println("\nInsert Valid Number (0 or 1)\n");
                }

                else flag_2 = false;
            }

            // prompts computer to randomly guess what hand thimble is in
            while (flag_3){

                System.out.println("Guess what hand the thimble is in. Insert 1 for left hand and 0 for right hand.\n");
                Random rand = new Random();

                // BUG 3: RANDOM INTEGER IS NOW IN RANGE OF 0-4, NOT IN PREVIOUS RANGE OF 0-1
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


            // check if random guess matches the hand
            if (randomNum == hand_choice){
                System.out.println("Computer wins a point.\n");
                computer_points++;
            }

            else if (randomNum != hand_choice){
                System.out.println("User1 wins a point\n");
                user_points++;
            }

            System.out.println("Player 1 has " + user_points + " points and Computer has " + computer_points + " points\n");

            int majority_points = (int)(Math.ceil((double)number_rounds / 2));

            // check if majority points have been reached by either user or computer
            if (user_points >= majority_points){
                System.out.println("You Win Thimble Picking Game\n");
                globalUserPts++;
                break;
            }

            else if (computer_points >= majority_points){
                System.out.println("You Lose Thimble Picking Game\n");
                globalComputerPts++;
                break;
            }

          
            // S14: End “Thimble Picking” game. And go back to the master branch @S04
        }
    }
}
