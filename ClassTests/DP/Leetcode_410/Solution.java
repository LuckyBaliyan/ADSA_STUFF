package ClassTests.DP.Leetcode_410;

import java.util.Arrays;

public class Solution {
    public static int n = 5;
    public static int k  = 2;
    public static int [][] dp= new int [n+1][k+1];

    public static int splitArray(int [] arr){
        for (int [] a : dp) {
            Arrays.fill(a,-1);
        }
        return solveRecMemo(arr, 0,n,k,dp);
    }
      //Memoization
    public static int solveRecMemo(int [] arr,int i,int n,int k,int [][] dp){
        //BASE CASE
        if(k == 1){
            int sum = 0;
            for(int j = i;j<n;j++)sum += arr[j];
            return sum;
        }

        if(dp[i][k] != -1)return dp[i][k];

        int currSum = 0;
        int ans = Integer.MAX_VALUE;

        for(int j = i;j<=n-k;j++){
            currSum += arr[j];

            int right = solveRecMemo(arr,j+1,n,k-1,dp);
            int max = Math.max(right,currSum);

            ans = Math.min(ans,max);
        }

        return dp[i][k] = ans;
    }

    public static void main(String[] args) {
       System.out.println(splitArray(new int [] {7,2,5,10,8}));

       for(int i = 0;i<n+1;i++){
        for(int j = 0;j<k+1;j++){
            System.out.print(dp[i][j]+" ");
        }
        System.out.println();
       }
    }
}
