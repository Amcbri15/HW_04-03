package nyc.c4q.Amcbri15;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Anthony McBride
 * AccessCode 2.1
 * Linear Search HW (Due 4/3)
 */
public class LinearSearch
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> intArray = getIntArray();
        int x;
        int indexOfX;

        System.out.println(intArray);


        System.out.println(
                "Please enter an integer between 0 and 99 to find it's index in the above array: ");
        x = scanner.nextInt();
        indexOfX = search(intArray, x);

        if(indexOfX != - 1)
        {
            System.out.println(x + " is at index " + indexOfX + ".");
        }
        else
        {
            System.out.println(search(intArray, x) + "(Your input is not in the above array!)");
        }


    }

    public static ArrayList<Integer> getIntArray()
    {
        ArrayList<Integer> array = new ArrayList<Integer>();
        Random rand = new Random();
        // Randomly generate the array size
        int arraySize = rand.nextInt(20);

        // Iterate over the randomly generated arraySize and place a randomly generated number between 0 and 99 at each index
        for(int i = 0; i < arraySize; i++)
        {
            array.add(rand.nextInt(99));
        }
        return array;

    }

    public static int search(ArrayList<Integer> alist, int x)
    {
        if(alist.contains(x))
        {
            return alist.indexOf(x);
        }
        else
        {
            return - 1;
        }
    }


}