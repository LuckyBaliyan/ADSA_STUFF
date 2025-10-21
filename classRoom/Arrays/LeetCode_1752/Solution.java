package classRoom.Arrays.LeetCode_1752;
/**
 * Given an array nums, return true if the array was originally sorted in non-decreasing order, 
 * then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that 
B[i] == A[(i+x) % A.length] for every valid index i.

Example 1:

Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 2 positions to begin on the element of value 3: [3,4,5,1,2].

Example 2:

Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make nums.

Example 3:

Input: nums = [1,2,3]
Output: true
Explanation: [1,2,3] is the original sorted array.
You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
 
 */

public class Solution {
    static boolean isSortedAndRotated(int [] nums){
        int n = nums.length;
        if(n<=1) return true;

        int i;
        for(i = 0;i<n-1;i++){
          if(nums[i] > nums[i+1]) break;
          else if (i == n-2) return true;
        }

        int x = (n-1) - i;
        int [] arr = new int[n];

        int j = 0;
        int t = i;

        while(j<x){
          arr[j] = nums[t+j+1];
          j++;
        }

        int k = 0;
        while(j<n){
            arr[j] = nums[k];
            j++;
            k++;
        }

        for(int l = 0;l<n-1;l++){
            if(arr[l] > arr[l+1]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int [] arr = {3,4,5,1,2};
        int [] arr2 = {8,7,8,9,1,2};
        int [] arr3 = {1,2,3,4,5,6};
        System.out.println(isSortedAndRotated(arr));
        System.out.println(isSortedAndRotated(arr2));
        System.out.println(isSortedAndRotated(arr3));
    }
}
