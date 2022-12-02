/*
*
* @author Michael Monti
* @version 1.0.1b
* @12/2/2022
*
*/

import java.util.Scanner;
import java.util.Random;

public class EvenOdd extends PlayGames {

    //Method hold the game for Even & Odd
    public static void game(){
        //integer values hold the total points for user & computer
        int userPts = 0;
        int cpuPts = 0;

        //scanner is created to read input values
        Scanner obj = new Scanner(System.in);
        int numRounds = GetInput.PosAndOddInput();
        
        //target integer created, if user score exceeds this value, they win
        int target = numRounds/2;

        //int choice is created to determine if they are even or odd
        //user is prompted to choose if even or odd
        int choice;
        System.out.println("Enter 1 to be 'even' or 0 to be 'odd'\n");
        choice = obj.nextInt();

        //while loop occurs if entered value is not 1 or 0
        while(choice != 1 && choice != 0){
            System.out.println("Insert either 1 or 0\n");
            choice = obj.nextInt();
        }

        //for loop occurs for the number of rounds in the game
        for(int i = 1; i<=numRounds; i++){
            //round number is displayed
            System.out.println("Round "+i+"\n");

            //random number is genterated for computer for value 1-5
            Random rand = new Random(); //instance of random class
            int upperbound = 6;
            int lowerbound = 1;
            int cpuNum = rand.nextInt(lowerbound,upperbound);
            
            //user is prompted to pick a number 1-5
            int userNum;
            System.out.println("Insert a number from 1 to 5\n");
            userNum = obj.nextInt();

            //if value is not integer 1-5, user is prompted to pick again
            while(userNum < 1 || userNum > 5){
                System.out.println("Invalid Number. Insert number from 1 to 5\n");
                userNum = obj.nextInt();
            }


            //chosen integer for user and computer is printed
            System.out.println("Player 1 picked "+userNum+"\n");
            System.out.println("Computer picked "+cpuNum+"\n");

            //total is created based on two values
            int total = userNum + cpuNum;
            //if else case is created based on if total is even or odd
            if(total%2 == 0){
                //total is printed
                System.out.println("Sum is "+total+". It is a even number\n");
                //based user choice if else determines if user wins the round
                if(choice == 1){
                    //user wins and gets a point
                    System.out.println("Player 1 Wins!\n");
                    userPts++;
                }
                else{
                    //user loses, computer gets a point
                    System.out.println("Player 1 Loses!\n");
                    cpuPts++;
                }
            }
            else{
                //total is printed
                System.out.println("Sum is "+total+". It is a odd number\n");
                //based user choice if else determines if user wins the round
                if(choice == 0){
                    //user wins and gets a point
                    System.out.println("Player 1 Wins!\n");
                    userPts++;
                }
                else{
                    //user loses, computer gets a point
                    System.out.println("Player 1 Loses!\n");
                    cpuPts++;
                }
            }

            //total points for user and computer are displayed
            System.out.println("Player 1 has "+userPts+" points\n");
            System.out.println("Computer has "+cpuPts+" points\n");

            //if statements check if the user or computer has exceeded the target score
            //if true user/computer wins and loop is exited
            if(userPts>target){
                System.out.println("You Win Even and Odd Game\n");
                globalUserPts++;
                break;
            }
            if(cpuPts>target){
                System.out.println("You Lose Even and Odd Game\n");
                globalComputerPts++;
                break;
            }

        }

    }


    public static void main(String args[]) {
        //directions are printed in main on how to play the game
        System.out.println("\nPlayers decide a number of rounds to play to the best of. In the first round, User 1 will decide if he is ‘even’ or ‘odd’, and the other user will be assigned the unpicked option. The users will remain with their original choice for the whole game. Then, both users pick a number between 1 and 5 inclusive. If the sum is even, the player who is ‘even’ gains a point; if it’s odd, the ‘odd’ player gains a point. Whoever reaches the target number of points first is the winner!\n");
        //game is called
        game();
    }
}
