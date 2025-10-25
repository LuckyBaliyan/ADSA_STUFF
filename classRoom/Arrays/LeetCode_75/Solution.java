package classRoom.Arrays.LeetCode_75;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 

 */

public class Solution {
    //Better Solution Than Merge sort
    static void sortColors(int [] arr){
       int n = arr.length;
       int count0 = 0;
       int count1 = 0;
       int count2 = 0;

       for(int i = 0;i<n;i++){
        if(arr[i] == 0) count0++;
        else if(arr[i] == 1) count1++;
        else count2++;
       }

       int i = 0;

       while(count0 > 0){
        arr[i++] = 0;
        count0 --;
       }

       while(count1 > 0){
        arr[i++] = 1;
        count1 --;
       }

       while(count2 > 0){
        arr[i++] = 2;
        count2--;
       }
    }

    //using Dutch Flag Algorithm
    static void sortColorsOptimal(int [] arr){
        int n = arr.length;
        int f = 0;
        int s = 0;
        int l = n-1;

        while(s<=l){
            if(arr[s] == 2){
                int temp = arr[s];
                arr[s] = arr[l];
                arr[l] = temp;
                l--;
            }
            else if(arr[s] == 0){
                int temp = arr[s];
                arr[s] = arr[f];
                arr[f] = temp;
                f++;
                s++;
            }
            else s++;
        }
    }

    public static void main(String[] args) {
        int [] arr = {2,0,1};
        int [] arr2 = {2,0,2,0,1,1,2};

        sortColors(arr);
        sortColorsOptimal(arr2);

        for (int i : arr) {
            System.out.print(i+" ");
        }

        System.out.println();

        for (int i : arr2) {
            System.out.print(i+" ");
        }
    }
}
