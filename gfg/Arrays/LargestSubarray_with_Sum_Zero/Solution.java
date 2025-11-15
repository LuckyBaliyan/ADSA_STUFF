package gfg.Arrays.LargestSubarray_with_Sum_Zero;

import java.util.HashMap;

/*
 * Find the maxLength of sunArray having sum of its elements Zero
 */

public class Solution {
    static int MaxLength(int [] nums){
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        int sum = 0;int len = 0;

        for(int i = 0;i<n;i++){
            sum += nums[i];

            if(sum == 0){
                len = Math.max(len, i+1);
            }

            if(map.containsKey(sum - 0)){
                len = Math.max(len, i - map.get(sum - 0));
            }
            else{
                map.put(sum,i);
            }
        }

        return len;
    }

    public static void main(String[] args) {
        System.out.println(MaxLength(new int [] {15,-2,2,-8,1,7,10,23}));
    }
}
