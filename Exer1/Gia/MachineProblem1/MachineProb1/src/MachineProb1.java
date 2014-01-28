/**
 * Created by gianadine on 1/27/14.
 */
import java.util.Random;

public class MachineProb1 {
    public static void main(String[] args){
        final int ARRAY_SIZE = 25;
        Random rand = new Random();
        int[] numbers = new int[ARRAY_SIZE];
        int[] mode;

        //Initialize array
        for(int i = 0; i < ARRAY_SIZE; i++){
            numbers[i] = rand.nextInt(99) + 1;
        }

        //Print randomly generated values
        System.out.print("Numbers: ");
        printArray(numbers);

        //Sort array
        numbers = bubbleSort(numbers);

        //Print sorted array
        System.out.print("Final Array: ");
        printArray(numbers);

        //Get mean value
        System.out.println("Mean: " + getMean(numbers));

        //Get median value
        System.out.println("Median: " + getMedian(numbers));

        //Get mode value/s
        mode = getMode(numbers);

        //Print mode value/s
        System.out.print("Mode: ");
        if(mode[0] != 0){
            for(int i = 0; i < mode.length; i++){
                if(mode[i]==0)
                    break;
                System.out.print(mode[i]);
                if((i==(mode.length - 1)) || (mode[i+1]==0))
                    System.out.println(" ");
                else
                    System.out.print(", ");
            }
        }
        else
            System.out.println("No mode");
    }

    public static float getMean(int[] nums){
        float mean = 0;
        for(int i = 0; i < nums.length; i++){
            mean = mean + (float)nums[i];                       //get sum of all values
        }
        mean = mean/nums.length;                                //divide sum by length of array
        return mean;
    }

    public static int[] getMode(int[] nums){                    //accept sorted array as input
        int[] modes = new int[nums.length-1];
        int modeCtr = 0, maxFreq = 1, freq = 1, j;
        for(int i = 0; i < (nums.length - 1); i++){
            j = i + 1;                                          //set j to index of next value
            while((nums[i]==nums[j]) && (j < nums.length)){
                freq++;                                         //increment frequency
                j++;                                            //until next value is not equal to current value
                if(j==nums.length)
                    break;
            }
            i = j - 1;                                          //set i to index of last identical value
            if(freq > maxFreq){                                 //if current frequency is greater than
                modes[0] = nums[i];                             //the maximum frequency,
                modes[1] = 0;                                   //store current frequency
                maxFreq = freq;                                 //to maximum frequency
                modeCtr = 0;
                freq = 1;
            }
            else if((maxFreq != 1) && (freq==maxFreq)){         //else if current frequency(unless its value is 1)
                modeCtr++;                                      //is equal to maximum frequency
                modes[modeCtr] = nums[i];                       //store current frequency
                modes[modeCtr+1] = 0;                           //to the next array slot
                freq = 1;
            }                                                   //else do nothing
            else
                freq = 1;
        }
        return modes;
    }

    public static float getMedian(int[] nums){                  //accept sorted array as input
        float median;
        int mid;
        if((nums.length%2)==0){                                 //if length is even,
            mid = (nums.length/2);                              //get average of the two middlemost values
            median = nums[mid-1] + nums[mid];
            median = median/2;
        }
        else{                                                   //if length is odd,
            mid = (int)(nums.length/2);                         //get middle value
            median = nums[mid];
        }
        return median;
    }

    public static int[] bubbleSort(int[] nums){
        for(int i = 0; i < (nums.length - 1); i++){
            for(int j = 0; j < (nums.length - i - 1); j++){
                if(nums[j] > nums[j+1]){                        //if adjacent values are equal
                    nums = swap(nums, j, (j+1));                //swap them
                    System.out.print("Swap: ");                 //print resulting array after swap
                    printArray(nums);
                }
            }
        }
        return nums;
    }

    public static int[] swap(int[] nums, int i, int j){
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
        return nums;
    }

    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            if(i != (array.length - 1))
                System.out.print(", ");
            else
                System.out.println(" ");
        }
    }

}