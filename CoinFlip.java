import java.util.Scanner;
import java.util.Random;

public class CoinFlip extends PlayGames {

    //Method called in main is used to run entire game
    public static void flip(){
        //variables are created to keep track of total points for user and computer
        int userPts = 0;
        int compPts = 0;

        //scanner object is created to get input from the user
        Scanner obj = new Scanner(System.in);
        int numRounds;

        //user is asked how many rounds they want to play and their input is saved
        System.out.println("How many rounds do you want to play ? You will play to the best of that number of rounds. Number of rounds must be odd.\n");
        numRounds = obj.nextInt();

        //while loop occurs if specifications for the number of rounds is not met
        while(numRounds < 1 || (numRounds%2) == 0){
            System.out.println("Insert Positive and Odd Integer\n");

            numRounds = obj.nextInt();
        }

        //target of wins created for number of
        //if win total exceeds this number, player or computer wins
        int target = numRounds/2;

        //for loop based on the number of total rounds chosen
        for(int i = 1; i<=numRounds; i++){
            //round number is displayed
            System.out.println("Round: " + i + "\n");

            //user is prompted to pick 1 for heads or 0 for tails
            //input is read and saved in int choice
            int choice;
            Scanner obj2 = new Scanner(System.in);
            System.out.println("User1, insert 1 if you choose heads or 0 if tails");
            choice = obj2.nextInt();

            //while loop occurs if choice is not either 0 or 1
            while(choice != 1 && choice != 0){
                System.out.println("Insert Valid Number\n");
                choice = obj2.nextInt();
            }

            //if statement based on users choice
            //their decision is then printed
            if(choice == 0){
                System.out.println("You Choose Tails\n");
            }
            else{
                System.out.println("You Choose Heads\n");
            }

            //random number is generated based on coin flip, number is either 0 or 1
            Random rand = new Random(); //instance of random class
            int upperbound = 2;
            int randNum = rand.nextInt(upperbound);

            //if random number is 0 tails is correct answer, if number is 1 heads is correct answer
            //if statement checks which random number is chosen
            if(randNum == 0){
                //results is printed
                System.out.println("The Result of the Flip is Tails\n");
                //if statement checks user input, user gets a point if they match, computer gets a point if they do not
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
                //results is printed
                System.out.println("The Result of the Flip is Heads\n");
                //if statement checks user input, user gets a point if they match, computer gets a point if they do not
                if(choice == 1){
                    System.out.println("User1 wins a point\n");
                    userPts++;
                }
                else{
                    System.out.println("Computer Wins\n");
                    compPts++;
                }
            }

            //At the end of the round total points for each are printed
            System.out.println("Player One has "+userPts+" points\n");
            System.out.println("Computer has "+compPts+" points\n");

            //if statements check if a player exceeded the target score
            //if one of these conditions is true, winner is printed, then the for loop breaks ending the game
            if(userPts>target){
                System.out.println("You Win Coin Toss Game\n");
                globalUserPts++;
                break;
            }
            if(compPts>target){
                System.out.println("You Lose Coin Toss Game\n");
                globalComputerPts++;
                break;
            }

        }

    }

    //main used to call the game in flip()
    public static void main(String args[]) {
        //print statement used to explain the rules of the game
        System.out.println("\nUser1 will choose with heads and tails. The computer will generate a random choice. If User1’s choice is correct, User1 receives a point, otherwise User2 receives a point. Follow the instructions that will be displayed as you play. Good Luck!. If playing against computer, use 'computer' instead of 'User2'\n");
        flip();

    }
}
