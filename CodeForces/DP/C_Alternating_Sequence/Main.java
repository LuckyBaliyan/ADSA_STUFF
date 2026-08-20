package CodeForces.DP.C_Alternating_Sequence;

import java.util.Scanner;

/*

C. Alternating Subsequence
time limit per test1 second
memory limit per test256 megabytes
Recall that the sequence b
 is a a subsequence of the sequence a
 if b
 can be derived from a
 by removing zero or more elements without changing the order of the remaining elements. For example, if a=[1,2,1,3,1,2,1]
, then possible subsequences are: [1,1,1,1]
, [3]
 and [1,2,1,3,1,2,1]
, but not [3,2,3]
 and [1,1,1,1,2]
.

You are given a sequence a
 consisting of n
 positive and negative elements (there is no zeros in the sequence).

Your task is to choose maximum by size (length) alternating subsequence of the given sequence (i.e. the sign of each next element is the opposite from the sign of the current element, like positive-negative-positive and so on or negative-positive-negative and so on). Among all such subsequences, you have to choose one which has the maximum sum of elements.

In other words, if the maximum length of alternating subsequence is k
 then your task is to find the maximum sum of elements of some alternating subsequence of length k
.

You have to answer t
 independent test cases.

Input
The first line of the input contains one integer t
 (1≤t≤104
) — the number of test cases. Then t
 test cases follow.

The first line of the test case contains one integer n
 (1≤n≤2⋅105
) — the number of elements in a
. The second line of the test case contains n
 integers a1,a2,…,an
 (−109≤ai≤109,ai≠0
), where ai
 is the i
-th element of a
.

It is guaranteed that the sum of n
 over all test cases does not exceed 2⋅105
 (∑n≤2⋅105
).

Output
For each test case, print the answer — the maximum sum of the maximum by size (length) alternating subsequence of a
.

Example
InputCopy
4
5
1 2 3 -1 -2
4
-1 -2 -1 -3
10
-2 8 3 8 -4 -15 5 -2 -3 1
6
1 -1000000000 1 -1000000000 1 -1000000000
OutputCopy
2
-1
6
-2999999997
Note
In the first test case of the example, one of the possible answers is [1,2,3–,−1–––,−2]
.

In the second test case of the example, one of the possible answers is [−1,−2,−1–––,−3]
.

In the third test case of the example, one of the possible answers is [−2–––,8,3,8–,−4–––,−15,5–,−2–––,−3,1–]
.

In the fourth test case of the example, one of the possible answers is [1–,−1000000000–––––––––––––,1–,−1000000000–––––––––––––,1–,−1000000000–––––––––––––]
.

*/

public class Main {
      static long[][][][] dp;
      static boolean[][][] visited;

      public static long getMaxSum(long[] arr, int n) {
            // indeed take first
            dp = new long[n][2][2][2];
            visited = new boolean[n][2][2];

            long[] ans = solve(arr, n, 0, arr[0] < 0, false);
            return ans[1];
      }

      public static long[] solve(long[] arr, int n, int i, boolean isNeg, boolean started) {
            if (i == n)
                  return new long[] { 0, 0 };

            if (visited[i][isNeg ? 1 : 0][started ? 1 : 0]) {
                  return new long[] {
                              dp[i][isNeg ? 1 : 0][started ? 1 : 0][0],
                              dp[i][isNeg ? 1 : 0][started ? 1 : 0][1]
                  };
            }

            visited[i][isNeg ? 1 : 0][started ? 1 : 0] = true;

            long[] skip = solve(arr, n, i + 1, isNeg, started);
            long[] take = new long[] { -1, Integer.MIN_VALUE };

            if (!started) {
                  long[] next = solve(arr, n, i + 1, isNeg, true);

                  take[0] = 1 + next[0];
                  take[1] = arr[i] + next[1];
            }

            // 2 trends based on current element sign
            if (isNeg) {
                  if (arr[i] > 0) {
                        long[] next = solve(arr, n, i + 1, false, true);

                        take[0] = 1 + next[0];
                        take[1] = arr[i] + next[1];
                  }
            } else {
                  if (arr[i] < 0) {
                        long[] next = solve(arr, n, i + 1, true, true);

                        take[0] = 1 + next[0];
                        take[1] = arr[i] + next[1];
                  }
            }

            // case 1: - len take > len skip then return sum of take
            if (take[0] > skip[0]) {
                  dp[i][isNeg ? 1 : 0][started ? 1 : 0][0] = take[0];
                  dp[i][isNeg ? 1 : 0][started ? 1 : 0][1] = take[1];
                  return take;
            }

            // case 2:- len skip > len of take then return sum of skip
            if (take[0] < skip[0]) {
                  dp[i][isNeg ? 1 : 0][started ? 1 : 0][0] = skip[0];
                  dp[i][isNeg ? 1 : 0][started ? 1 : 0][1] = skip[1];
                  return skip;
            }

            // case 3:- if len take == len skip but sum take > sum skip
            if (take[1] > skip[1]) {
                  dp[i][isNeg ? 1 : 0][started ? 1 : 0][0] = take[0];
                  dp[i][isNeg ? 1 : 0][started ? 1 : 0][1] = take[1];
                  return take;
            }

            // case4:- if len take == len skip and sum take < sum skip
            dp[i][isNeg ? 1 : 0][started ? 1 : 0][0] = skip[0];
            dp[i][isNeg ? 1 : 0][started ? 1 : 0][1] = skip[1];
            return skip;
      }

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                  int n = sc.nextInt();
                  long[] seq = new long[n];

                  for (int i = 0; i < n; i++)
                        seq[i] = sc.nextLong();

                  System.out.println(getMaxSum(seq, n));
            }

            sc.close();
      }
}
