package CodeForces.Graphs.E_Polygon;

import java.util.Scanner;

public class Main {
      static Character[][] polygon;
      static Boolean[][] dp;

      public static String solve(int n) {

            // skip boundary cells
            for (int i = 0; i < n - 1; i++) {
                  for (int j = 0; j < n - 1; j++) {
                        // check for each 1
                        if (polygon[i][j] == '1' && !dfs(i, j, n))
                              return "NO";
                  }
            }

            return "YES";
      }

      public static boolean dfs(int i, int j, int n) {
            // already good right and bottom boundary elements
            if (i == n - 1 || j == n - 1)
                  return true;

            // Memoized solution
            if (dp[i][j] != null)
                  return dp[i][j];

            boolean up = false;
            boolean down = false;

            // The | operator is a special operator will work same as || but checks both
            // values i.e see
            // both true | false => true but cehcks both instead of stopping at once
            if (i + 1 < n && polygon[i + 1][j] == '1') {
                  up = dfs(i + 1, j, n);
            }

            if (j + 1 < n && polygon[i][j + 1] == '1') {
                  down = dfs(i, j + 1, n);
            }

            // save the current solution to avoid recomputation in overlapping
            return dp[i][j] = up || down;
      }

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();
            while (t-- > 0) {

                  int n = sc.nextInt();

                  polygon = new Character[n][n];
                  dp = new Boolean[n][n];

                  for (int i = 0; i < n; i++) {
                        String s = sc.next();
                        for (int j = 0; j < n; j++) {
                              polygon[i][j] = s.charAt(j);
                        }
                  }

                  String res = solve(n);

                  System.out.println(res);
            }

            sc.close();
      }

}
