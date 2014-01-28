/**
 * Created by hazel on 1/27/14.
 */
import java.lang.*;

public class MachineProb1 {
    public static void main(String[] args){
        int[] number = {0,2,3,4,9,22,17,8,75,64,0,22,19,7,29,67,9,21,17,22,9};
        double mean, median;
        double sum = 0;
        int tempMedian=0, tempMode=0, presentModeFreq=1, holder=0, freqCtr=1;
        int temp=0,less_length=0;
        int length = number.length;
        int[] hold = new int[length];
        int[] mode = new int[length];
        //for mean
        System.out.println("----------------------------------------MEAN----------------------------------------");
        System.out.println("Array");                        //original array
        for(int i=0;i<length;i++){
            if((i+1)==length){
                System.out.print(number[i]);
            }else{
                System.out.print(number[i] + ", ");
            }
        }
        System.out.println();
        System.out.println("Total Number of elements: " + length);
        for(int i=0; i<length; i++){
            sum = sum + number[i];                          // get sum or all the elements
        }
        mean = sum/(length);                                // sum divided by the # of elements
        System.out.println("Sum :" + sum);                  //sum of all the elements
        System.out.println("mean : " + mean);
        System.out.println("---------------------------------------MEDIAN---------------------------------------");
        System.out.println("Original Array");
        for(int i=0;i<length;i++){
            if((i+1)==length){
                System.out.print(number[i]);
            }else{
                System.out.print(number[i] + ", ");
            }
        }
        System.arraycopy(number, 0, hold,  0, length);
        int iteration = 1;
        for(int h=1; h<length; h++){
            for(int r=0; r<length; r++){
                if(hold[r]>hold[h])                         // used to sort the array to arrange in ascending order
                {
                temp=hold[r];
                hold[r] = hold[h];
                hold[h] = temp;
                }
            }
        }
        System.out.println();
        System.out.println("Present Array to be used to get the median");
        for(int i=0;i<length;i++){                          //ascending order array
            if((i+1)==length){
                System.out.print(hold[i]);
            }else{
                System.out.print(hold[i] + ", ");
            }
        }
        //for median
        tempMedian = length%2;                              //if result is 1 thus odd elements
        if(tempMedian == 1){                                // if odd # of elements
            tempMedian = (int)Math.ceil((double)length/2);
            median = hold[tempMedian - 1];
            System.out.println();
            System.out.println("median :" + median);
        }else{                                              //if even # of elements
            tempMedian = length/2;
            median = hold[tempMedian];
            median = median + hold[tempMedian - 1];
            median = median/2;
            System.out.println();
            System.out.println("Median :" + median);
        }
        System.out.println("----------------------------------------MODE----------------------------------------");
        System.out.println("Array: ascending order");
        for(int i=0;i<length;i++){
            if((i+1)==length){
                System.out.print(hold[i]);
            }else{
                System.out.print(hold[i] + ", ");
            }
        }
        int ctr=0;
        mode[0] = (-1);
        while(ctr<(length)){
           holder = ctr+1;
            while((holder < length) && (hold[ctr] == hold[holder])){    //for checking if elements are still the same
                holder++;
                freqCtr++;
                if(holder == length){
                    break;
                }
            }
           ctr = holder -1;
           if(freqCtr > presentModeFreq){                   //if current freq of elements is higher than the present Max freq
               presentModeFreq = freqCtr;
               tempMode = 0;
               freqCtr =1;
               mode[0]=hold[ctr];
               mode[1]=(-1);
           }else if((freqCtr == presentModeFreq) && (presentModeFreq != 1)){//if current freq of elements is equal to the present Max freq
               freqCtr = 0;
               tempMode++;
               mode[tempMode] = hold[ctr];
               mode[tempMode + 1] = (-1);
           }else{                                           //if current freq of elements is less than the present Max freq
               freqCtr =1;
           }
        ctr++;
        }
        System.out.println();
        System.out.print("Mode: ");                         //printing of mode of the array
        if(mode[0] != (-1)){
            for(int i = 0; i < mode.length; i++){
                if(mode[i]==(-1)){
                    break;
                }
                System.out.print(mode[i] + ",");
            }
        }else{
            System.out.print("Frequency of elements in the array are the same");
        }
        //for BUBBLESORT
        iteration=1;
        System.out.println();
        System.out.println("-------------------------------------BUBBLESORT-------------------------------------");
        System.out.println("Original Array");
        for(int i=0;i<length;i++){
            if((i+1)==length){
                System.out.print(number[i]);
            }else{
                System.out.print(number[i] + ", ");
            }
        }
        for(int h=0; h<(length-1); h++){
            for(int r=0; r<(length-h-1); r++){
                if(number[r]>number[r+1]){                                            //swap process
                    temp=number[r];
                    number[r] = number[r+1];
                    number[r+1] = temp;
                }
                System.out.println();
                System.out.println("Iteration: " + iteration);    //prints array if swap occurs
                for(int i=0;i<length;i++){
                    if((i+1)==length){
                        System.out.print(number[i]);
                    }else{
                        System.out.print(number[i] + ", ");
                    }
                }
            iteration++;
            }
        }
        System.out.println();
    }
}
