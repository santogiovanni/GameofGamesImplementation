import java.util.Scanner;
import java.util.Random;

public class CoinFlip {


    public static void flip(){
        int userPts = 0;
        int compPts = 0;

        Scanner obj = new Scanner(System.in);
        int numRounds;

        System.out.println("How many rounds do you want to play ? You will play to the best of that number of rounds. Number of rounds must be odd.\n");

        numRounds = obj.nextInt();

        while(numRounds < 1 || (numRounds%2) == 0){
            System.out.println("Insert Positive and Odd Integer\n");

            numRounds = obj.nextInt();
        }
        int target = numRounds/2;

        for(int i = 1; i<=numRounds; i++){
            System.out.println("Round: " + i + "\n");
            int choice;

            Scanner obj2 = new Scanner(System.in);
            System.out.println("User1, insert 1 if you choose heads or 0 if tails");
            choice = obj2.nextInt();
    
            while(choice != 1 && choice != 0){
                System.out.println("Insert Valid Number\n");
                choice = obj2.nextInt();
            }

            if(choice == 0){
                System.out.println("You Choose Tails\n");
            }
            else{
                System.out.println("You Choose Heads\n");
            }

            Random rand = new Random(); //instance of random class
            int upperbound = 2;
            int randNum = rand.nextInt(upperbound); 

            if(randNum == 0){
                System.out.println("The Result of the Flip is Tails\n");
                if(choice == 0){
                    System.out.println("User1 wins a point\n");
                    userPts++;
                }
                else{
                    System.out.println("Computer Wins\n");
                    compPts++;
                }
            }
            else if(randNum == 1){
                System.out.println("The Result of the Flip is Heads\n");
                if(choice == 1){
                    System.out.println("User1 wins a point\n");
                    userPts++;
                }
                else{
                    System.out.println("Computer Wins\n");
                    compPts++;
                }
            }


            System.out.println("Player One has "+userPts+" points\n");
            System.out.println("Computer has "+compPts+" points\n");

            if(userPts>target){
                System.out.println("You Win Coin Toss Game\n");
                break;
            }
            if(compPts>target){
                System.out.println("You Lose Coin Toss Game\n");
                break;
            }

        }

    }


    public static void main(String args[]) {
        System.out.println("User1 will choose with heads and tails. The computer will generate a random choice. If User1’s choice is correct, User1 receives a point, otherwise User2 receives a point. Follow the instructions that will be displayed as you play. Good Luck!. If playing against computer, use 'computer' instead of 'User2'\n");
        flip();
        
    }
}