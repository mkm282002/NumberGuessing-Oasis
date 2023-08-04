import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {
        int lowRange = 1;
        int highRange = 100;
        int TotalLife = 5;
        int score = 0;
        boolean reAttempt = true;

        System.out.println("Welcome to Guess the Number.....");

        while (reAttempt) {
            int RemainingLife = TotalLife;
            int generatedNum = RandomNumber(lowRange, highRange);
            System.out.println("Guess a Number between " + lowRange + " and " + highRange + ".");
            System.out.println("You have " + TotalLife + " attempts!");

            int attempts = 0;
            boolean CorrectNum = false;
            Scanner sc = new Scanner(System.in);

            while (attempts < TotalLife) {
                System.out.print("Enter your guess: ");
                int guessNumber = sc.nextInt();
                attempts++;

                if (guessNumber == generatedNum) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += (TotalLife - attempts + 1);
                    CorrectNum = true;
                    break;
                } else if (guessNumber < generatedNum) {
                    System.out.println("Much Lower Value ! Please Try again.\n");
                } else {
                    System.out.println("Much Higher Value ! Please Try again.\n");
                }
                System.out.println("You have " + (--RemainingLife) + " attempts left!");
            }

            if (!CorrectNum) {
                System.out.println("Oops! You couldn't guess the number. The correct number was: " + generatedNum);
            }

            System.out.println("Your score is : " + score);
            System.out.print("Do you want to play again with me.....!!! (yes/no): ");
            String reAttemptResponse = sc.next().toLowerCase();
            reAttempt = reAttemptResponse.equals("yes");
        }
        
        System.out.println("Thank you for playing.. && Your Thoughtfulness is a gift....!!");
    }

    private static int RandomNumber(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }
}