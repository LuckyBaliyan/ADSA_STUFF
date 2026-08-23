package CodeForces.bruteForce.C_Kefa_And_FirstStep;

import java.util.Scanner;

public class Main {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();

            long[] arr = new long[n];

            for (int i = 0; i < n; i++)
                  arr[i] = sc.nextLong();

            long maxLen = 1;
            int len = 1;

            for (int i = 1; i < n; i++) {
                  if (arr[i] >= arr[i - 1])
                        len++;
                  else
                        len = 1;

                  maxLen = Math.max(maxLen, len);
            }

            System.out.println(maxLen);
      }
}
