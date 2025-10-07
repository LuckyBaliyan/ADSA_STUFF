package collectionFrameworks.Lists.ArrayList.Practice;

import java.util.ArrayList;
import java.util.Arrays;

/*2. Find Maximum and Minimum

Problem: Given an ArrayList<Integer>, find:

Maximum value

Minimum value*/

public class MaxMin {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10,99,3,0,11,-1,22));
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for (Integer integer : list) {
           maxVal = integer > maxVal?integer:maxVal;
           minVal = integer < minVal?integer:minVal;
        }

        System.out.println("min Value: "+minVal+" MaxValue: "+maxVal);
    }
}
