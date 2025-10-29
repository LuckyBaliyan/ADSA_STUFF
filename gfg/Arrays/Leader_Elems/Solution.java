package gfg.Arrays.Leader_Elems;

/*

Given an integer array nums, return a list of all the leaders in the array.

A leader in an array is an element whose value is strictly greater than all elements to 
its right in the given array. The rightmost element is always a leader. The elements in the 
leader array must appear in the order they appear in the nums array.


Examples:
Input: nums = [1, 2, 5, 3, 1, 2]

Output: [5, 3, 2]

Explanation:

2 is the rightmost element, 3 is the largest element in the 
index range [3, 5], 5 is the largest element in the index range [2, 5]

Input: nums = [-3, 4, 5, 1, -4, -5]

Output: [5, 1, -4, -5]

Explanation:

-5 is the rightmost element, -4 is the largest 
element in the index range [4, 5], 1 is the largest element in 
the index range [3, 5] and 5 is the largest element in the range [2, 5]

*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    static ArrayList<Integer> leader_Elems(int [] nums){
       int n = nums.length;
       if(n == 0) return null;

       ArrayList<Integer> list = new ArrayList<>();

       for(int i = 0;i<n - 1;i++){
         boolean isLeader = true;
         for(int j = i+1;j<n;j++){
            if(nums[i] < nums[j]){
                isLeader = false;
                break;
            }
         }

         if(isLeader) list.add(nums[i]);
       }

       list.add(nums[n-1]);
       return list;
    } 

    //Optimal
    static ArrayList<Integer> leders_elemsOptimal(int [] nums){
        int n = nums.length;
        if(n == 0) return null;

        ArrayList<Integer> list = new ArrayList<>();
        int Leader = nums[n-1];
        list.add(Leader);

        for(int i = n-2;i>=0;i--){
            if(nums[i] > Leader){
                Leader = nums[i];
                list.add(Leader);
            }
        }

        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,5,3,1,2};
        ArrayList<Integer> list = leader_Elems(arr);
        ArrayList<Integer> list2 = leders_elemsOptimal(arr);

        System.out.println(list);
        System.out.println(list2);
    }
}
