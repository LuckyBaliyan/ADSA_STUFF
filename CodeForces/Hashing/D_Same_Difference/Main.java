package CodeForces.Hashing.D_Same_Difference;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                  int n = sc.nextInt();
                  long[] arr = new long[n];

                  for (int i = 0; i < n; i++)
                        arr[i] = sc.nextLong();

                  HashMap<Long, Long> map = new HashMap<>();

                  // eq:- aj - ai = j - i ==> ai - i = aj - j
                  long ans = 0;

                  for (int i = 0; i < n; i++) {
                        ans += map.getOrDefault(arr[i] - i, (long) 0);
                        map.put(arr[i] - i, map.getOrDefault(arr[i] - i, (long) 0) + 1);
                  }

                  System.out.println(ans);
            }

            sc.close();
      }
}
