package ClassTests.DP.Minimum_Sum_partitions;

import java.util.Arrays;

public class Solution {
     public static int [][] dp  = new int [5][24];
     public static int minDifference(int arr[]) {
        // Your code goes here
        int n = arr.length;
        int ts = 0;
        
        for(int i = 0;i<n;i++)ts+=arr[i];
        
        for(int [] ar:dp) Arrays.fill(ar,-1);
        return solve(arr,n-1,0,ts,dp);
    }
    
    // Memoization Approach --> O(N) and O(2N)
    public static int solve(int [] arr,int i,int sum,int ts,int [][] dp){
        if(i < 0)return Math.abs((ts - sum) - sum);
        
        if(dp[i][sum] != -1)return dp[i][sum];

        int take = Integer.MAX_VALUE;
        
        if(arr[i] + sum <= ts){
            take = solve(arr,i-1,sum + arr[i],ts,dp);
        }
        int notTake  = solve(arr,i-1,sum,ts,dp);
        return dp[i][sum] =  Math.min(take,notTake);
    }

    public static void main(String[] args) {
        System.out.println(minDifference(new int [] {1,6,11,5}));

        for(int i =0;i<5;i++){
            for(int j = 0;j<24;j++){
                System.out.print("["+dp[i][j]+"] ");
            }

            System.out.println();
        }
    }


}
