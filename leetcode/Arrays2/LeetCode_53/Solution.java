package leetcode.Arrays2.LeetCode_53;

/**
 * 
 * 
53. Maximum Subarray
Solved
Medium
Topics
premium lock icon
Companies
Given an integer array nums, find the subarray with the largest sum, and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 */

public class Solution {

    static int maxSumBrute(int [] nums){
        int n = nums.length;

        if(n == 1) return nums[0];

        int maxSum = Integer.MIN_VALUE;

        for(int i = 0;i<n;i++){
            int sum = 0;
            for(int j= i;j<n;j++){
               sum += nums[j];

               if(sum > maxSum){
                maxSum = sum;
               }
            }
        }

        return maxSum;
    }

    //Kadne's Algorithm 

    static int maxSumOPtimal(int [] nums){
        int n = nums.length;

        if(n == 1) return nums[0];

        int currSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1;i<n;i++){
            currSum = Math.max(nums[i],currSum + nums[i]);
            maxSum = Math.max(maxSum,currSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int [] arr = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSumBrute(arr));

        System.out.println(maxSumOPtimal(arr));
    }
    
}
