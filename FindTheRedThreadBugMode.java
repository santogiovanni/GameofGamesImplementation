/**
 * CPSC 340: Software Engineering
 * Game 5: Find the Red Thread BUG MODE
 *
 * @author Stephen Antogiovanni
 * @version 1.4
 * @since 11/29/2022
 */

import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class FindTheRedThread extends PlayGames {

    public static void main(String args[]) throws IOException {

        System.out.println("There are 20 spools in the box. Only one is red. User 1 will pick the specified maximum number of spools (never bigger than 10).\n");
        System.out.println("Users will keep picking threads from the box until they pick this red thread. Whoever picks it, wins this game. Good luck!\n");

        Scanner sc = new Scanner(System.in);
        int user_input = 0;
        int min_threads = 1;
        int max_threads = 10;
        int total_threads = 30;         // CHANGE ASSOCIATED WITH BUG 3
        boolean flag_1 = true;
        boolean outer_flag = true;

        while (flag_1){

            System.out.println("Enter the maximum number of threads that can be picked at once as a positive integer never bigger than 10: \n");
            user_input = sc.nextInt();

            if (user_input < min_threads || user_input > max_threads){
                System.out.println("\nInvalid input. Enter a positive integer less than (half the total number of threads)\n");
            }

            else flag_1 = false;
        }

        // generating one random number out of 20 spools to represent red thread
        Random rand = new Random();
        int red_thread = rand.nextInt(total_threads) + 1;


        // outer while loop to keep game in progress if red thread is not found
        while (outer_flag){

            boolean flag_2 = true;
            boolean flag_3 = true;
            int[] user1_guesses = new int[user_input];
            int[] computer_guesses = new int[user_input];

            // USER GUESSES VALUES IN RANGE
            while (flag_2){

                System.out.println("Player 1 pick threads: \n");

                for (int i=0; i<user_input; i++){

                    user1_guesses[i] = sc.nextInt();

                    // checking if guess is valid or not (below min or above max)
                    if (user1_guesses[i] < min_threads || user1_guesses[i] > total_threads){

                        // BUG 1: while loop runs past number of guesses allowed for user if invalid input is encountered
                        System.out.println("\nPlayer 1 pick threads: \n");
                        continue;

                    }

                    // if user guess is the red thread
                    else if (user1_guesses[i] == red_thread) {

                        System.out.println("\nPlayer 1 won.");
                        flag_2 = false;
                        // flag_3 = false;      // BUG 2: after player 1 guesses correctly, computer still prompted to guess number
                        outer_flag = false;
                        globalUserPts++;
                        break;
                    }

                    else flag_2 = false;
                }
            }

            // COMPUTER RANDOMLY GENERATES VALUES
            while (flag_3){

                System.out.println("\nComputer pick the threads: \n");

                for (int i=0; i<user_input; i++){

                    // BUG 3: computer randomizes guess beyond normal range, new range is now 1-30
                    computer_guesses[i] = rand.nextInt(total_threads) + 1;

                    // checking if computer guess is valid or not (below min or above max)
                    if (computer_guesses[i] < min_threads || computer_guesses[i] > total_threads){

                        System.out.println("\nComputer pick the threads: \n");
                        continue;
                    }

                    // if computer guess is the red thread
                    else if (computer_guesses[i] == red_thread){

                        System.out.println("Computer won.");
                        flag_3 = false;
                        outer_flag = false;
                        globalComputerPts++;
                        break;
                    }

                    else flag_3 = false;
                }
            }
        }
    }
}