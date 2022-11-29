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

public class FindTheRedThread {

    public static void main(String args[]) throws IOException {

        System.out.println("There are 20 spools in the box. Only one is red. User 1 will pick the specified maximum number of spools (never bigger than 10).\n");
        System.out.println("Users will keep picking threads from the box until they pick this red thread. Whoever picks it, wins this game. Good luck!\n");
        
        Scanner sc = new Scanner(System.in);
        int user_input = 0;
        int min_threads = 1;
        int max_threads = 10;
        boolean flag = true;

        while (flag){

            System.out.println("Enter the maximum number of threads that can be picked at once as a positive integer never bigger than 10: \n");
            user_input = sc.nextInt();

            if (user_input < min_threads || user_input > max_threads){
                System.out.println("\nInvalid input. Enter a positive integer less than (half the total number of threads)\n");
            }

            else flag = false;
        }

        
        
        // S02: Ask user1 picks thread/s from the box by displaying “Player 1 pick threads”
        System.out.println("Player 1 pick threads\n");


        // A02: @AS02 or @S04 User picks invalid number of threads
        // A02.1: Go back to @AS02 or @S04

        

        // S03: If it’s the red one, player 1 wins. Display “Player 1 won.”

        // S04: If not, ask player 2 to pick the threads by displaying “Player 2 pick the threads: ” S05: If it’s the red one, player 2 wins. Display “Player 2 won.”

        // S06: End “Find the Red Thread” game. And go back to the master branch @S04



    }
}