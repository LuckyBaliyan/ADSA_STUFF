package infosys_HackwithInfy.DP.pathWithAdjacentGapPenalty;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
      static long[][] dp;

      public static long getMinCost(int[][] grid, int n, int m, int k, int c) {

            dp = new long[n][m];

            for (int i = 0; i < n; i++) {
                  Arrays.fill(dp[i], -1);
            }

            // initial cost is the elevation of starting cell
            return grid[0][0] + solve(grid, n, m, k, c, 0, 0);
      }

      public static long solve(int[][] grid, int n, int m, int k, int c, int i, int j) {

            if (i == n - 1 && j == m - 1) {
                  return 0;
            }

            if (dp[i][j] != -1) {
                  return dp[i][j];
            }

            long res = Long.MAX_VALUE;

            // check for step (dist == 1)

            if (i + 1 < n) {

                  int cost = grid[i + 1][j];

                  if (Math.abs(grid[i][j] - grid[i + 1][j]) > k)
                        cost += c;

                  res = Math.min(
                              res,
                              cost + solve(grid, n, m, k, c, i + 1, j));
            }

            if (j + 1 < m) {

                  int cost = grid[i][j + 1];

                  if (Math.abs(grid[i][j] - grid[i][j + 1]) > k)
                        cost += c;

                  res = Math.min(
                              res,
                              cost + solve(grid, n, m, k, c, i, j + 1));
            }

            // check for jumps (dist > 1)

            if (i + 2 < n) {

                  for (int idx = i + 2; idx < n; idx++) {

                        if (Math.abs(grid[idx][j] - grid[i][j]) <= k) {

                              int cost = grid[idx][j]
                                          + c * (idx - i - 1);

                              res = Math.min(
                                          res,
                                          cost + solve(
                                                      grid,
                                                      n,
                                                      m,
                                                      k,
                                                      c,
                                                      idx,
                                                      j));
                        }
                  }
            }

            if (j + 2 < m) {

                  for (int idx = j + 2; idx < m; idx++) {

                        // horizontal jump -> row stays i
                        if (Math.abs(grid[i][idx] - grid[i][j]) <= k) {

                              int cost = grid[i][idx]
                                          + c * (idx - j - 1);

                              res = Math.min(
                                          res,
                                          cost + solve(
                                                      grid,
                                                      n,
                                                      m,
                                                      k,
                                                      c,
                                                      i,
                                                      idx));
                        }
                  }
            }

            return dp[i][j] = res;
      }

      public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int c = sc.nextInt();

            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {
                  for (int j = 0; j < m; j++) {
                        grid[i][j] = sc.nextInt();
                  }
            }

            System.out.println(getMinCost(grid, n, m, k, c));

            sc.close();
      }
}
