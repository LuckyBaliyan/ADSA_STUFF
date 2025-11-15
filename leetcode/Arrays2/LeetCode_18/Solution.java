package leetcode.Arrays2.LeetCode_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * 
 * 4_SUM
 */

public class Solution {

    //Brute Force 
    static ArrayList<ArrayList<Integer>> fourSum(int [] nums,int target){
        int n = nums.length;
        HashSet<ArrayList<Integer>> resSet = new HashSet<>();

        for(int i = 0;i<n;i++){
          for(int j = i+1;j<n;j++){
            for(int k = j+1;k<n;k++){
                for(int l = k+1;l<n;l++){
                    long sum = (long) nums[i]+nums[j]+nums[k];
                    sum += (long) nums[l];

                    if(sum == target){
                      ArrayList<Integer> list = new ArrayList<>();
                      list.add(nums[i]);
                      list.add(nums[j]);
                      list.add(nums[k]);
                      list.add(nums[l]);

                      Collections.sort(list);
                      resSet.add(list);
                    }
                }
            }
          }
        }

        return new ArrayList<>(resSet);
    }

    //Better using the hashing and n^3 nums[l] = target - (nums[i]+nums[j]+nums[k])

    static ArrayList<ArrayList<Integer>> fourSumBetter(int [] nums,int target){
        int n = nums.length;

        HashSet<ArrayList<Integer>> resSet =  new HashSet<>();

        for(int i = 0;i<n;i++){
            for(int j =i+1;j<n;j++){
                HashSet<Long> temp = new HashSet<>();
                for(int k= j+1;k<n;k++){
                  long sum = (long) nums[i]+nums[j]+nums[k];
                  long fourth = (long) target - sum;

                  if(temp.contains(fourth)){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    list.add((int) fourth);

                    Collections.sort(list);
                    resSet.add(list);
                  }

                  temp.add((long) nums[k]);
                }
            }
        }

        return new ArrayList<>(resSet);

    }

    //Optimal solution inplace 

    static ArrayList<ArrayList<Integer>> fourSumOptimal(int [] nums,int target){
        int n = nums.length;

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0;i<n;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1;j<n;j++){
              if(j>i+1 && nums[j] == nums[j-1]) continue;

              int k = j+1;
              int l = n-1;

              while(k<l){
                long sum = (long) nums[i]+nums[j]+nums[k]+nums[l];

                if(sum > target){
                    l--;
                }
                else if (sum < target){
                    k++;
                }
                else{
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    list.add(nums[l]);

                    res.add(list);
                    k++;
                    l--;

                    while(k<l && nums[k] == nums[k-1]) k++;
                    while(k<l && nums[l] == nums[l+1]) l--;
                }
              }
            }
        }

        return res;
        
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int [] {1,0,-1,0,-2,2}, 0));
        System.out.println(fourSumBetter(new int [] {1,0,-1,0,-2,2}, 0));
        System.out.println(fourSumOptimal(new int [] {1,0,-1,0,-2,2},  0));
    }
}
