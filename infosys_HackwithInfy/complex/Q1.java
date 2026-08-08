package infosys_HackwithInfy.complex;

import java.util.Scanner;

/*
Dual Grid Maximum Path Sum Topics: Dynamic Programming, Grid Traversal    
Difficulty: Medium–Hard Problem Statement You are given two n × m grids G1 and G2, 
and a switching penalty cost.Start at cell (1, 1) (1-based indexing) and reach cell (n, m).
At each step you may move only right or down. Both grids are traversed in parallel — a move in
one grid implies the same move in the other. At each cell, collect the value from whichever grid you are currently on. 
If you switch grids between two consecutive cells, pay a penalty of cost (deducted from the total). You may switch grids any number 
of times. Return the maximum total value collectible from (1,1) to (n,m). 

Input Format Line 1: n m cost Next n lines: m integers each — values of G1 
Next n lines: m integers each — values of G2 

Test Cases 
Input 
Output n=2 m=2 cost=10 G1: 1 100 / 1 1 G2: 1 1 / 100 1 102 Explanation: Stay on G1 throughout — 
(1,1)=1, (1,2)=100, (2,2)=1. Total = 102. Switching to G2 at any point incurs a penalty of 10 and yields a lower total.
Input Output n=1 m=3 cost=5 G1: 1 1 10 G2: 10 10 1 20 Explanation: G2(1,1)=10, switch to G2(1,2)=10 (no switch cost yet since
same grid), switch to G1(1,3)=10, pay cost=5. Total = 10+10+10-5 = 25. Or: stay G2: 10+10+1=21. Or G1: 1+1+10=12. Best = 25.
*/

public class Q1 {
      static int cost;
      static int[][][] dp;

      public static long solve(int n, int m, int i, int j, int trend, int[][] g1, int[][] g2) {
            if (i >= n || j >= m)
                  return Long.MIN_VALUE / 2;

            if (i == n - 1 && j == m - 1)
                  return (trend == 0) ? g1[i][j] : g2[i][j];

            if (dp[i][j][trend] != -1)
                  return (long) dp[i][j][trend];

            long currVal = trend == 0 ? g1[i][j] : g2[i][j];

            // Now we are gona try right and down on the basis of trend swaps for each
            // branch
            long right = currVal + solve(n, m, i, j + 1, trend, g1, g2);
            long down = currVal + solve(n, m, i + 1, j, trend, g1, g2);

            long rightSwap = currVal - cost + solve(n, m, i, j + 1, 1 - trend, g1, g2);
            long downSwap = currVal - cost + solve(n, m, i + 1, j, 1 - trend, g1, g2);

            // System.out.println(right + " " + down + " " + rightSwap + " " + downSwap);

            return dp[i][j][trend] = (int) Math.max(Math.max(right, down), Math.max(rightSwap, downSwap));
      }

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int m = sc.nextInt();

            cost = sc.nextInt();

            int[][] grid1 = new int[n][m];
            int[][] grid2 = new int[n][m];

            dp = new int[n][m][2];

            for (int i = 0; i < n; i++) {
                  for (int j = 0; j < m; j++) {
                        for (int k = 0; k < 2; k++) {
                              dp[i][j][k] = -1;
                        }
                  }
            }

            for (int i = 0; i < n; i++) {
                  for (int j = 0; j < m; j++) {
                        grid1[i][j] = sc.nextInt();
                  }
            }

            for (int i = 0; i < n; i++) {
                  for (int j = 0; j < m; j++) {
                        grid2[i][j] = sc.nextInt();
                  }
            }

            long res = Math.max(solve(n, m, 0, 0, 0, grid1, grid2), solve(n, m, 0, 0, 1, grid1, grid2));

            System.out.println(res);

            sc.close();
      }
}
