package leetcode.Arrays2.LeetCode_2149;

/**
 * 
 * 
You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

You should return the array of nums such that the array follows the given conditions:

Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

 

Example 1:

Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]
Explanation:
The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.  
Example 2:

Input: nums = [-1,1]
Output: [1,-1]
Explanation:
1 is the only positive integer and -1 the only negative integer in nums.
So nums is rearranged to [1,-1].
 
 * 
 */

public class Solution {

    // Brute
    static int [] reArrange(int [] nums){
        int n = nums.length;

        int [] pos = new int[n/2];
        int [] neg  = new int [n/2];
        int [] res = new int [n];
        int j = 0;  int k = 0;

        for(int i = 0;i<n;i++){
            if (nums[i] < 0){
                neg[j++] = nums[i];
            }
            else pos[k++] = nums[i];
        }

        int l = 0;
        int m = 0;

        for(int i = 0;i<n;i++){
            if(i%2 == 0) res[i] = pos[l++];
            else res[i] = neg[m++];
        }

        return res;

    }

    //Optimal 

    static int [] reArrangeOptimal(int [] nums){
        int n = nums.length;
        int [] res = new int [n];
        int p = 0;
        int neg = 1;

        for(int num: nums){
            if(num < 0){
                res[p] = num;
                p += 2;
            }
            else{
                res[neg] = num;
                neg += 2;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int [] arr = {3,1,-2,-5,2,-4};

        int [] ans1  = reArrange(arr);
        int [] ans2  = reArrange(arr);

        for(int a:ans1){
            System.out.print(a+" ");
        }

        System.out.println();

        for(int r:ans2){
            System.out.print(r+" ");
        }
    }
    
}
