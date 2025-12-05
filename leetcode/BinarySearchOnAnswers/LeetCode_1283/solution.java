package leetcode.BinarySearchOnAnswers.LeetCode_1283;

/* 
Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

The test cases are generated so that there will be an answer.

 

Example 1:

Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 
Example 2:

Input: nums = [44,22,33,11,1], threshold = 5
Output: 44
 

Constraints:

1 <= nums.length <= 5 * 104
1 <= nums[i] <= 106
nums.length <= threshold <= 106
 
*/

public class solution {

   public static int giveDivisor(int [] nums,int threshold){
       int n = nums.length;

       //we know that we can have the smallest divisor to be 1 and  the largest to be of max elem of array

       int maxVal = Integer.MIN_VALUE;

       for(int val:nums){
          maxVal = Math.max(val, maxVal);
       }

       int l = 1;
       int h = maxVal;

       while(l<=h){
        int mid = l+(h-l)/2;

        if(isValidDivisor(nums,threshold,mid,n)){
            h  = mid-1;
        }
        else{
            l = mid+1;
        }
       }

       return l;
   }

    static boolean isValidDivisor(int[] arr,int lim,int val,int n){
        int res = 0;

        for(int i = 0;i<n;i++){
            res += Math.ceil((double) arr[i]/val);
            if(res > lim)return false;
        }

        return res <= lim;

   }

    public static void main(String[] args) {
        System.out.println(giveDivisor(new int [] {1,2,5,9}, 6));  // 5
    }
    
}
