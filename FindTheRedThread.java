/**
 * CPSC 340: Software Engineering
 * Game 5: Find the Red Thread
 * 
 * @author Stephen Antogiovanni
 * @version 1.0
 * @since 11/29/2022
 */ 

import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class FindTheRedThread {

    public static void main(String args[]) throws IOException {

        System.out.println("There are 20 spools in the box. Only one is red. User 1 will pick the specified maximum number of spools (never bigger than 10).\n");
        System.out.println("Users will keep picking threads from the box until they pick this red thread. Whoever picks it, wins this game. Good luck!\n");
        
        Scanner sc = new Scanner(System.in);
        int user_input = 0;
        int min_threads = 1;
        int max_threads = 10;
        int total_threads = 20;
        boolean flag_1 = true;

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
        System.out.println("\nRed thread value: " + red_thread + "\n");



        // USER GUESSES VALUES IN RANGE

        boolean flag_2 = true;
        int[] user1_guesses = new int[user_input];

        while (flag_2){

            System.out.println("Player 1 pick threads: \n");

            for (int i=0; i<user_input; i++){

                user1_guesses[i] = sc.nextInt();

                // A02: @AS02 or @S04 User picks invalid number of threads
                // A02.1: Go back to @AS02 or @S04

                if (user1_guesses[i] < min_threads || user1_guesses[i] > total_threads){

                    System.out.println("\nPlayer 1 pick threads: \n");
                    continue;
                }

                else if (user1_guesses[i] == red_thread) {
                    
                    System.out.println("Player 1 won.");
                    flag_2 = false;
                    break;                
                }

                else flag_2 = false;
            }
        }



        // COMPUTER RANDOMLY GENERATES VALUES

        boolean flag_3 = true;
        int[] computer_guesses = new int[user_input];

        while (flag_3){

            System.out.println("Player 2 pick the threads: \n");

            for (int i=0; i<user_input; i++){

                computer_guesses[i] = rand.nextInt(total_threads) + 1;

                if (computer_guesses[i] < min_threads || computer_guesses[i] > total_threads){

                    System.out.println("\nPlayer 2 pick the threads: \n");
                    continue;
                }

                else if (computer_guesses[i] == red_thread){

                    System.out.println("Player 2 won.");
                    flag_3 = false;
                    break;
                }

                else flag_3 = false;
            } 
        }

    
       // S06: End “Find the Red Thread” game. And go back to the master branch @S04
    }
}