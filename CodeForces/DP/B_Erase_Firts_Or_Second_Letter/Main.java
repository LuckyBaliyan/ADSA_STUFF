package CodeForces.DP.B_Erase_Firts_Or_Second_Letter;

import java.util.*;

public class Main {

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                  int n = sc.nextInt();
                  String s = sc.next();

                  long ans = 0;

                  // Number of distinct characters that have appeared
                  // before the current position.
                  boolean[] seen = new boolean[26];

                  for (int i = 0; i < n; i++) {
                        if (!seen[s.charAt(i) - 'a']) {
                              seen[s.charAt(i) - 'a'] = true;

                              // For this first character we can create
                              // strings of lengths 1 ... (n - i)
                              ans += n - i;
                        }
                  }

                  System.out.println(ans);
            }

            sc.close();
      }
}
