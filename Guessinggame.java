import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        int totalScore = 0;
        int roundCount = 0;

        while (playAgain) {
            playGame(scanner);
            roundCount++;

            System.out.print("Do you want to play again? (yes or no): ");
            String response = scanner.next();

            if (response.equalsIgnoreCase("no")) {
                playAgain = false;
            }
        }

        System.out.println("Total rounds played: " + roundCount);
        System.out.println("Total score: " + totalScore);
        scanner.close();
    }

    public static void playGame(Scanner scanner) {
        Random rand = new Random();
        int min = 1;
        int max = 100;
        int randomNumber = rand.nextInt((max - min) + 1) + min;
        int attempts = 0;
        int maxAttempts = 10;
        boolean guessedCorrectly = false;

        System.out.println("A random number between 1 and 100 has been generated.");
        
        while (attempts < maxAttempts && !guessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number.");
                guessedCorrectly = true;
            } else if (userGuess > randomNumber) {
                System.out.println("Your guess is too high.");
            } else {
                System.out.println("Your guess is too low.");
            }
        }

        if (!guessedCorrectly) {
            System.out.println("You've used all attempts. The correct number was " + randomNumber + ".");
        }

        System.out.println("Number of attempts: " + attempts);
        System.out.println();
    }
}
