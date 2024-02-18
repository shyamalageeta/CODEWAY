import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attempts = 5; // Number of attempts allowed
        int score = 0; // Initialize score
        
        System.out.println("Welcome to the Guess the Number game!");
        System.out.println("Guess a number between " + minRange + " and " + maxRange + ".");
        
        boolean playAgain = true;
        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attemptCount = 0;
            boolean guessedCorrectly = false;
            
            while (attemptCount < attempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                
                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    guessedCorrectly = true;
                    score++; // Increase score for each correct guess
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
                
                attemptCount++;
                System.out.println("Attempts left: " + (attempts - attemptCount));
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + randomNumber);
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next();
            playAgain = playAgainResponse.equalsIgnoreCase("yes");
        }
        
        System.out.println("Game over! Your final score is: " + score);
        scanner.close();
    }
}
