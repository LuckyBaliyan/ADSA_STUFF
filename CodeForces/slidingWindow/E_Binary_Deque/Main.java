package CodeForces.slidingWindow.E_Binary_Deque;

import java.util.Scanner;

public class Main {
      public static long getMinOpr(long[] arr, int n, long s) {
            int left = 0;
            int right = 0;

            int maxLen = 0;
            int sum = 0;

            while (right < n) {
                  sum += arr[right];

                  while (sum > s) {
                        sum -= arr[left];
                        left++;
                  }

                  if (sum == s) {
                        maxLen = Math.max(maxLen, right - left + 1);
                  }

                  right++;
            }

            return n - maxLen;
      }

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                  int N = sc.nextInt();
                  long S = sc.nextLong();

                  long[] arr = new long[N];
                  int onse = 0;

                  for (int i = 0; i < N; i++) {
                        arr[i] = sc.nextLong();
                        onse += arr[i];
                  }

                  if (onse < S) {
                        System.out.println(-1);
                        continue;
                  }

                  System.out.println(getMinOpr(arr, N, S));
            }

            sc.close();
      }
}
