package CodeForces.DP.C_Unintresting_Number;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
      static int[][] dp;

      public static boolean solve(String s, int idx, int rem) {
            if (idx == s.length()) {
                  return rem == 0;
            }

            if (dp[idx][rem] != -1)
                  return dp[idx][rem] == 1 ? true : false;

            int dig = s.charAt(idx) - '0';

            // keep the current digit
            boolean skip = solve(s, idx + 1, (rem + dig) % 9);

            // only apply opr if it is 2,3
            boolean take = false;

            if (dig == 2 || dig == 3) {
                  long square = dig * dig;
                  take = take || solve(s, idx + 1, (int) (rem + square) % 9);
            }

            boolean res = skip || take;
            dp[idx][rem] = res ? 1 : 0;

            return res;
      }

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();

            while (t-- > 0) {
                  String num = sc.next();
                  dp = new int[num.length()][10];

                  for (int i = 0; i < num.length(); i++) {
                        Arrays.fill(dp[i], -1);
                  }

                  System.out.println(solve(num, 0, 0) ? "YES" : "NO");
            }

            sc.close();
      }
}
