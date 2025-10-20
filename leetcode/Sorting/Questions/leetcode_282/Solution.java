package leetcode.Sorting.Questions.leetcode_282;

import java.util.HashSet;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range 
 * that is missing from the array.

Example 1:

Input: nums = [3,0,1]

Output: 2

Explanation:

n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range 
since it does not appear in nums.

Example 2:

Input: nums = [0,1]

Output: 2

Explanation:

n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range 
since it does not appear in nums.
 */

public class Solution {
    static int missingBruteForce(int [] nums){
        int n = nums.length;

        if(nums[n-1] != n)return n;

        for(int i =0;i<n;i++){
            if(nums[i] != i) return i;
        }

        return -1;
    }

    static int missingOptimised(int [] nums){
        int n = nums.length;

        HashSet<Integer> st = new HashSet<>();

        for(int a: nums){
            st.add(a);
        }

        for(int i =0;i<=n;i++){
            if(!st.contains(i)) return i;
        }

        return -1;
    }

    static int missingWithSum(int [] nums){
        int n = nums.length;

        int expectedSum = n*(n+1)/2;
        int actualSum = 0;

        for(int i: nums){
            actualSum += i;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int [] arr = {0,1};

        System.out.println(missingBruteForce(arr));
        System.out.println(missingOptimised(arr));
        System.out.println(missingWithSum(arr));
    }
}
