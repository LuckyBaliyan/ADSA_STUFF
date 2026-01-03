package CSES_Problem.dp.Book_Shop;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int solve(int [] prices,int [] pages,int n,int sum,int [][] dp){
        if(n < 0)return 0;

        if(sum == 0)return 0;

        if(dp[n][sum] != -1)return dp[n][sum];

        int take = Integer.MIN_VALUE;
        if(sum >= prices[n]){
          take = pages[n] + solve(prices, pages, n-1, sum - prices[n],dp);
        }

        int skip = solve(prices, pages, n - 1, sum,dp);
        
        return dp[n][sum] = Math.max(skip,take);
    }

    public static int solveTab(int [] prices,int [] pages,int sum){
        int n = prices.length;
        int [] dp = new int [sum + 1];

        for(int i= 0;i<n;i++){
            for(int j = sum;j>=prices[i];j--){
                dp[j] = Math.max(dp[j], dp[j - prices[i]]+pages[i]);
            }
        }

        return dp[sum];
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
       int n = sc.nextInt();
       int x = sc.nextInt();

       int [] h = new int [n];
       int [] s = new int [n];

       for(int i = 0;i<n;i++){
         h[i] = sc.nextInt();
       }

       for(int i = 0;i<n;i++){
         s[i] = sc.nextInt();
       }

       int [][] dp = new int[n+1][x+1];

       for(int [] arr:dp)Arrays.fill(arr, -1);

       System.out.println(solveTab(h, s, x));
    }
}
