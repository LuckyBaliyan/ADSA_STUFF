package CodeForces.DP.C_Long_Jumps;

import java.util.Scanner;

public class Main {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                  int n = sc.nextInt();
                  long[] arr = new long[n + 1];

                  for (int i = 1; i <= n; i++) {
                        arr[i] = sc.nextLong();
                  }

                  long[] dp = new long[n + 1];

                  long maxScore = Long.MIN_VALUE;

                  for (int i = n; i >= 1; i--) {
                        long next = i + arr[i];

                        if (next > n) {
                              dp[i] = arr[i];
                        } else
                              dp[i] = arr[i] + dp[(int) (i + arr[i])];

                        maxScore = Math.max(maxScore, dp[i]);
                  }

                  System.out.println(maxScore);
            }

            sc.close();
      }
}
