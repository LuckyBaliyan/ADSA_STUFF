package infosys_HackwithInfy.Practice;


import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int N = sc.nextInt();
        long[] L = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            L[i] = sc.nextLong();
        }

        long INF = Long.MAX_VALUE / 2;
        int offset = N; 
        long[][] dp = new long[N + 1][2 * N + 1];

        for (long[] row : dp) Arrays.fill(row, INF);

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (L[i] == L[j]) continue;

                long cost = Math.abs(L[i] - L[j]);
                int parity = (cost % 2 == 0) ? 1 : -1;

                dp[i][offset + parity] = Math.min(dp[i][offset + parity], cost);

                for (int prev = 1; prev < j; prev++) {
                    for (int d = 0; d <= 2 * N; d++) {
                        if (dp[prev][d] != INF) {
                            int nextD = d + parity;
                            if (nextD >= 0 && nextD <= 2 * N) {
                                dp[i][nextD] = Math.min(dp[i][nextD], dp[prev][d] + cost);
                            }
                        }
                    }
                }
            }
        }

        long minSum = INF;
        for (int i = 1; i <= N; i++) {
            for (int d = offset; d <= 2 * N; d++) {
                minSum = Math.min(minSum, dp[i][d]);
            }
        }

        System.out.println(minSum >= INF ? -1 : minSum);
    }
}