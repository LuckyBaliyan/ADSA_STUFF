package leetcode.Arrays2.LeetCode_15;
/**
 * 
3 SUM

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Solution {

    //Brute Force cehck for every possible triplets
    static ArrayList<ArrayList<Integer>> threeSum(int [] nums){
        int n = nums.length;
        HashSet<ArrayList<Integer>> temp = new HashSet<>();

        for(int i =0;i<n;i++){
            for(int j = i+1;j<n;j++){
                for(int k = j+1;k<n;k++){
                    if((nums[i]+nums[j]+nums[k]) == 0){
                      ArrayList<Integer> triplets = new ArrayList<>();
                      triplets.add(nums[i]);
                      triplets.add(nums[j]);
                      triplets.add(nums[k]);

                      Collections.sort(triplets);
                      temp.add(triplets);
                    }
                }
            }
        }

        return new ArrayList<>(temp);
    }

    //Better Solution reducing teh kth loop using hashing
    static ArrayList<ArrayList<Integer>> threeSumBetter(int [] nums){
        int n = nums.length;
        HashSet<ArrayList<Integer>> resSet = new HashSet<>();

        for(int i = 0;i<n;i++){
            HashSet<Integer> temp = new HashSet<>();
            for(int j =  i+1;j<n;j++){
               int third = -(nums[i]+nums[j]);

               if(temp.contains(third)){
                ArrayList<Integer> triplets = new ArrayList<>();
                triplets.add(nums[i]);
                triplets.add(nums[j]);
                triplets.add(third);

                Collections.sort(triplets);
                resSet.add(triplets);
               }

               temp.add(nums[j]);
            }
        }

        return new ArrayList<>(resSet);
    }

    //Optimal Solution (2-pointers)
    static ArrayList<ArrayList<Integer>> threeSumOptimal(int [] nums){
        int n = nums.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0;i<n;i++){
            int j = i+1;
            int k = n-1;

            if(i>0 && nums[i] == nums[i-1]) continue;

            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum < 0){
                    j++;
                }
                else if(sum > 0){
                    k--;
                }
                else{
                    ArrayList<Integer> triplets = new ArrayList<>();
                    triplets.add(nums[i]);
                    triplets.add(nums[j]);
                    triplets.add(nums[k]);
                    res.add(triplets);
                    j++;
                    k--;

                    while(j<k && nums[j] == nums[j-1]) j++;
                    while(j<k && nums[k] == nums[k+1]) k--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int [] arr = {-1,0,1,2,-1,-4};
        ArrayList<ArrayList<Integer>> res = threeSum(arr);
        System.out.println(res);

        ArrayList<ArrayList<Integer>> res2 = threeSumBetter(arr);
        System.out.println(res2);

        ArrayList<ArrayList<Integer>> res3 = threeSum(arr);
        System.out.println(res3);
    }
    
}
