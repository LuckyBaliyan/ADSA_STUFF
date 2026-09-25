package CodeForces.contests.Div_2_1123.A;

import java.util.Scanner;

public class Main {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                  int n = sc.nextInt();
                  String ch = sc.next();

                  char c = ch.charAt(0);

                  String s = sc.next();

                  int ans = 0;

                  int left = 0;
                  int right = n - 1;

                  while (left <= right) {
                        if (s.charAt(left) != s.charAt(right)) {
                              if (s.charAt(left) != c)
                                    ans++;
                              if (s.charAt(right) != c)
                                    ans++;
                        }

                        left++;
                        right--;
                  }

                  System.out.println(ans);
            }

            sc.close();
      }
}
