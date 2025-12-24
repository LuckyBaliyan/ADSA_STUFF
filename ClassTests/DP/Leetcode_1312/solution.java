package ClassTests.DP.Leetcode_1312;

import java.util.Arrays;

public class solution {
    public static int MinOperations(String s){
        int n = s.length();

        int [][] dp = new int [n][n];

        for(int [] arr:dp)Arrays.fill(arr, -1);

        return solveMemo(s,0,n-1,dp);
    }

    //Plain Recursion
    public static int solve(String s,int i,int j){
        if(i>=j)return 0;

        if(s.charAt(i) == s.charAt(j)){
            return solve(s, i+1, j-1);
        }

        return 1+Math.min(solve(s,i+1,j),solve(s, i, j-1));
    }

    //Memoization
    public static int solveMemo(String s,int i,int j,int [][] dp){
        if(i >= j)return 0;

        if(dp[i][j] != -1)return dp[i][j];

        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] =  solveMemo(s, i+1, j-1,dp);
        }

        return dp[i][j] = 1 + Math.min(solveMemo(s,i+1,j,dp),solveMemo(s,i,j-1,dp)); 
    }

    /*public static int solveTab(String s){
        int n = s.length();

        int [][] dp = new int [n][n];

        
    }*/

    public static void main(String[] args) {
        System.out.println(MinOperations("zzazz"));
    }
}
