package CodeForces.DP.A_ArrayColoring;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
A. Array Coloring
time limit per test1 second
memory limit per test256 megabytes
You are given an array consisting of n
 integers. Your task is to determine whether it is possible to color all its elements in two colors in such a way that the sums of the elements of both colors have the same parity and each color has at least one element colored.

For example, if the array is [1,2,4,3,2,3,5,4
], we can color it as follows: [1,2,4,3,2,3,5,4
], where the sum of the blue elements is 6
 and the sum of the red elements is 18
.

Input
The first line contains an integer t
 (1≤t≤1000
) — the number of test cases.

Each test case begins with a line containing an integer n
 (2≤n≤50
) — the length of the array a
.

The next line contains n
 integers a1,a2,…,an
 (1≤ai≤50
) — the elements of the array a
.

Output
For each test case, output "YES" (without quotes) if it is possible to color the array in two colors in such a way that the sums of the elements of both colors have the same parity and each color has at least one element colored, and "NO" otherwise.

You can output "Yes" and "No" in any case (for example, the strings "yES", "yes", and "Yes" will be recognized as correct answers).

Example
InputCopy
7
8
1 2 4 3 2 3 5 4
2
4 7
3
3 9 8
2
1 7
5
5 4 3 2 1
4
4 3 4 5
2
50 48
OutputCopy
YES
NO
YES
YES
NO
YES
YES
Note
The first sample is described in the statement.

In the second sample, there are only two colorings [4,7]
 and [4,7]
 , but in both cases the parity of sums is different.

In the third sample, you can color [3,9,8]
 and 12
 and 8
 are both even.
*/

public class Main {

      // static Boolean[][][] dp;

      public static boolean solve(int[] arr, int n) {
            /*
             * if (i >= n) {
             * return (p1 == p2);
             * }
             * 
             * if (dp[i][p1][p2] != null)
             * return dp[i][p1][p2];
             * 
             * int p = arr[i] % 2;
             * 
             * // color the current element with first color
             * boolean color1 = solve(arr, n, i + 1, (p1 + p) % 2, p2);
             * 
             * // color the current elem with sec
             * boolean color2 = solve(arr, n, i + 1, p1, (p2 + p) % 2);
             * 
             * return dp[i][p1][p2] = color1 || color2;
             */

            Boolean[][][] dp = new Boolean[n + 1][2][2];

            for (int p1 = 0; p1 <= 1; p1++) {
                  for (int p2 = 0; p2 <= 1; p2++) {
                        dp[n][p1][p2] = p1 == p2;
                  }
            }

            for (int i = n - 1; i >= 0; i--) {
                  int p = arr[i] % 2;
                  for (int p1 = 0; p1 <= 1; p1++) {
                        for (int p2 = 0; p2 <= 1; p2++) {
                              // case 1 : color current element with first color
                              Boolean color1 = dp[i + 1][(p1 + p) % 2][p2];

                              // case 2: color current elem with sec color
                              Boolean color2 = dp[i + 1][p1][(p + p2) % 2];

                              dp[i][p1][p2] = color1 || color2;
                        }
                  }
            }

            return dp[0][0][0];
      }

      public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(br.readLine());

            while (t-- > 0) {
                  StringTokenizer st = new StringTokenizer(br.readLine());
                  int n = Integer.parseInt(st.nextToken());

                  st = new StringTokenizer(br.readLine());

                  int[] arr = new int[n];
                  // int offset = 0;

                  for (int i = 0; i < n; i++) {
                        arr[i] = Integer.parseInt(st.nextToken());
                        // offset += arr[i];
                  }

                  // dp = new Boolean[n][2][2];

                  /*
                   * for (int i = 0; i < n; i++) {
                   * for (int j = 0; j <= 1; j++) {
                   * for (int k = 0; k <= 1; k++)
                   * dp[i][j][k] = null;
                   * }
                   * }
                   */

                  System.out.println(solve(arr, n) ? "YES" : "NO");
            }
      }
}
