package leetcode.DP.Day_01.Fibonacci;

public class Solution {
    public static int fibonacci(int n){
       //Plain Recursion
       //return fiboRec(n);

       //Memoization
       int [] dp = new int [n+1];
       //return fiboDpMemo(n,dp);

       //Tabulation
       //return fiboDpTab(n,dp);

       //Tabulation + spaceOptimized
       return fiboSpaceOptimized(n);
       
    }

    public static int fiboDpTab(int n,int [] dp){
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2;i<=n;i++){
            dp[i] =  dp[i-1]+dp[i-2];
        }

        return dp[n];
    }

    public static int fiboSpaceOptimized(int n){
        int prev = 1;
        int prev2 = 0;

        for(int i = 2;i<=n;i++){
            int curr = prev+prev2;
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    public static int fiboDpMemo(int n,int [] dp){
        if(n<=1)return n;

        if(dp[n] != 0)return dp[n];

        return dp[n] = fiboDpMemo(n-1, dp)+fiboDpMemo(n-2, dp);
    }

    public static int fiboRec(int n){
        if(n<=1)return n;

        return fiboRec(n-1)+fiboRec(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }
}

