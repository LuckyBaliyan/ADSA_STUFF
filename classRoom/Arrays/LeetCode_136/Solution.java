package classRoom.Arrays.LeetCode_136;

/**
 * 136. Single Number
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

Example 1:

Input: nums = [2,2,1]

Output: 1

Example 2:

Input: nums = [4,1,2,1,2]

Output: 4

Example 3:

Input: nums = [1]

Output: 1
 */

import java.util.HashMap;
import java.util.Map;

public class Solution {
    static int singleNumberBruteForce(int [] nums){
        int n = nums.length;

        if(n == 1) return nums[0];

        for(int i = 0;i<n;i++){
            boolean flag = false;
            for(int j= 0;j<n;j++){
                if( i == j) continue;
                if(nums[i] == nums[j]){
                    flag = true;
                    break;
                }
            }

            if(!flag) return nums[i];
        }

        return -1;
    }

    static int singleNumberOptimal(int [] nums){
        int n = nums.length;

        if(n == 1) return nums[0];

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(e.getValue() == 1){
                return e.getKey();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int [] arr = {2,2,1};

        System.out.println(singleNumberBruteForce(arr));
        System.out.println(singleNumberOptimal(arr));
    }
}
