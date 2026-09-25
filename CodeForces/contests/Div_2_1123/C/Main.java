package CodeForces.contests.Div_2_1123.C;

import java.util.*;

public class Main {

      static long getSum(int d, long[] sum) {

            long ans = 0;

            for (int v = d; v < sum.length; v += d) {
                  ans += sum[v];
            }

            return ans;
      }

      public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {

                  int n = sc.nextInt();
                  int x = sc.nextInt();

                  long[] sum = new long[300001];

                  for (int i = 0; i < n; i++) {
                        int a = sc.nextInt();
                        sum[a] += a;
                  }

                  long ans = 0;

                  if (x > 1) {

                        for (int d = 2; d * d <= x; d++) {

                              if (x % d == 0) {

                                    ans = Math.max(ans, getSum(d, sum));

                                    if (d * d != x) {
                                          ans = Math.max(ans, getSum(x / d, sum));
                                    }
                              }
                        }

                        ans = Math.max(ans, getSum(x, sum));
                  }

                  System.out.println(ans);
            }

            sc.close();
      }
}
