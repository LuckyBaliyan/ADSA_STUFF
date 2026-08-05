package CodeForces.DP.C_The_Values_U_Can_Make;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
C. The Values You Can Make
time limit per test2 seconds
memory limit per test256 megabytes
Pari wants to buy an expensive chocolate from Arya. She has n coins, the value of the i-th coin is ci. 
The price of the chocolate is k, so Pari will take a subset of her coins with sum equal to k and give it to Arya.

Looking at her coins, a question came to her mind: after giving the coins to Arya, what values does Arya can make with them? 
She is jealous and she doesn't want Arya to make a lot of values. So she wants to know all the values x, such that Arya will 
be able to make x using some subset of coins with the sum k.

Formally, Pari wants to know the values x such that there exists a subset of coins with the sum k such that some subset of 
this subset has the sum x, i.e. there is exists some way to pay for the chocolate, such that Arya will be able to make the 
sum x using these coins.

Input
The first line contains two integers n and k (1  ≤  n, k  ≤  500) — the number of coins and the price of the chocolate, respectively.

Next line will contain n integers c1, c2, ..., cn (1 ≤ ci ≤ 500) — the values of Pari's coins.

It's guaranteed that one can make value k using these coins.

Output
First line of the output must contain a single integer q— the number of suitable values x. Then print q integers in ascending order — the values that Arya can make for some subset of coins of Pari that pays for the chocolate.

Examples
InputCopy
6 18
5 6 1 10 12 2
OutputCopy
16
0 1 2 3 5 6 7 8 10 11 12 13 15 16 17 18 
InputCopy
3 50
25 25 50
OutputCopy
3
0 25 50 

*/

public class Main {
      static List<Long> ans;
      static Set<Long> st;

      // static long[][][] memo;
      static boolean[][] dp;

      public static void getVals(long[] arr, int n, long k) {
            // memo = new long[n + 1][501][501];

            /*
             * for (int i = 0; i <= n; i++) {
             * for (int j = 0; j < 501; j++) {
             * for (int l = 0; l < 501; l++) {
             * memo[i][j][l] = -1;
             * }
             * }
             * }
             */

            dp = new boolean[(int) (k + 1)][(int) (k + 1)];
            dp[0][0] = true;

            ans = new ArrayList<>();
            st = new HashSet<>();

            // instead of making unecceary dimension for each coin tyr solve
            for (long coin : arr) {
                  for (long coinSum = k - coin; coinSum >= 0; coinSum--) {
                        for (long aryaSum = k - coin; aryaSum >= 0; aryaSum--) {
                              if (!dp[(int) coinSum][(int) aryaSum])
                                    continue;

                              // first case coinSum
                              dp[(int) (coinSum + coin)][(int) aryaSum] = true;

                              // both
                              dp[(int) (coinSum + coin)][(int) (aryaSum + coin)] = true;
                        }
                  }
            }

      }

      /*
       * private static void solve(long[] arr, int n, long k, long coinSum, long
       * aryaSum, int idx) {
       * if (coinSum > k)
       * return;
       * 
       * if (idx == n) {
       * if (coinSum == k) {
       * st.add(aryaSum);
       * }
       * 
       * return;
       * }
       * 
       * if (memo[idx][(int) coinSum][(int) aryaSum] != -1)
       * return;
       * 
       * // we use dp as a boolean or visited in void functions and before recursion
       * memo[idx][(int) coinSum][(int) aryaSum] = 1;
       * 
       * // 3 choices wheather to take a coint and increase currSum to fulfill k but
       * arya
       * // don't like it
       * solve(arr, n, k, coinSum + arr[idx], aryaSum, idx + 1);
       * 
       * // whether arya also likr to take that coin
       * solve(arr, n, k, coinSum + arr[idx], aryaSum + arr[idx], idx + 1);
       * 
       * // whether leave it
       * solve(arr, n, k, coinSum, aryaSum, idx + 1);
       * }
       */

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            long k = sc.nextLong();

            long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                  arr[i] = sc.nextLong();
            }

            getVals(arr, n, k);

            /*
             * for (long c : st)
             * ans.add(c);
             * 
             * Collections.sort(ans);
             * int sz = ans.size();
             * 
             * System.out.println(sz);
             * 
             * for (int i = 0; i < sz; i++) {
             * System.out.print(ans.get(i) + " ");
             * }
             */

            // finally travrse the dp to cnt the values
            int sz = 0;
            for (long x = 0; x <= k; x++) {
                  if (dp[(int) k][(int) x]) {
                        sz++;
                  }
            }

            System.out.println(sz);

            // same to print all the values
            for (long x = 0; x <= k; x++) {
                  if (dp[(int) k][(int) x]) {
                        System.out.print(x + " ");
                  }
            }
      }
}
