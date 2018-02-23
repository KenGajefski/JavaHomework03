package homework03;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Main
public class SortSearchers {

    // Format specifiers
    private final static String firstColumn = "%-8s";
    private final static String secondColumn = "%10s";
    private final static String indexColumn = "%-8d";
    private final static String valueColumn = "%,10.2f";
    private final static String statsLeft = "%-30s";
    private final static String statsRight = "%10d";

    //------------------------------------------------------------------
    // randomizeArrayList
    //------------------------------------------------------------------
    private static void randomizeArrayList(ArrayList<Double> al,
                                           int newElements)
    {

        // Loop to generate and store random numbers in ArrayList
        Random rand = new Random();
        for (int i = 1; i <= newElements; i++)
            al.add(rand.nextDouble() * 1000);

    }

    //------------------------------------------------------------------
    // printArrayList
    //------------------------------------------------------------------
    private static void printArrayList(ArrayList<Double> al)
    {

        // Loop to print ArrayList
        System.out.printf(firstColumn + secondColumn + "%n", "Index", "Value");
        // Formatted to index in left column and value in right
        for (int i = 0; i < 10; i++)
            System.out.printf(indexColumn + valueColumn + "%n", i, al.get(i));

    }

    //------------------------------------------------------------------
    // Main
    //------------------------------------------------------------------
    public static void main(String[] args) {

        // Variables
        int userAmount;
        int swaps = 0;
        int cycles = 0;
        long before;
        long after;
        long sortTime;
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Double> arrList = new ArrayList<>();

        System.out.println("Welcome to Sort Searchers!");
        System.out.println("--------------------------");
        System.out.println();
        System.out.print("Enter an amount of values to be generated in the ArrayList (up to 10,000): ");
        userAmount = keyboard.nextInt();

        // Validating user input to be over 10 and under 10,000
        while (userAmount < 10 || userAmount > 10000){
            System.out.println("Invalid value.");
            System.out.print("Enter an amount of values to be generated in the ArrayList (up to 10,000): ");
            userAmount = keyboard.nextInt();
        }


        // Creating random values in ArrayList with user input amount
        randomizeArrayList(arrList, userAmount);

        System.out.println("First 10 unsorted values in array list");
        printArrayList(arrList);

        // Sorting array list and tracking time to do it in nanoseconds
        before = System.nanoTime();
        int n = arrList.size();
        for (int i = 0; i < n; i++)
        {
            double key = arrList.get(i);
            int j = i-1;

            while (j >= 0 && arrList.get(j) > key)
            {
                arrList.set(j + 1, arrList.get(j));
                j = j - 1;
                swaps++;
                cycles++;
            }

            arrList.set(j + 1, key);
            cycles++;
        }
        after = System.nanoTime();
        sortTime = (after - before);

        System.out.printf(statsLeft + statsRight + "%n", "Time to sort(in nanoseconds): ", sortTime);
        System.out.printf(statsLeft + statsRight + "%n", "Amount of cycles: ", cycles);
        System.out.printf(statsLeft + statsRight + "%n", "Amount of swaps: ", swaps);

        System.out.println("First 10 sorted values in array list");
        printArrayList(arrList);
    }
    // End of main
}
// End of class