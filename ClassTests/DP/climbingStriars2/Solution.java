/*
Climb Stairs with Variable Jumps
🟢 Easy

Submissions: 12

Success rate: 66.67%

You are given n steps and an array arr of size n, where arr[i] denotes the maximum number of steps you can jump forward from the i-th step. Your task is to determine the number of ways to reach the top (i.e., the n-th step) from the bottom (starting at the 0-th step).


Constraints
1≤n≤10^4
1≤arr[i]≤100

Sample Test Cases
Input 1:
7
3 3 0 2 2 3 1

Expected Output 1:
13

*/

package ClassTests.DP.climbingStriars2;

import java.util.Arrays;

class Solution {

    public static int  climbingStriars2(int n,int [] arr){
        int [] dp = new int [n+1];

        Arrays.fill(dp,-1);
        //return solve(n,0,arr);

        //return solveMemo(n, 0, arr, dp);

        return solveTabulation(n, arr);
    }

    public static int solveTabulation(int n,int [] arr){
        int [] dp = new int [n+1];

        dp[n] = 1;

        for(int i = n-1;i>=0;i--){
            int ways = 0;

            for(int jump = 1;jump<=arr[i];jump++){
               int next = i+jump;

               if(next <= n){
                ways += dp[next];
               }
            }

            dp[i] = ways;
        }

        return dp[0];
    }

    public static int solveMemo(int n,int indx,int[] arr,int [] dp){
        if(indx == n)return 1;
        if(indx > n)return 0;

        if(dp[indx] != -1)return dp[indx];

        int ways = 0;

        for(int i = 1;i<=arr[indx];i++){
           ways += solveMemo(n, indx+i, arr, dp);
        }

        dp[indx] = ways;
        return dp[indx];
    }

    public static int solve(int n,int indx,int [] arr){
        if(indx == n)return 1;
        if(indx > n)return 0;

        int ways = 0;
        for(int i = 1;i<=arr[indx];i++){
            ways += solve(n, indx+i, arr);
        }

        return ways;
    }

    public static void main(String[] args) {
        int [] arr = {3,3,0,2,2,3,1};

        System.out.println(climbingStriars2(7, arr));  // 13
    }
     
}

