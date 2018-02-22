package homework03;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Main
public class SortSearchers {

    // Constant Variables
    private final static String firstColumn = "%-8s";
    private final static String secondColumn = "%-6s";
    private final static String indexColumn = "%-8d";
    private final static String valueColumn = "%-6d";



    //------------------------------------------------------------------
    // randomizeArrayList
    //------------------------------------------------------------------
    private static void randomizeArrayList(ArrayList<Integer> al,
                                           int newElements, int upperLimit)
    {

        // Loop to generate and store random numbers in ArrayList
        Random rand = new Random();
        for (int i = 1; i <= newElements; i++)
            al.add(rand.nextInt(upperLimit) + 1);

    }

    //------------------------------------------------------------------
    // printArrayList
    //------------------------------------------------------------------
    private static void printArrayList(ArrayList<Integer> al)
    {

        // Loop to print ArrayList
        System.out.printf(firstColumn + secondColumn + "%n", "Index", "Value");
        // Formatted to index in left column and value in right
        for (int i = 0; i < 10; i++)
            System.out.printf(indexColumn + valueColumn + "%n", i, al.get(i));

    }

    //------------------------------------------------------------------
    // insertionSort
    //------------------------------------------------------------------
    private static void insertionSort(ArrayList<Integer> al)
    {
        int n = al.size();
        for (int i = 0; i < n; i++)
        {
            int key = al.get(i);
            int j = i-1;

            while (j >= 0 && al.get(j) > key)
            {
                al.set(j + 1, al.get(j));
                j = j - 1;
            }
            al.set(j + 1, key);
        }
    }
    

    public static void main(String[] args) {

        // Variables
        int userUpperLimit;

        Scanner keyboard = new Scanner(System.in);

        ArrayList<Integer> arrList = new ArrayList<>();

        System.out.println("Welcome to Sort Searchers!");
        System.out.println("--------------------------");
        System.out.println();
        System.out.print("Enter an amount of values to be generated in the ArrayList (up to 10,000): ");
        userUpperLimit = keyboard.nextInt();

        // Validating user input to be over 10 and under 10,000
        while (userUpperLimit < 10 || userUpperLimit > 10000){
            System.out.println("Invalid value.");
            System.out.print("Enter an amount of values to be generated in the ArrayList (up to 10,000): ");
            userUpperLimit = keyboard.nextInt();
        }

        // Creating random values in ArrayList with user input amount
        randomizeArrayList(arrList, userUpperLimit, 1000);

        System.out.println("First 10 unsorted values in array list");
        printArrayList(arrList);

        insertionSort(arrList);
        System.out.println("First 10 sorted values in array list");
        printArrayList(arrList);
    }
}
// End of main