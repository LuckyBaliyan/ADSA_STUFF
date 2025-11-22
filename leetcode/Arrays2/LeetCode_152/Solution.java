package leetcode.Arrays2.LeetCode_152;

/**
 * 152. Maximum Product Subarray
Solved
Medium
Topics
premium lock icon
Companies
Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Note that the product of an array with a single element is the value of that element.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
 

 */

public class Solution {
    static int MaxProductSubaray(int [] nums){
        int n = nums.length;

        if(n == 1)return nums[0];
        int maxPro = nums[0];

        for(int i = 0;i<n;i++){
            int pro = nums[i];
            for(int j = i+1;j<n;j++){
               pro *= nums[j];
               maxPro = Math.max(maxPro, pro);
            }
            maxPro = Math.max(maxPro, nums[i]);  // for cases like [0,2] needs to give 2 as o/p 
        }

        return maxPro;
    }

    static int MaxProductSubarayOptimal(int [] nums){
        int n = nums.length;

        if(n == 1)return nums[0];

        int max= Integer.MIN_VALUE;
        int pref = 1;
        int suff = 1;

        for(int i =0;i<n;i++){
            if(pref == 0) pref = 1;
            if(suff == 0) suff = 1;

            pref *= nums[i];
            suff *= nums[n-i-1];

            max = Math.max(max, Math.max(pref, suff));
        }

        return max;
    }

    public static void main(String[] args) {
        int [] arr = {-10,-5,0,2,3,-2,4};
        System.out.println(MaxProductSubaray(arr));

        System.out.println(MaxProductSubarayOptimal(arr));

    }
}
