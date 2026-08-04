package CSES_Problem.dp.ArrayDescription;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
      static int ans;
      static long dp[][];
      static final long MOD = 1_000_000_007;

      public static long solve(long[] arr, int n, int m) {
            ans = 0;
            return solveRec(arr, -1, 0, m);
      }

      public static long solveRec(long[] arr, long prev, int idx, int lim) {
            if (idx == arr.length)
                  return 1;

            if (dp[idx][(int) prev + 1] != -1)
                  return dp[idx][(int) prev + 1];

            if (arr[idx] == 0) {

                  long ways = 0;
                  // Just optimized version of writting of this the simple loop i think
                  if (prev == -1) {
                        for (int i = 1; i <= lim; i++) {
                              ways = (ways + solveRec(arr, i, idx + 1, lim)) % MOD;
                        }
                  } else {
                        for (long x = Math.max(1, prev - 1); x <= Math.min(lim, prev + 1); x++) {
                              ways = (ways + solveRec(arr, x, idx + 1, lim)) % MOD;
                        }
                  }

                  return dp[idx][(int) prev + 1] = ways;
            } else {
                  if (prev == -1 || Math.abs(prev - arr[idx]) <= 1)
                        return dp[idx][(int) prev + 1] = solveRec(arr, arr[idx], idx + 1, lim);

                  return dp[idx][(int) prev + 1] = 0;
            }
      }

      public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long[] arr = new long[n];
            dp = new long[n][m + 2]; // m--> 100

            for (long[] d : dp)
                  Arrays.fill(d, -1);

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                  arr[i] = Long.parseLong(st.nextToken());
            }

            System.out.println(solve(arr, n, m));
      }
}
