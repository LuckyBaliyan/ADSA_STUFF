package classRoom.Arrays.LongestSubArray_with_Sum_K;

import java.util.HashMap;

public class Solution {
    static int longestSubarray(int [] nums,int k){
        int n = nums.length;

        if(n == 0) return 0;

        int maxLen = 0;

        for(int i = 0;i<n;i++){
            int sum = 0;
            int count  = 0;

            for(int j = i;j<n;j++){
                sum += nums[j];
                count++;

                if(sum == k){
                    maxLen = Math.max(maxLen,count);
                }
            }
        }

        return maxLen;
    }

    //Better
    static int longestSubarrayBetter(int [] nums,long k){
        int n = nums.length;
        if(n == 0) return 0;

        HashMap<Long,Integer> map = new HashMap<>();
        long sum = 0;
        int maxLen = 0;

        for(int i = 0;i<n;i++){
            sum += nums[i];

            if(sum == k){
              maxLen = Math.max(maxLen, i+1);
            }


            if(map.containsKey(sum - k)){
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }

            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }

        return maxLen;
    }

    //optimal

    static int longestSubarrayOptimal(int [] nums,int k){
        int  n = nums.length;

        if(n == 0) return 0;

        int maxLen = 0;
        int sum = nums[0];
        int i  = 0;
        int j = 0;

        while(j< n){
           while( i <= j && sum > k){
            sum -= nums[i];
              i++;
           }

           if(sum == k){
            maxLen = Math.max(maxLen,j - i +1);
           }

            j++;

           if(j<n){
            sum += nums[j];
           }
        }

        return maxLen;

    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,1,1,1,4,2,3};
        int [] arr2 = {10,5,2,7,1,9};

        System.out.println(longestSubarray(arr, 3));

        //This might result in N^2 if collisions are accuring
        System.out.println(longestSubarrayBetter(arr2, 15));

        //Optimal

        System.out.println(longestSubarrayOptimal(arr2,15));
    }
}
