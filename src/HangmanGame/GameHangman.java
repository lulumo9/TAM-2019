package HangmanGame;

import java.util.*;

public class GameHangman {

    public static boolean checkingIfWordCompleted(char[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] == '_') {
                return false;
            }
        }
        return true;
    }

    public static void fillingArray(char[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = '_';
        }
        System.out.println(inputs);
    }

    public static boolean fillingEntered(char[] selected, char input, char[] inputs) {
        for (int i = 0; i < selected.length; i++) {
            if (selected[i] == input) {
                inputs[i] = input;
                return true;
            }
        }
        return false;
    }


        public static void main(String[] args) {

        boolean wordGuessed = false;
        List<String> animals = Arrays.asList("elephant", "kangaroo", "octopus", "dolphin", "chimpanzee");
        Random ran = new Random();
        int randomIndex = ran.nextInt(animals.size());
        String randomString = animals.get(randomIndex);
        char[] selectedWord = randomString.toCharArray();
        char[] enteredChars = new char[selectedWord.length];
        int lives = 6;

        System.out.println("Welcome! Try to guess the animal that system has selected randomly.");
        Scanner scanner = new Scanner(System.in);
        fillingArray(enteredChars);

        while (!wordGuessed && lives != 0) {

            char userInput = scanner.next().charAt(0);

            if (fillingEntered(selectedWord, userInput, enteredChars)) {
                System.out.println("Right! The character you have entered is on the word");
            } else {
                lives --;
                System.out.println("Incorrect! The character you have entered is not in the word.\nYou have " + lives + " lives available");
            }

            if (checkingIfWordCompleted(enteredChars)) {
                wordGuessed = true;
                System.out.println("Congrats! You have guessed the word :)");
            }
            System.out.println(enteredChars);

            if (lives == 0)
            {
                System.out.println("GAME OVER! You have used all the lives :(\nThe hidden word was: " + randomString);
            }
        }
    }
}












