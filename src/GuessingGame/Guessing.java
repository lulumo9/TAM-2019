package GuessingGame;

import java.util.Random;
import java.util.Scanner;

public class Guessing {

    public static void main(String[] args) {

        Random random = new Random();
        int systemNumber = random.nextInt(6); //Estoy diciendo que del 0 al 50

        boolean playAgain = true;
        String inputAnswer;
        Scanner scanner = new Scanner(System.in);

        while (playAgain) {

            System.out.println("Welcome!");
            System.out.println("Try to guess the number that system has selected randomly!, Enter a number from 0 to 50: ");


            int inputNumber = scanner.nextInt();

            if (inputNumber < systemNumber) {
                System.out.println("Try again, my number is bigger!");
            } else if (inputNumber > systemNumber) {
                System.out.println("Try again my number is smaller!");
            } else {
                System.out.println("You win - Bullseye!\n\nDo you wanna play again? Type Y/N to answer: ");
                inputAnswer = scanner.next();
                if (inputAnswer.equalsIgnoreCase("N")) {
                    System.out.println("See you next time!");
                    playAgain = false;
                }
            }
        }
    }
}
