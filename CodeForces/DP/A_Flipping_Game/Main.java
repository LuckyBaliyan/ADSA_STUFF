package CodeForces.DP.A_Flipping_Game;

/*
A. Flipping Game
time limit per test1 second
memory limit per test256 megabytes
Iahub got bored, so he invented a game to be played on paper.

He writes n integers a1, a2, ..., an. Each of those integers can be either 0 or 1. He's allowed to do exactly one move: he chooses two indices i and j (1 ≤ i ≤ j ≤ n) and flips all values ak for which their positions are in range [i, j] (that is i ≤ k ≤ j). Flip the value of x means to apply operation x = 1 - x.

The goal of the game is that after exactly one move to obtain the maximum number of ones. Write a program to solve the little game of Iahub.

Input
The first line of the input contains an integer n (1 ≤ n ≤ 100). In the second line of the input there are n integers: a1, a2, ..., an. It is guaranteed that each of those n values is either 0 or 1.

Output
Print an integer — the maximal number of 1s that can be obtained after exactly one move.

Examples
InputCopy
5
1 0 0 1 0
OutputCopy
4
InputCopy
4
1 0 0 1
OutputCopy
4
Note
In the first case, flip the segment from 2 to 5 (i = 2, j = 5). That flip changes the sequence, it becomes: [1 1 1 0 1]. So, it contains four ones. There is no way to make the whole sequence equal to [1 1 1 1 1].

In the second case, flipping only the second and the third element (i = 2, j = 3) will turn all numbers into 1.
*/

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            long[] arr = new long[n];

            long ones = 0;

            for (int i = 0; i < n; i++) {
                  arr[i] = sc.nextLong();
                  if (arr[i] == 1)
                        ones++;
            }

            // long ans = 0;

            /*
             * brute
             * for (int i = 0; i < n; i++) {
             * for (int j = i; j < n; j++) {
             * long[] dummy = Arrays.copyOf(arr, n);
             * 
             * for (int k = i; k <= j; k++)
             * dummy[k] = arr[k] == 0 ? 1 : 0;
             * 
             * // count all ones
             * long cnt = 0;
             * for (int k = 0; k < n; k++) {
             * cnt += dummy[k] == 1 ? 1 : 0;
             * }
             * 
             * ans = Math.max(ans, cnt);
             * }
             * }
             */

            long[] dp = new long[n];
            dp[0] = arr[0] == 0 ? 1 : -1;

            long ans = dp[0];

            for (int i = 1; i < n; i++) {
                  long gain = arr[i] == 0 ? 1 : -1;

                  dp[i] = Math.max(gain, dp[i - 1] + gain);

                  ans = Math.max(ans, dp[i]);
            }

            System.out.println(ans + ones);
            sc.close();
      }
}
