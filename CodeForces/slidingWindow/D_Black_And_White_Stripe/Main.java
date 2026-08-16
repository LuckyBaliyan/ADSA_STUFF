package CodeForces.slidingWindow.D_Black_And_White_Stripe;

/*
D. Black and White Stripe
time limit per test2 seconds
memory limit per test256 megabytes
You have a stripe of checkered paper of length n
. Each cell is either white or black.

What is the minimum number of cells that must be recolored from white to black in order to have a segment of k
 consecutive black cells on the stripe?

If the input data is such that a segment of k
 consecutive black cells already exists, then print 0.

Input
The first line contains an integer t
 (1≤t≤104
) — the number of test cases.

Next, descriptions of t
 test cases follow.

The first line of the input contains two integers n
 and k
 (1≤k≤n≤2⋅105
). The second line consists of the letters 'W' (white) and 'B' (black). The line length is n
.

It is guaranteed that the sum of values n
 does not exceed 2⋅105
.

Output
For each of t
 test cases print an integer — the minimum number of cells that need to be repainted from white to black in order to have a segment of k
 consecutive black cells.

Example
InputCopy
4
5 3
BBWBW
5 5
BBWBW
5 1
BBWBW
1 1
W
OutputCopy
1
2
0
1
Note
In the first test case, s
="BBWBW" and k=3
. It is enough to recolor s3
 and get s
="BBBBW". This string contains a segment of length k=3
 consisting of the letters 'B'.

In the second test case of the example s
="BBWBW" and k=5
. It is enough to recolor s3
 and s5
 and get s
="BBBBB". This string contains a segment of length k=5
 consisting of the letters 'B'.

In the third test case of the example s
="BBWBW" and k=1
. The string s
 already contains a segment of length k=1
 consisting of the letters 'B'.
 */

import java.util.Scanner;

public class Main {

      public static int getMinOpr(String s, int n, int k) {
            int ans = Integer.MAX_VALUE;

            if (n == 1) {
                  return (k == 1 && s.charAt(0) != 'B') ? 1 : 0;
            }

            int left = 0;
            int right = 0;
            int opr = 0;

            while (right < n) {
                  if (s.charAt(right) != 'B')
                        opr++;

                  if ((right - left + 1) == k) {
                        ans = Math.min(ans, opr);

                        if (s.charAt(left) != 'B')
                              opr--;

                        left++;
                  }

                  right++;
            }

            return ans;
      }

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                  int n = sc.nextInt();
                  int k = sc.nextInt();

                  String stripe = sc.next();

                  System.out.println(getMinOpr(stripe, n, k));
            }

            sc.close();
      }
}
