package CodeForces.bruteForce.A_Best_Card;

import java.util.Scanner;

public class Main {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                  long n = sc.nextLong();

                  boolean ok = true;

                  for (long c = 2; c < n + 1; c++) {
                        if ((n + 1) % c == 0)
                              ok = false;
                  }

                  System.out.println(ok ? "Yes" : "No");
            }

            sc.close();
      }
}
