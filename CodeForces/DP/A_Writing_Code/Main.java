package CodeForces.DP.A_Writing_Code;

import java.util.Scanner;

/*
A. Writing Code
time limit per test3 seconds
memory limit per test256 megabytes
Programmers working on a large project have just received a task to write exactly m lines of code. There are n programmers working on a project, the i-th of them makes exactly ai bugs in every line of code that he writes.

Let's call a sequence of non-negative integers v1, v2, ..., vn a plan, if v1 + v2 + ... + vn = m. The programmers follow the plan like that: in the beginning the first programmer writes the first v1 lines of the given task, then the second programmer writes v2 more lines of the given task, and so on. In the end, the last programmer writes the remaining lines of the code. Let's call a plan good, if all the written lines of the task contain at most b bugs in total.

Your task is to determine how many distinct good plans are there. As the number of plans can be large, print the remainder of this number modulo given positive integer mod.

Input
The first line contains four integers n, m, b, mod (1 ≤ n, m ≤ 500, 0 ≤ b ≤ 500; 1 ≤ mod ≤ 109 + 7) — the number of programmers, the number of lines of code in the task, the maximum total number of bugs respectively and the modulo you should use when printing the answer.

The next line contains n space-separated integers a1, a2, ..., an (0 ≤ ai ≤ 500) — the number of bugs per line for each programmer.

Output
Print a single integer — the answer to the problem modulo mod.

Examples
InputCopy
3 3 3 100
1 1 1
OutputCopy
10
InputCopy
3 6 5 1000000007
1 2 3
OutputCopy
0
InputCopy
3 5 6 11
1 2 1
OutputCopy
0
 */

public class Main {
      public static long getPlans(long[] arr, int n, int m, int mod, long b) {
            return solve(arr, n, m, mod, b, 0, 0, 0);
      }

      public static long solve(long[] arr, int n, int m, int mod, long b, int idx, int lines, long bugs) {
            long ans = 0;

            if (bugs > b)
                  return 0;

            if (lines > m)
                  return 0;

            // if are able to reach end we have atmost given bugs
            if (idx == n) {
                  return lines == m ? 1 : 0;
            }

            for (int k = 0; k <= m - lines; k++) {
                  ans = (ans + solve(arr, n, m, mod, b, idx + 1, lines + k, (bugs + k * arr[idx]))) % mod;
            }

            return ans;
      }

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int m = sc.nextInt();
            long b = sc.nextLong();
            int mod = sc.nextInt();

            long[] a = new long[n];

            for (int i = 0; i < n; i++)
                  a[i] = sc.nextLong();

            // System.out.println(getPlans(a, n, m, mod, b));
            long[][] dp = new long[m + 1][(int) (b + 1)];

            dp[0][0] = 1;

            for (int i = 0; i < n; i++) {

                  for (int lines = 1; lines <= m; lines++) {

                        for (int bugs = (int) a[i]; bugs <= b; bugs++) {

                              dp[lines][bugs] = (dp[lines][bugs] + dp[lines - 1][bugs - (int) a[i]]) % mod;
                        }
                  }

                  // print table for each programmer state
                  /*
                   * for (int l = 0; l < m + 1; l++) {
                   * for (int u = 0; u < b + 1; u++) {
                   * System.out.print(dp[l][u] + " ");
                   * }
                   * System.out.println();
                   * }
                   * 
                   * System.out.println();
                   */
            }

            long ans = 0;

            for (int bugs = 0; bugs <= b; bugs++) {
                  ans = (ans + dp[m][bugs]) % mod;
            }

            System.out.println(ans);
      }
}
