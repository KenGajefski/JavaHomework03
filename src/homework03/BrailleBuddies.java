package homework03;

import java.util.Scanner;

public class BrailleBuddies {

    // 3D array for braille characters
    final int[][][] BRAILLE_GRIDS =
            {
                    {{ 1, 0}, { 0, 0}, { 0, 0}},  // 'a' - 0
                    {{ 1, 0}, { 1, 0}, { 0, 0}},  // 'b' - 1
                    {{ 1, 1}, { 0, 0}, { 0, 0}},  // 'c' - 2
                    {{ 1, 1}, { 0, 1}, { 0, 0}},  // 'd' - 3
                    {{ 1, 0}, { 0, 1}, { 0, 0}},  // 'e' - 4
                    {{ 1, 1}, { 1, 0}, { 0, 0}},  // 'f' - 5
                    {{ 1, 1}, { 1, 1}, { 0, 0}},  // 'g' - 6
                    {{ 1, 0}, { 1, 1}, { 0, 0}},  // 'h' - 7
                    {{ 0, 1}, { 1, 0}, { 0, 0}},  // 'i' - 8
                    {{ 0, 1}, { 1, 1}, { 0, 0}},  // 'j' - 9
                    {{ 1, 0}, { 0, 0}, { 1, 0}},  // 'k' - 10
                    {{ 1, 0}, { 1, 0}, { 1, 0}},  // 'l' - 11
                    {{ 1, 1}, { 0, 0}, { 1, 0}},  // 'm' - 12
                    {{ 1, 1}, { 0, 1}, { 1, 0}},  // 'n' - 13
                    {{ 1, 0}, { 0, 1}, { 1, 0}},  // 'o' - 14
                    {{ 1, 1}, { 1, 0}, { 1, 0}},  // 'p' - 15
                    {{ 1, 1}, { 1, 1}, { 1, 0}},  // 'q' - 16
                    {{ 1, 0}, { 1, 1}, { 1, 0}},  // 'r' - 17
                    {{ 0, 1}, { 1, 0}, { 1, 0}},  // 's' - 18
                    {{ 0, 1}, { 1, 1}, { 1, 0}},  // 't' - 19
                    {{ 1, 0}, { 0, 0}, { 1, 1}},  // 'u' - 20
                    {{ 1, 0}, { 1, 0}, { 1, 1}},  // 'v' - 21
                    {{ 0, 1}, { 1, 1}, { 0, 1}},  // 'w' - 22
                    {{ 1, 1}, { 0, 0}, { 1, 1}},  // 'x' - 23
                    {{ 1, 1}, { 0, 1}, { 1, 1}},  // 'y' - 24
                    {{ 1, 0}, { 0, 1}, { 1, 1}},  // 'z' - 25
                    {{ 0, 0}, { 0, 0}, { 0, 1}}   // upper case follows - 26
            };


    public static void main(String[] args){

        final String regexExp = "[\\d|\"|,|\\.|\']+";

        // Variables
        String userInput;
        Scanner keyboard = new Scanner(System.in);



        System.out.println("Welcome to Braille Buddies");
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("Enter a word or sentence below to be converted to braille: ");
        userInput = keyboard.nextLine();

        for (int i = 0; i < userInput.length(); i++) {
            char letter = userInput.charAt(i);
            while (letter.matches(regexExp)) {
                System.out.println("Invalid input. Input should not contain any special characters or numbers.");
                userInput = keyboard.nextLine();
            }
        }

        System.out.println(userInput);


    }
}
