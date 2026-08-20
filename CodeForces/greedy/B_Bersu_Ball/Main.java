package CodeForces.greedy.B_Bersu_Ball;

import java.lang.reflect.Array;

/*
B. BerSU Ball
time limit per test1 second
memory limit per test256 megabytes

The Berland State University is hosting a ballroom dance in celebration of its 100500-th anniversary! n boys and m girls are already busy rehearsing waltz, minuet, polonaise and quadrille moves.

We know that several boy&girl pairs are going to be invited to the ball. However, the partners' dancing skill in each pair must differ by at most one.

For each boy, we know his dancing skills. Similarly, for each girl we know her dancing skills. Write a code that can determine the largest possible number of pairs that can be formed from n boys and m girls.

Input
The first line contains an integer n (1 ≤ n ≤ 100) — the number of boys. The second line contains sequence a1, a2, ..., an (1 ≤ ai ≤ 100), where ai is the i-th boy's dancing skill.

Similarly, the third line contains an integer m (1 ≤ m ≤ 100) — the number of girls. The fourth line contains sequence b1, b2, ..., bm (1 ≤ bj ≤ 100), where bj is the j-th girl's dancing skill.

Output
Print a single number — the required maximum possible number of pairs.

Examples
InputCopy
4
1 4 6 2
5
5 1 5 7 9
OutputCopy
3
InputCopy
4
1 2 3 4
4
10 11 12 13
OutputCopy
0
InputCopy
5
1 1 1 1 1
3
1 2 3
OutputCopy
2
*/

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
      static long[][] dp;

      public static long getAns(Long[] boys, Long[] girls, int n, int m) {
            dp = new long[n][m];
            for (long[] d : dp)
                  Arrays.fill(d, -1);

            return solve(boys, girls, n, m, 0, 0);
      }

      public static long solve(Long[] boys, Long[] girls, int n, int m, int i, int j) {
            if (i == n || j == m)
                  return 0;
            if (dp[i][j] != -1)
                  return dp[i][j];

            long skipBoy = solve(boys, girls, n, m, i + 1, j);

            long skipGirl = solve(boys, girls, n, m, i, j + 1);

            long take = 0;

            if (Math.abs(boys[i] - girls[j]) <= 1) {
                  take = 1 + solve(boys, girls, n, m, i + 1, j + 1);
            }

            return dp[i][j] = Math.max(take, Math.max(skipBoy, skipGirl));
      }

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            Long[] boys = new Long[n];

            for (int i = 0; i < n; i++)
                  boys[i] = sc.nextLong();

            int m = sc.nextInt();
            Long[] girls = new Long[m];

            for (int i = 0; i < m; i++)
                  girls[i] = sc.nextLong();

            Arrays.sort(boys, Collections.reverseOrder());
            Arrays.sort(girls, Collections.reverseOrder());

            // greedy approach
            /*
             * long ans = 0;
             * int b = 0;
             * int g = 0;
             * 
             * while (b < n && g < m) {
             * if (Math.abs(girls[g] - boys[b]) <= 1) {
             * ans++;
             * b++;
             * g++;
             * } else if (girls[g] - boys[b] > 1)
             * g++;
             * else
             * b++;
             * }
             * 
             * System.out.println(ans);
             */

            // dp
            System.out.println(getAns(boys, girls, n, m));

            sc.close();
      }
}
