package classRoom.Arrays.LeetCode_169;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:
 */

public class Solution {
    static int majoritElementBrute(int [] nums){
        int n = nums.length;

        if(n == 1) return nums[0];

        for(int i = 0;i<n;i++){
            int count = 0;
            for(int j =0;j<n;j++){
                if(nums[i] == nums[j]) count++;
            }

            if(count > n/2) return nums[i];
        }

        return -1;
    }

    //Better Approach

    static int majoritElementBetter(int [] nums){
        int n = nums.length;

        if(n== 1) return nums[0];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num, 0)+1);
        }

        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(e.getValue() > n/2) return e.getKey();
        }

        return -1;
    }

    //Majority voting Algo

    static int majoritElementOptimal(int [] nums){
        int n = nums.length;
        if(n == 1) return nums[0];

        int candidate  = -1;
        int count = 0;

        for(int num : nums){
            if(count == 0){
                candidate = num;
            }

            count += (num == candidate)?1:-1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        int [] arr = {2,2,1,1,1,2,2};
        System.out.println(majoritElementBrute(arr));

        System.out.println(majoritElementBetter(arr));

        System.out.println(majoritElementOptimal(arr));
    }
}
