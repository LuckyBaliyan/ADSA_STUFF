package leetcode.HashingBasic.HashOrFrequencyArray;

import java.util.Arrays;

public class Countelems {
    public static void main(String[] args) {
        int [] arr = {1,2,1,3,4,2};
        int n = arr.length;

        //Creating Frequency array with a large size for just safety
        int [] freq = new int[13];
        Arrays.fill(freq, 0);

        //Filling the elements count wise 
        for(int i = 0;i<n;i++){
            freq[arr[i]]++;
        }

        for (int i : freq) {
            System.out.print(i+" ");
        }

        System.out.println();

        System.out.println(freq[1]+": is the Frequency of 1");
    }
}
