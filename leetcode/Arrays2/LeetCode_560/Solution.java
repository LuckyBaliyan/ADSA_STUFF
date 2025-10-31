package leetcode.Arrays2.LeetCode_560;

import java.util.HashMap;

/**
 * Return Number of subarrays which equals sum K all numbers can be included in array -ve and +ve
 */

public class Solution {
    static int countSubArrayBrute(int [] nums, int k){
        int n = nums.length;

        int count = 0;

        for(int i =0;i<n;i++){
            int sum  = 0;
            for(int j = i;j<n;j++){
                sum += nums[j];

                if(sum == k) count++;
            }
        }

        return count;
    }

    static int countSubArrayOptimal(int [] nums,int k){
        int n  = nums.length;

        if(n == 0) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        //Put initial prefixsum as 0 

        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for(int i =0;i<n;i++){
            prefixSum += nums[i];

            int  itna_hor_hai_kya = prefixSum -  k;
            count += map.getOrDefault(itna_hor_hai_kya,0);
            map.put(prefixSum,map.getOrDefault(prefixSum, 0)+1);
        }

        return count;
    }

    public static void main(String[] args) {
        int [] arr = {-1,1,2,3};

        System.out.println(countSubArrayBrute(arr, 3));
        System.out.println(countSubArrayOptimal(arr, 1));
    }
}
