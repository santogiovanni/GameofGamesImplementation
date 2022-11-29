import java.util.Scanner;   //import scanner

public class GuessTheNumber{

    public static void getInput(){
        Scanner sc = new Scanner(System.in);    //create our scanner object
        int range = 2;
        int numToGuess = 2;
        


        while(range > 1 || range != 1){
            System.out.println("Pick the max number of a range starting at 1");   //prompt the user for input
            range = sc.nextInt();   //get user input for range

            if(range <= 1){
                System.out.println("Insert Number Bigger Than 1");
            } 
        }
        
        while(numToGuess > 1){
            System.out.println("Pick a number that the other player will try to guess.");   //prompt for user input
            numToGuess = sc.nextInt();    //get user input for the number the computer will try to guess

            if(numToGuess < 1){
                System.out.println("Insert Number Within The Range");
            }
        }

        int numOfGuesses = range/2;
        
        while(numOfGuesses >= 1 && numOfGuesses <= range/2){
            System.out.println("Pick a number of attempts the other player will have to guess your number. Remember, it cannot be more than half the number of values in range.");    //prompt for user input
            numOfGuesses = sc.nextInt();    //get user input for the number of guesses the other person will have

            if(numOfGuesses < 1 || numOfGuesses > range/2){
                System.out.println("Insert a positive number that is smaller or equal to half the number of values in range");
            }
        }
        
    }


    public static void main(String[] args){
        

        System.out.println("Player 1 will pick a number secretly and store it somewhere. Player 1 will then specify the allowed number of guessing attempts. Attention, the number of guesses cannot be more than half the number of values in range. Player 2 will keep guessing the number until their attempts are over. If Player 2 guesses the number in those attempts, they win. If they don't guess the number within the allowed attempts, they lose and player 1 wins. Good luck!");

        getInput();

    }

}
