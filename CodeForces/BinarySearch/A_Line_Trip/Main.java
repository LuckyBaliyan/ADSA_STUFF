package CodeForces.BinarySearch.A_Line_Trip;

import java.util.Scanner;

public class Main {
      public static boolean canReach(int[] line, int n, int x, int volume) {
            if (line[0] > volume)
                  return false;

            for (int i = 1; i < n; i++) {
                  if ((line[i] - line[i - 1]) > volume)
                        return false;
            }

            if (x - line[n - 1] > volume)
                  return false;

            int rem = volume - (x - line[n - 1]);

            if ((x - line[n - 1]) > rem)
                  return false;

            return true;
      }

      public static int getMinVol(int[] line, int n, int x) {
            int l = 1;
            int r = 2 * x;

            int ans = r;

            while (l <= r) {
                  int mid = l + (r - l) / 2;

                  if (canReach(line, n, x, mid)) {
                        r = mid - 1;
                        ans = mid;
                  } else {
                        l = mid + 1;
                  }
            }

            return ans;
      }

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                  int n = sc.nextInt();
                  int x = sc.nextInt();

                  int[] line = new int[n];

                  for (int i = 0; i < n; i++) {
                        line[i] = sc.nextInt();
                  }

                  System.out.println(getMinVol(line, n, x));
            }

            sc.close();
      }
}
