package leetcode.DP.LargestDivisibleSubSet;

import java.util.*;

public class Main {
    //static List<Integer> [][] dp;
    public static List<Integer> giveSubset(int [] arr){
        int n = arr.length;

        //@SuppressWarnings("unchecked")
        //dp = new ArrayList[n][n+1]; // for prev + 1 store to avoid -1
        //return solve(arr,0,-1,dp);

        return null;
    }

    public static List<Integer> solve(int [] arr,int i,int prev,List<Integer> [][] dp){
        int n = arr.length;

        if(i == n)return new ArrayList<>();

        if(dp[i][prev + 1] != null)return dp[i][prev + 1];

        List<Integer> take = new ArrayList<>();
        if(prev == -1 || (arr[i] % arr[prev] == 0) || (arr[prev] % arr[i] == 0)){
            take = solve(arr, i+1, i, dp);
            take = new ArrayList<>(take);
            take.add(arr[i]);
        }

        List<Integer> skip = solve(arr, i+1, prev, dp);

        return dp[i][prev + 1] = skip.size() > take.size() ? skip : take;
    }
    public static void main(String[] args) {
        //System.out.println(giveSubset(new int [] {1,2,3}));

        //System.out.println();

        /*for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp.length+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/

        System.out.println(solveTab(new int [] {1,2,3}));
    }

    public static List<Integer> solveTab(int [] arr){
       int n = arr.length;

       int [][] dp = new int [n+1][n+1];
       List<Integer> res = new ArrayList<>();

       for(int i = n-1;i>=0;i--){
        for(int j = -1;j<=i-1;j++){
            int take = 0;
            if(j == -1 || arr[j] % arr[i] == 0 || arr[i] % arr[j] == 0){
                take = 1 + dp[i+1][i+1];
            }
            int notTake = dp[i][j+1];

            dp[i][j+1] = Math.max(take,notTake);
        }
       }

       int prev = -1;

       for(int i = 0;i<n;i++){
            if(prev == -1 || arr[i] % arr[prev] == 0 || arr[prev] % arr[i] == 0){
                if(dp[i+1][i+1] + 1 == dp[i][prev + 1]){
                    res.add(arr[i]);
                    prev = i;
                }
            }
       }

       return res;
    }
}
