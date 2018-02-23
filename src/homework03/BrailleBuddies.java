package homework03;

import java.util.Scanner;

public class BrailleBuddies {

    // Format specifiers
    private static final String COL_LABEL = "%-13s";
    private static final String COL_HEAD = "%4s";
    private static final String COL_ROW = "%2d";

    // 3D array for braille characters
    private static final int[][][] BRAILLE_GRIDS =
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

    // --------------------------------------------------------------------------------------------------
    // fillArray
    // --------------------------------------------------------------------------------------------------
    private static void fillArray(int arr[], String input){
        // Characters in the userInput string are being put into an Integer array, converting them
        // to ASCII values to be used in 3D array
        for (int j = 0; j < input.length(); j++){
            arr[j] = input.charAt(j);
            arr[j] = arr[j] - 97;
        }
    }

    // --------------------------------------------------------------------------------------------------
    // main
    // --------------------------------------------------------------------------------------------------
    public static void main(String[] args){

        // Variables
        String userInput;
        Scanner keyboard = new Scanner(System.in);
        int size;

        System.out.println("Welcome to Braille Buddies");
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("Enter a word or sentence below to be converted to braille ('q' to exit): ");
        userInput = keyboard.nextLine();

        // Sentinel loop
        while(!userInput.equals("q")) {

            // Validation loop
            for (int i = 0; i < userInput.length(); i++) {
                // Casting letter at value of i in
                int letter = userInput.charAt(i);
                // ASCII values in params are for values of anything but space and letters both uppercase and lowercase
                while ((letter < 65 && letter != 32) || (letter > 90 && letter < 97) || (letter > 172)) {
                    System.out.println("Invalid input. Input should not contain any special characters or numbers.");
                    userInput = keyboard.nextLine();
                    letter = userInput.charAt(0);
                    i = 0;
                }
            }

            // Declaring new integer array to score ASCII values of userInput
            size = userInput.length();
            int[] arr = new int[size];

            // Filling the array with userInput
            fillArray(arr, userInput);

            // Outputting the header of each column
            System.out.printf(COL_LABEL, "Character:");
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 0)
                    System.out.printf(COL_HEAD, userInput.charAt(i)); // Outputs character if not uppercase or space
                else if (arr[i] == -65)
                    System.out.printf(COL_HEAD, " "); // Outputting space characters
                else {
                    System.out.printf(COL_HEAD, "UP"); // Since input has already been validated, this catches any uppercase
                    char temp = userInput.charAt(i);   // letters, converts them to lowercase, and then outputs them
                    temp = Character.toLowerCase(temp);
                    System.out.printf(COL_HEAD, temp);
                }
            }

            // Outputting first row of numbers for braille conversion
            System.out.println();
            System.out.printf(COL_LABEL, "Row 1:");
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 0)
                    System.out.printf(COL_ROW + COL_ROW, BRAILLE_GRIDS[arr[i]][0][0], BRAILLE_GRIDS[arr[i]][0][1]);
                else if (arr[i] == -65)
                    System.out.printf(COL_HEAD, " ");
                else {
                    // If a value is not the space value, -65, or positive, then it must be uppercase since validation
                    // has already occurred. UP is output first and followed by the uppercase value in arr[] + 32 since
                    // that will make the value equivalent to what is in our 3D array of lowercase letters for braille
                    System.out.printf(COL_ROW + COL_ROW, BRAILLE_GRIDS[26][0][0], BRAILLE_GRIDS[26][0][1]);
                    System.out.printf(COL_ROW + COL_ROW, BRAILLE_GRIDS[arr[i] + 32][0][0], BRAILLE_GRIDS[arr[i] + 32][0][1]);
                }
            }

            // Outputting second row of numbers for braille conversion
            System.out.println();
            System.out.printf(COL_LABEL, "Row 2:");
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 0)
                    System.out.printf(COL_ROW + COL_ROW, BRAILLE_GRIDS[arr[i]][1][0], BRAILLE_GRIDS[arr[i]][1][1]);
                else if (arr[i] == -65)
                    System.out.printf(COL_HEAD, " ");
                else {
                    System.out.printf(COL_ROW + COL_ROW, BRAILLE_GRIDS[26][1][0], BRAILLE_GRIDS[26][1][1]);
                    System.out.printf(COL_ROW + COL_ROW, BRAILLE_GRIDS[arr[i] + 32][1][0], BRAILLE_GRIDS[arr[i] + 32][1][1]);
                }
            }

            // Outputting third row of numbers for braille conversion
            System.out.println();
            System.out.printf(COL_LABEL, "Row 3:");
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 0)
                    System.out.printf(COL_ROW + COL_ROW, BRAILLE_GRIDS[arr[i]][2][0], BRAILLE_GRIDS[arr[i]][2][1]);
                else if (arr[i] == -65)
                    System.out.printf(COL_HEAD, " ");
                else {
                    System.out.printf(COL_ROW + COL_ROW, BRAILLE_GRIDS[26][2][0], BRAILLE_GRIDS[26][2][1]);
                    System.out.printf(COL_ROW + COL_ROW, BRAILLE_GRIDS[arr[i] + 32][2][0], BRAILLE_GRIDS[arr[i] + 32][2][1]);
                }
            }

            // Prompting for user input again
            System.out.println();
            System.out.println("Enter a word or sentence below to be converted to braille ('q' to exit): ");
            userInput = keyboard.nextLine();

        }
        // End of sentinel loop


    }
    // End of main
}
