package CodeForces.prefixSum.B_Kuriyama_Mirais_Stones;

import java.util.Arrays;
import java.util.Scanner;

/*
B. Kuriyama Mirai's Stones
time limit per test2 seconds
memory limit per test256 megabytes
Kuriyama Mirai has killed many monsters and got many (namely n) stones. She numbers the stones from 1 to n. The cost of the i-th stone is vi. Kuriyama Mirai wants to know something about these stones so she will ask you two kinds of questions:

She will tell you two numbers, l and r (1 ≤ l ≤ r ≤ n), and you should tell her .
Let ui be the cost of the i-th cheapest stone (the cost that will be on the i-th place if we arrange all the stone costs in non-decreasing order). This time she will tell you two numbers, l and r (1 ≤ l ≤ r ≤ n), and you should tell her .
For every question you should give the correct answer, or Kuriyama Mirai will say "fuyukai desu" and then become unhappy.

Input
The first line contains an integer n (1 ≤ n ≤ 105). The second line contains n integers: v1, v2, ..., vn (1 ≤ vi ≤ 109) — costs of the stones.

The third line contains an integer m (1 ≤ m ≤ 105) — the number of Kuriyama Mirai's questions. Then follow m lines, each line contains three integers type, l and r (1 ≤ l ≤ r ≤ n; 1 ≤ type ≤ 2), describing a question. If type equal to 1, then you should output the answer for the first question, else you should output the answer for the second one.

Output
Print m lines. Each line must contain an integer — the answer to Kuriyama Mirai's question. Print the answers to the questions in the order of input.

Examples
InputCopy
6
6 4 2 7 2 7
3
2 3 6
1 3 4
1 1 6
OutputCopy
24
9
28
InputCopy
4
5 5 2 3
10
1 2 4
2 1 4
1 1 1
2 1 4
2 1 2
1 1 1
1 3 3
1 1 3
1 4 4
1 2 2
OutputCopy
10
15
5
15
5
5
2
12
3
5
Note
Please note that the answers to the questions may overflow 32-bit integer type.

*/

public class Main {
      static long[] vi;
      static long[] prefix;
      static long[] prefixSorted;

      public static void precompute(int n) {
            prefix = new long[n];
            prefixSorted = new long[n];
            prefix[0] = vi[0];

            for (int i = 1; i < n; i++)
                  prefix[i] = prefix[i - 1] + vi[i];

            Arrays.sort(vi);

            prefixSorted[0] = vi[0];

            for (int i = 1; i < n; i++)
                  prefixSorted[i] = vi[i] + prefixSorted[i - 1];
      }

      public static long query(long[] arr, int l, int r) {
            if (l == 0)
                  return arr[r];
            return arr[r] - arr[l - 1];
      }

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            vi = new long[n];

            for (int i = 0; i < n; i++)
                  vi[i] = sc.nextLong();

            precompute(n);

            int m = sc.nextInt();

            for (int i = 0; i < m; i++) {
                  int type = sc.nextInt();
                  int l = sc.nextInt();
                  int r = sc.nextInt();

                  long res = 0;

                  if (type == 1) {
                        res = query(prefix, l - 1, r - 1);
                  } else
                        res = query(prefixSorted, l - 1, r - 1);

                  System.out.println(res);

            }

            sc.close();
      }
}
