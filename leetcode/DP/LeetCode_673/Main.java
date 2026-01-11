package leetcode.DP.LeetCode_673;

/*
673. Number of Longest Increasing Subsequence
Medium
Topics
premium lock icon
Companies
Given an integer array nums, return the number of longest increasing subsequences.

Notice that the sequence has to be strictly increasing.

 

Example 1:

Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:

Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.
 

Constraints:

1 <= nums.length <= 2000
-106 <= nums[i] <= 106
The answer is guaranteed to fit inside a 32-bit integer.
 */

public class Main {
    public static void solveTab(int [] arr){
        int n = arr.length;

        int [] curr = new int [n+1];
        int [] next = new int [n+1];
        int [] currCnt = new int [n+1];
        int [] nextCnt = new int [n+1];

        for(int j = 0;j<=n;j++)nextCnt[j] = 1;

        for(int i = n-1;i>=0;i--){
            for(int j = -1;j<=i-1;j++){
                int take = 0,takeCnt = 0;
                if(j == -1 || arr[i] > arr[j]){
                    take = 1 + next[i+1];
                    takeCnt = nextCnt[i+1];
                }

                int notTake = next[j+1];
                int notTakeCnt = nextCnt[j+1];

                curr[j+1] = Math.max(take, notTake);

                if(take > notTake){
                    currCnt[j+1] = takeCnt;
                }
                else if(take < notTake){
                    currCnt[j+1] = notTakeCnt;
                }
                else currCnt[j+1] = takeCnt + notTakeCnt;
            }

            next = curr.clone();
            nextCnt = currCnt.clone();

            //return dpCnt[0][0];
        }

     
        for(int j = 0;j<=n;j++)System.out.print(next[j]+" ");
        
        System.out.println();

        for(int k = 0;k<=n;k++){
            System.out.print(nextCnt[k]+" ");
        }
    }
    public static void main(String[] args) {
        solveTab(new int [] {1,3,5,4,7});
    }
}
