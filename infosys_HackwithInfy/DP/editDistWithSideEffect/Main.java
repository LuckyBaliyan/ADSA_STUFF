package infosys_HackwithInfy.DP.editDistWithSideEffect;

import java.util.Scanner;

/*
key observation

At any point, all unprocessed characters of word1 are either:

unchanged, or
ROT13 transformed.

We only need to remember whether ROT13 has been applied an odd number of times.

So define:

dp[i][j][rot]

where:

i = current position in word1
j = current position in word2
rot = 0 → remaining word1 characters are normal
rot = 1 → remaining word1 characters have ROT13 applied

*/

public class Main {
      static int[][][] dp;

      public static char getRot13(char ch) {
            return (char) ('a' + (ch - 'a' + 13) % 26);
      }

      public static int getMinOpr(String w1, String w2) {
            int n = w1.length();
            int m = w2.length();

            dp = new int[n][m][2];

            for (int i = 0; i < n; i++) {
                  for (int j = 0; j < m; j++) {
                        for (int k = 0; k < 2; k++) {
                              dp[i][j][k] = -1;
                        }
                  }
            }

            return solve(w1, w2, 0, 0, n, m, 0);
      }

      public static int solve(String w1, String w2, int i, int j, int n, int m, int rot) {
            if (i == n) {
                  return m - j;
            }

            if (j == m) {
                  return n - i;
            }

            if (dp[i][j][rot] != -1)
                  return dp[i][j][rot];

            char ch = w1.charAt(i);

            if (rot == 1) {
                  ch = getRot13(ch);
            }

            char required = w2.charAt(j);
            int res = Integer.MAX_VALUE;

            if (ch == required) {
                  res = Math.min(res, solve(w1, w2, i + 1, j + 1, n, m, rot));
            } else {
                  res = Math.min(res, 1 + solve(w1, w2, i + 1, j + 1, n, m, rot));
            }

            // insert
            res = Math.min(res, 1 + solve(w1, w2, i, j + 1, n, m, rot ^ 1));

            // delete
            res = Math.min(res, 1 + solve(w1, w2, i + 1, j, n, m, rot ^ 1));

            return dp[i][j][rot] = res;

      }

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            String s1 = sc.next();
            String s2 = sc.next();

            System.out.println(getMinOpr(s1, s2));

            sc.close();
      }
}
