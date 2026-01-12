package leetcode.DP.LargestDivisibleSubSet;

import java.util.*;

public class Main {
    static List<Integer> [][] dp;
    public static List<Integer> giveSubset(int [] arr){
        int n = arr.length;

        //@SuppressWarnings("unchecked")
        dp = new ArrayList[n][n+1]; // for prev + 1 store to avoid -1
        return solve(arr,0,-1,dp);
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
        System.out.println(giveSubset(new int [] {1,2,3}));

        System.out.println();

        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp.length+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
