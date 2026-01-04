package CSES_Problem.dp.Grid_paths_1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int MOD = 1000000007;

    public static int solve(char [][] grid,int i,int j,int [][] dp){
        int n = grid.length;

        if(i >= n || j >= n)return 0;
        if (grid[i][j] == '*') return 0;
        if(i == n-1 && j == n-1)return 1;

        if(dp[i][j] != - 1)return dp[i][j];

        return dp[i][j] = (solve(grid, i+1, j,dp) + solve(grid, i, j+1,dp))%MOD;
    }

    public static int solveTab(char [][] grid){
        int n = grid.length;

        int [][] dp = new int [n][n];
        
        if(grid[n-1][n-1] == '*')return 0;

        dp[n-1][n-1] = 1;

        for(int i = n-1;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                if(grid[i][j] == '*'){
                    dp[i][j] = 0;
                    continue;
                }

                if(i < n-1)dp[i][j] = (dp[i][j] + dp[i+1][j])%MOD;
                if(j < n-1)dp[i][j] = (dp[i][j] + dp[i][j+1])%MOD;
                
            }
        }

        return dp[0][0];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        char [][] grid = new char [n][n];

        for (int i = 0; i < n; i++) {
           String row = sc.next();
           for (int j = 0; j < n; j++) {
               grid[i][j] = row.charAt(j);
           }
        }

        int [][] dp = new int [n][n];
        for(int [] arr: dp)Arrays.fill(arr,-1);

        System.out.println(solveTab(grid));
    }
}
