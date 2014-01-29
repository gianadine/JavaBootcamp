/*------------------------------------------------------------------
Project:	Machine Problem 1
Version:	1.1
Created: 		28/01/2014
Last change:	28/01/2014
-------------------------------------------------------------------*/

import java.util.Random;

public class Java_Project
{
    public static void main(String[] args)
    {
        int[] items=new int[20];                                                                                        //generation of random and unordered values for array
        Random var= new Random();

        double mean;                                                                                                       //Declarations for Mean//
        int sumOfItems = 0;

        double median;                                                                                                  //Declaration for median//
        int middleOfItems = 0;

        int maxValue=0;                                                                                                 //Declarations for Mode//
        int maxCount=0;
        int maxCount1=0;
        int testCounter=0;

        int count;                                                                                                      //Declarations for main counters
        int temp;                                                                                                       //Declarations for Bubble Sort //

        for(int randCount=0;randCount<items.length;randCount++)                                                         //Random Array Initialization//
        {
            items[randCount]=var.nextInt(99)+1;
        }

        System.out.println("Java machine problem: MEAN, MEDIAN, And MODE: \n");                                       //Display of title//

        System.out.print("\tInitial values of unordered array: \t\t");                                                  //Display of given Array//
        for(int unorderedListCount = 0;unorderedListCount<items.length;unorderedListCount++)
        {
            System.out.print(items[unorderedListCount]);
            if(unorderedListCount<=18)
            {
                System.out.print(", ");
            }
        }
        System.out.print("\n\n");

        for (int countOne=1; countOne<items.length; countOne++)                                                         // Start of Bubble Sort: Sorting out the array from smallest to largest //
        {
            for(int countTwo=0; countTwo<items.length-countOne; countTwo++)
            {
                newCnt++;

                if (items[countTwo] > items [countTwo+1])
                {
                    temp = items [countTwo];
                    items [countTwo] = items [countTwo+1];
                    items [countTwo+1] = temp;
                }
            }
        }
        System.out.print("\tThe bubble sorted numbers are: \t\t\t");

        for (int i=0; i < items.length; i++)
        {
            System.out.print(items[i]);
            if(i<=18)
            {
                System.out.print(", ");
            }
        }
        System.out.print("\n\n");                                                                                       //End of Bubble Sort //
                                                                                                                        //Codes for Mean, Median and Mode//
                                                                                                                        // Start of Mean //
                for (count = 0; count<items.length; count++)
                {
                    sumOfItems+= items[count];
                }

                mean = (double)(sumOfItems/items.length);
                System.out.println("Mean = " + mean);                                                                   //End of Mean//

                middleOfItems = items.length/2;                                                                         //Start of Median//

                if(middleOfItems%2 == 0)
                {
                    double x= items[middleOfItems] + items[middleOfItems - 1];
                    median =  (x/2);
                }
                else
                {
                    median = (items[middleOfItems]);
                }

                System.out.println("Median = " + median);
            //End of Median//

                System.out.println("Single Mode: \n--------------------------------------------");                      //Start of Mode//
                                                                                                                        //NOTE: This code will not display multiple modes. It is written only for single Mode//

                for (int x = 0; x < items.length; ++x)
                {
                    int counter = 0;

                    for (int y = 0; y < items.length; ++y)
                    {
                        if (items[x] == items[y])
                        {
                            ++counter;
                        }
                    }

                    if (counter > maxCount)
                    {
                        maxCount = counter;
                        maxValue = items[x];
                    }
                }
            if(maxCount!=1)
            {
                System.out.println("\t>>Mode (single)= " + maxValue+"\n");
            }
            else
            {
                System.out.println("\t\tError! No Modes for this array. . .\n");
            }

            System.out.println("Multiple Mode: \n" +"--------------------------------------------\t");                  //NOTE:This code is for multiple modes//


        int[] array1=new int[20];
                int[] array2=new int[20];
                int finalModeCounter=-1;

                        for (int testCountOne = 0; testCountOne < items.length; testCountOne++)
                        {
                            int counter = 0;
                            for (int testCountTwo = 0; testCountTwo < items.length; testCountTwo++)
                            {
                                if (items[testCountTwo] ==items[testCountOne])
                                    counter++;
                            }

                            if (counter > maxCount1)
                            {
                                maxCount1 = counter;
                            }
                        }

                        for (int testCountOne = 0; testCountOne < items.length; testCountOne++)
                        {
                            int counter = 0;
                            for (int testCountTwo = 0; testCountTwo < items.length; testCountTwo++)
                            {
                                if (items[testCountTwo] == items[testCountOne])
                                counter++;
                            }

                            if (counter == maxCount1)
                            {
                                finalModeCounter++;
                                array1[finalModeCounter]=items[testCountOne];
                            }
                        }

                System.out.println("\t>>[Highest Values in the Array]: \t");
                if(finalModeCounter==19)
                {
                    System.out.println("\t\tError! No Modes for this array. . .");
                }
                else
                {
                    System.out.print("\t");
                    for(int test=0;test<=finalModeCounter;test++)
                    {
                        System.out.print("\t[" + (test+1)+"]\t" + array1[test] + "  ");
                    }

                    for(int checkMode=0;checkMode<=finalModeCounter;checkMode++)
                    {
                            if(array1[checkMode]==array1[checkMode+1])
                            {
                                array2[testCounter]=array1[checkMode];
                                testCounter++;
                            }
                    }

                    System.out.println("\n\t>>Mode(Multiple): \t");
                    for(int test=0;test<testCounter;test++)
                    {
                        if(array2[test]!=0)
                        {
                            System.out.print("\t\t" + array2[test] + "  ");
                        }
                    }
                }                                                                                                       //End of Mode//
    }
}
