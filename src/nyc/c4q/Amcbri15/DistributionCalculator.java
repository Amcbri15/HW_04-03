package nyc.c4q.Amcbri15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Anthony McBride
 * Distribution Calculator
 * AccessCode 2.1
 */

public class DistributionCalculator
{

    public static void main(String[] args) throws FileNotFoundException
    {
        File text = new File(
                "/Users/c4q-anthony-mcbride/Desktop/accesscode/HW_04-03/src/nyc/c4q/Amcbri15/DCTest.txt");
        ArrayList<Double> letterPercent = calculate(text);

        int asciiValue = 97;
        for(Double dist : letterPercent)
        {
            /* This print statement prints the exact double value with all decimal places included
             System.out.println((char) asciiValue + " = " + dist + "%");
            */

            System.out.print((char) asciiValue);
            //Adding the print this way reduces the decimal places shown after the decimal to two
            System.out.printf(" = %.2f", dist);
            System.out.print("%\n");
            asciiValue++;
        }

    }

    public static ArrayList<Double> calculate(File DCTest) throws FileNotFoundException
    {

        ArrayList<Double> letterCount = new ArrayList<Double>();

        // Adds each letter in the file to the array indexes 0-25 (26 lower case letters of the alphabet)
        while(letterCount.size() < 26)
        {
            letterCount.add(0.0);
        }
        Scanner file = new Scanner(DCTest);

        while(file.hasNext())
        {
            String line = file.next().toLowerCase();
            for(int i = 0; i < line.length(); i++)
            {
                char letter = line.charAt(i);
                if(letter >= 97 && letter <= 122)
                {
                    if(letterCount.get(letter - 97) == 0)
                    {
                        letterCount.set(letter - 97, 1.0);
                    }
                    else
                    {
                        letterCount.set(letter - 97, letterCount.get(letter - 97) + 1.0);
                    }

                }

            }

        }

        ArrayList<Double> percentDistribution = new ArrayList<Double>();

        double chars = 0.0;

        // Adds all letters in the file to a total for unique letter percentage calculation
        for(double letters : letterCount)
        {
            chars += letters;
        }

        // Adds each unique letter's percentage to the percentDistribution array
        for(double letterTotal : letterCount)
        {
            percentDistribution.add((letterTotal / chars) * 100);
        }

        return percentDistribution;

    }


}
