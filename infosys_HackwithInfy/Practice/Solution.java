package infosys_HackwithInfy.Practice;

/*import java.util.*;


public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int N = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int Z = sc.nextInt();

        long[] A = new long[N];
        for (int i = 0; i < N; i++) A[i] = sc.nextLong();
        long[] B = new long[N];
        for (int i = 0; i < N; i++) B[i] = sc.nextLong();

        long MOD = 1000000007L;
        long INF = Long.MIN_VALUE / 2;

        long[][] dp = new long[X + 1][Y + 1];
        for (long[] row : dp) Arrays.fill(row, INF);
        
        dp[0][0] = 0;

        for (int i = 0; i < N; i++) {
            long[][] nextDp = new long[X + 1][Y + 1];
            for (long[] row : nextDp) Arrays.fill(row, INF);

            for (int j = 0; j <= Math.min(i, X); j++) {
                for (int k = 0; k <= Math.min(i - j, Y - j); k++) {
                    if (dp[j][k] == INF) continue;

                    int currentX = X - j;
                    int currentY = Y - (j + k);
                    int currentZ = Z - k;

                    nextDp[j][k] = Math.max(nextDp[j][k], dp[j][k] - B[i]);

                    if (currentX > 0 && currentY > 0) {
                        long val = A[i] * (currentX - 1) * (currentY - 1) * currentZ;
                        nextDp[j + 1][k] = Math.max(nextDp[j + 1][k], dp[j][k] + val);
                    }

                    if (currentY > 0 && currentZ > 0) {
                        long val = A[i] * currentX * (currentY - 1) * (currentZ - 1);
                        nextDp[j][k + 1] = Math.max(nextDp[j][k + 1], dp[j][k] + val);
                    }
                }
            }
            dp = nextDp;
        }

        long maxRes = INF;
        for (int j = 0; j <= X; j++) {
            for (int k = 0; k <= Y; k++) {
                maxRes = Math.max(maxRes, dp[j][k]);
            }
        }

        System.out.println((maxRes % MOD + MOD) % MOD);
    }
}
    */

import java.util.*;
import java.io.*;

public class Solution {
    static final long MOD = 1_000_000_007L;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        long X = Long.parseLong(br.readLine().trim());
        long Y = Long.parseLong(br.readLine().trim());
        long Z = Long.parseLong(br.readLine().trim());
        long[] A = new long[n + 1];
        long[] B = new long[n + 1];
        for (int i = 1; i <= n; i++) A[i] = Long.parseLong(br.readLine().trim());
        for (int i = 1; i <= n; i++) B[i] = Long.parseLong(br.readLine().trim());

        int maxA = (int) Math.min(X, Math.min(Y, n));
        int maxB = (int) Math.min(Z, Math.min(Y, n));

        long NEG_INF = Long.MIN_VALUE / 2;
        long[][] dp = new long[maxA + 1][maxB + 1];
        for (long[] row : dp) Arrays.fill(row, NEG_INF);
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            long[][] ndp = new long[maxA + 1][maxB + 1];
            for (long[] row : ndp) Arrays.fill(row, NEG_INF);
            for (int a = 0; a <= Math.min(i, maxA); a++) {
                for (int b = 0; b <= Math.min(i, maxB); b++) {
                    if (a + b > i) continue;
                    if (a + b > Y) continue;
                    if (dp[a][b] == NEG_INF) continue;
                    // op type 1
                    long v1 = dp[a][b] - B[i];
                    if (v1 > ndp[a][b]) ndp[a][b] = v1;
                    // op type 2: use (a+1)-th type2, (b)-th type3
                    if (a + 1 <= maxA && a + b + 1 <= (int)Y) {
                        long nx = X - (a + 1);
                        long ny = Y - (a + 1) - b;
                        long nz = Z - b;
                        if (nx >= 0 && ny >= 0 && nz >= 0) {
                            long v2 = dp[a][b] + A[i] * nx % MOD * ny % MOD * nz % MOD;
                            if (v2 > ndp[a + 1][b]) ndp[a + 1][b] = v2;
                        }
                    }
                    // op type 3: use (a)-th type2, (b+1)-th type3
                    if (b + 1 <= maxB && a + b + 1 <= (int)Y) {
                        long nx = X - a;
                        long ny = Y - a - (b + 1);
                        long nz = Z - (b + 1);
                        if (nx >= 0 && ny >= 0 && nz >= 0) {
                            long v3 = dp[a][b] + A[i] * nx % MOD * ny % MOD * nz % MOD;
                            if (v3 > ndp[a][b + 1]) ndp[a][b + 1] = v3;
                        }
                    }
                }
            }
            dp = ndp;
        }

        long ans = Long.MIN_VALUE / 2;
        for (int a = 0; a <= maxA; a++)
            for (int b = 0; b <= maxB; b++)
                if (dp[a][b] != NEG_INF && dp[a][b] > ans)
                    ans = dp[a][b];

        System.out.println(((ans % MOD) + MOD) % MOD);
    }
}