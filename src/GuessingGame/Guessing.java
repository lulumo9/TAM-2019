package GuessingGame;

import java.util.Random;
import java.util.Scanner;

public class Guessing {

    public static void main(String[] args) {

        Random random = new Random();
        int systemNumber = random.nextInt(50); //Estoy diciendo que del 0 al 50

        Boolean userWon = false;
        Boolean playAgain = true;
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner2 = new Scanner(System.in);


        System.out.println("Welcome!");
        System.out.println("Try to guess the number that system has selected randomly!, Enter a number from 0 to 50: ");


        while (playAgain == true) {
            while (userWon == false) {

                int inputNumber = scanner.nextInt();

                if (inputNumber < systemNumber) {
                    System.out.println("Try again, my number is bigger!");
                } else if (inputNumber > systemNumber) {
                    System.out.println("Try again my number is smaller!");
                } else {
                    System.out.println("You win - Bullseye!");
                    System.out.println("Do you wanna play again? Type Y/N to answer: ");
//                    playAgain = scanner2.next();     //Garantizo que solo tome el primer caracter
                }
            }
        }
    }
}


