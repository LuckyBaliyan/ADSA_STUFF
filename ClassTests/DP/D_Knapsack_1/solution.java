package ClassTests.DP.D_Knapsack_1;

import java.util.Arrays;
import java.util.Scanner;

public class solution {
   public static int d_KnapSack(int [] weights,int [] values,int N,int W){
      int n = weights.length;
     // int [][] dp  = new int [N][W+1];
      //for(int[] arr:dp)Arrays.fill(arr,-1);
      //return solve(weights,values,n-1,W,dp);

      return solveTab(weights, values, N, W);
   }

   public static int solveTab(int [] weights,int [] values,int N,int W){
      int [][] dp = new int [N][W+1];

      for(int i = 0;i<N;i++){
         dp[i][0] = 0;
      }

      for(int j = 1;j<=W;j++){
         if(weights[0] <= j)dp[0][j] = values[0];
         else dp[0][j] = 0;
      }

      for(int i = 1;i<N;i++){
         for(int j = 1;j<=W;j++){
            int take = 0;
            if(j>= weights[i]){
               take = dp[i-1][j - weights[i]]+values[i];
            }
            int notTake = dp[i-1][j];
            dp[i][j] = Math.max(take,notTake);
         }
      }

      return dp[N-1][W];
   }


   //Memoization Code
   public static int solve(int [] weights,int [] values,int i,int W,int [][] dp){
      if(W == 0 || i < 0)return 0;

      if(dp[i][W] != -1)return dp[i][W];
      
      int take = 0;
      if(W >= weights[i]){
        take = values[i] + solve(weights, values, i-1, W - weights[i],dp);
      }

      int notTake  = solve(weights, values, i-1, W, dp);

      return dp[i][W] =  Math.max(take, notTake);
   }

   public static void main(String[] args) {
     /*Scanner sc = new Scanner(System.in);
     int N = sc.nextInt();
     int W = sc.nextInt();
     int [] weights = new int [N];
     int [] values = new int [N];

     for(int i = 0;i<N;i++){
        weights[i] = sc.nextInt();
     }

     
     for(int i = 0;i<N;i++){
        values[i] = sc.nextInt();
     }

     System.out.println(d_KnapSack(weights, values, N, W));

     6 15
     6 5
     5 6
     6 4
     6 6
     3 5
     7 2


   */
     System.out.println(d_KnapSack(new int [] {6,5,6,6,3,7}, new int [] {5,6,4,6,5,2}, 6, 15));
   }
}
