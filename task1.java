import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attempts = 5; // Number of attempts allowed
        int score = 0; // Initialize score
        
        System.out.println("Welcome to the Guess the Number game!");
        System.out.println("Guess a number between " + minRange + " and " + maxRange + ".");
        
        boolean playAgain = true;//new game
        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attemptCount = 0;
            boolean guessedCorrectly = false;
            
            while (attemptCount < attempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                
                if (guess == randomNumber) {
                    System.out.println("Bravo! You guessed the number correctly.");//congratulate if guessed correctly
                    guessedCorrectly = true;
                    score++; // Increase score for each correct guess
                    break;//out of the loop
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");//acknowledge user that the guess was low
                } else {
                    System.out.println("Too high! Try again.");//acknowledge user that the guess was high
                }
                //increase the count of used attempts after each guess
                attemptCount++;
                System.out.println("Attempts left: " + (attempts - attemptCount));//acknowledge user with the attempts left
            }
            //if all attempts are used and the user couldn't guess then end game
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + randomNumber);
            }
            //Ask if the user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = sc.next();
            playAgain = playAgainResponse.equalsIgnoreCase("yes");
        }
        //After the user is done playing, print the final score
        System.out.println("Game over! Your final score is: " + score);
        scanner.close();
    }
}
