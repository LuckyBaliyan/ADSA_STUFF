package leetcode.Arrays2.LeetCode_128;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    //Brute Approach
    static int longestConsicutiveLength(int [] nums){
        int n = nums.length;

        if(n == 0) return 0;

        int maxLen = 1;

        for(int i = 0;i<n;i++){
            int count = 1;
            int x = nums[i];
            while(ls(nums,x+1) == true){
                x = x+1;
                count++;
                maxLen = Math.max(maxLen,count);
            }
        }

        return maxLen;

    }

    //Helper funtion of linearSearch for the Brute force method
    static boolean ls(int [] nums,int x){
        int n = nums.length;

        for(int i = 0;i<n;i++){
            if(nums[i] == x ) return true;
        }

        return false;
    }

    //Better Approch using sorting

    static int longestConsicutiveLengthBetter(int [] nums){
        int n = nums.length;

        if(n == 0) return 0;

        Arrays.sort(nums);

        int count  = 1;
        int maxLen = 1;

        for(int i = 0;i<n-1;i++){
            if(nums[i] == nums[i+1]) continue;

            if(nums[i+1] - nums[i] == 1) {
                count++;
                maxLen = Math.max(maxLen, count);
            }
            else{
                count = 1;
            }
        }

        return maxLen;
    }

    //Optimal using HashSet if collison not accurs better than Better one else wrost than better one

    static int longestConsicutiveLengthOptimal(int [] nums){
        int n = nums.length;
        if(n == 0) return 0;

        HashSet<Integer> st = new HashSet<>();

        for(int i:nums){
            st.add(i);
        }

        int maxLen = 1;

        for(int val:st){
            if(!st.contains(val - 1)){
                int count = 0;
                int x = val;

                while (st.contains(x)) {
                    x = x+1;
                    count++;

                    maxLen = Math.max(maxLen,count);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int [] arr = {101,4,100,102,1,3,2};
        
        System.out.println(longestConsicutiveLength(arr));
        System.out.println(longestConsicutiveLengthBetter(arr));

        System.out.println(longestConsicutiveLengthOptimal(arr));
    }
}
