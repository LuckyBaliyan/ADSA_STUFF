package classRoom.Arrays.leetcode_283;

/**
 * 
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order
 *  of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 
 */

public class Solution {
    static void placeZeros(int [] nums){
        int n = nums.length;

        if(n<=1) return;

        int i = 0;
        int j = 1;

        while(j<n){
            if(nums[i] == 0 && nums[j] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
                j++;
            }
            else if(nums[i] == 0 && nums[j] == 0){
                j++;
            }
            else{
                i++;
                j++;
            }
        }
    }

    static void placethemSmartly(int [] arr){
        int n = arr.length;

        if(n<=1) return;

        //Overwritting all the non-zero values first
 
        int i = 0;
        for(int a:  arr){
            if(a != 0){
                arr[i++] = a;
            }
        }

        //Now until i < n that means we have some space left to fill with zeros

        while(i<n){
            arr[i++] = 0;
        }
    }

    public static void main(String[] args) {
        int [] arr = {0,1,0,3,0,0,3,0,0,2};
        placeZeros(arr);

        for(int i : arr){
            System.out.print(i+" ");
        }

        int [] arr2 = {1,2,3,0,0,0,0,0,0,0,1};
        placethemSmartly(arr2);

        System.out.println();

        for(int e:arr2){
            System.out.print(e+" ");
        }
    }
    
}
