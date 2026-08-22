package CodeForces.greedy.D_Test_Of_Love;

/*
D. Test of Love
time limit per test2 seconds
memory limit per test256 megabytes
ErnKor is ready to do anything for Julen, even to swim through crocodile-infested swamps. We decided to test this love. ErnKor will have to swim across a river with a width of 1
 meter and a length of n
 meters.

The river is very cold. Therefore, in total (that is, throughout the entire swim from 0
 to n+1
) ErnKor can swim in the water for no more than k
 meters. For the sake of humanity, we have added not only crocodiles to the river, but also logs on which he can jump. Our test is as follows:

Initially, ErnKor is on the left bank and needs to reach the right bank. They are located at the 0
 and n+1
 meters respectively. The river can be represented as n
 segments, each with a length of 1
 meter. Each segment contains either a log 'L', a crocodile 'C', or just water 'W'. ErnKor can move as follows:

If he is on the surface (i.e., on the bank or on a log), he can jump forward for no more than m
 (1≤m≤10
) meters (he can jump on the bank, on a log, or in the water).
If he is in the water, he can only swim to the next river segment (or to the bank if he is at the n
-th meter).
ErnKor cannot land in a segment with a crocodile in any way.
Determine if ErnKor can reach the right bank.

Input
The first line contains a single integer t
 (1≤t≤104
)  — the number of test cases.

The first line of each test case contains three numbers n,m,k
 (0≤k≤2⋅105
, 1≤n≤2⋅105
, 1≤m≤10
) — the length of the river, the distance ErnKor can jump, and the number of meters ErnKor can swim without freezing.

The second line of each test case contains a string a
 of length n
. ai
 denotes the object located at the i
-th meter. (ai∈{
'W','C','L'}
)

It is guaranteed that the sum of n
 over all test cases does not exceed 2⋅105
.

Output
For each test case, output "YES" if ErnKor can pass the test, and output "NO" otherwise.

You can output the answer in any case (upper or lower). For example, the strings "yEs", "yes", "Yes", and "YES" will be recognized as positive responses.

Example
InputCopy
6
6 2 0
LWLLLW
6 1 1
LWLLLL
6 1 1
LWLLWL
6 2 15
LWLLCC
6 10 0
CCCCCC
6 6 1
WCCCCW
OutputCopy
YES
YES
NO
NO
YES
YES
Note
Let's consider examples:

First example: We jump from the shore to the first log (0→1
), from the first log to the second (1→3
), from the second to the fourth (3→5
), and from the last log to the shore (5→7
). So, we have 0→1→3→5→7
. Since we did not encounter a crocodile and swam no more than k meters, the answer is «YES».
Second example: 0→1
, we jump into the water from the first log (1→2
), swim a cell to the log (2⇝3
), 3→4→5→6→7
. Since we did not encounter a crocodile and swam no more than k meters, the answer is «YES».
In the third example, ErnKor needs to swim two cells 'W', but can only swim one. Therefore, the answer is «NO».
Sixth example: We jump from the shore into the water (0→6
) and swim one cell in the water (6⇝7
). Since we did not encounter a crocodile and swam no more than k meters, the answer is «YES».

*/
import java.util.Scanner;

public class Main {
      // static long originalM;

      /*
       * static long[][] dp;
       * 
       * public static boolean canReach(String s, long n, long m, long k) {
       * originalM = m;
       * 
       * dp = new long[(int) n][(int) k];
       * 
       * for (long[] d : dp)
       * Arrays.fill(d, -1);
       * 
       * return solve(s, n, m, k, 0);
       * }
       * 
       * private static boolean solve(String s, long n, long m, long k, long idx) {
       * if (idx >= n || k < 0 || s.charAt((int) idx) == 'C')
       * return false;
       * 
       * if (idx == n - 1) {
       * return true;
       * }
       * 
       * if (dp[(int) idx][(int) k] != -1)
       * return dp[(int) idx][(int) k] == 0 ? false : true;
       * 
       * // if we land on water we can move to next section as long we have a +ve
       * value
       * // of k
       * // reset the jumps as well
       * boolean move1 = false;
       * 
       * boolean move2 = false;
       * 
       * if (idx == 0 || s.charAt((int) idx) == 'L') {
       * for (int j = 1; j <= m; j++) {
       * // taking the logs
       * // here the bug was that at j = 1 move2 is false the at j = 2 move is true
       * // but if at j = 3 move2 = false which will overwrite move2 completely
       * 
       * move2 = move2 || solve(s, n, m, k, idx + j);
       * }
       * } else
       * move1 = solve(s, n, m, k - 1, idx + 1);
       * 
       * dp[(int) idx][(int) k] = (move1 || move2) ? 1 : 0;
       * 
       * return dp[(int) idx][(int) k] == 0 ? false : true;
       * }
       * 
       */

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                  long n = sc.nextLong();
                  long m = sc.nextLong();
                  long k = sc.nextLong();

                  String segments = sc.next();

                  StringBuilder sb = new StringBuilder();
                  sb.append("L").append(segments).append("L");

                  // boolean res = canReach(sb.toString(), n + 2, m, k);

                  /*
                   * *if (res) {
                   * System.out.println("YES");
                   * continue;
                   * }
                   * 
                   * System.out.println("NO");
                   */

                  // greedy
                  String river = sb.toString();
                  long swims = 0;
                  boolean ans = true;

                  int i = 0;

                  while (i < river.length()) {
                        if (river.charAt(i) == 'L') {
                              // find the next L distance
                              int nx = i + 1;

                              while (nx < river.length() && river.charAt(nx) != 'L')
                                    nx++;

                              if (nx - i <= m)
                                    i = nx;
                              else
                                    i = (int) (i + m);
                        } else if (river.charAt(i) == 'W') {
                              swims++;
                              i++;
                        }

                        if (i >= river.length())
                              break;

                        if (river.charAt(i) == 'C') {
                              ans = false;
                              break;
                        }
                  }

                  String res = ans && swims <= k ? "YES" : "NO";

                  System.out.println(res);
            }

            sc.close();
      }
}
