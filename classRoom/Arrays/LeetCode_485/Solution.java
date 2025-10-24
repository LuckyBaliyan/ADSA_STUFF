package classRoom.Arrays.LeetCode_485;

/**
 * Find maxing consicutive ones and the array only consist binary values 0,1s
 */

public class Solution {
    static int maxConsicutiveOnes(int [] nums){
        int n = nums.length;

        if(n == 1) return 1;

        int count  = 0;
        int maxlen = 0;

        for(int i =0;i<n;i++){
            if(nums[i] != 0){
               count++;
               maxlen = Math.max(maxlen,count);
            }
            else{
                count = 0;
            }
        }

        return maxlen;
    }

    public static void main(String[] args) {
        int [] arr = {1,1,0,1,1,1};
        System.out.println(maxConsicutiveOnes(arr));
    }
}
