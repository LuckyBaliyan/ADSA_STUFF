//package CodeForces.DP.F_Consicutive_Subsequence;

import java.util.Scanner;

public class Main {
    static int[][] dp;

    public static int solve(int[] arr, int n) {
        dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int prev = i - 1; prev >= -1; prev--) {
                int take = 0;
                int skip = dp[i + 1][prev + 1]; // just down cell

                if (prev == -1 || arr[i] == arr[prev] + 1) {
                    take = 1 + dp[i + 1][i + 1];
                }

                dp[i][prev + 1] = Math.max(take, skip);
            }
        }

        return dp[0][0];
    }

    static void getPath(int[] arr) {
        int n = arr.length;

        int i = 0;
        int prev = -1;

        while (i < n) {

            int take = 0;
            if (prev == -1 || arr[i] == arr[prev] + 1) {
                take = 1 + dp[i + 1][i + 1];
            }


            if ((prev == -1 || arr[i] == arr[prev] + 1)
                    && dp[i][prev + 1] == take) {

                System.out.print((i + 1) + " "); // 1-based index
                prev = i;
            }

            i++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = solve(arr, n);
        System.out.println(ans);

        getPath(arr);

        sc.close();
    }
}
