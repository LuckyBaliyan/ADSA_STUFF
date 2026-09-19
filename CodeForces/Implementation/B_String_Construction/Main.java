package CodeForces.Implementation.B_String_Construction;

import java.util.Scanner;

/*B. String Construction
time limit per test1 second
memory limit per test256 megabytes

You are given two integers n
 and k
.

Construct a binary string∗
 s
 of length n
, such that both of the following conditions hold:

The absolute difference between the number of characters 0
 and the number of characters 1
 in s
 is at most 1
.
There are exactly k
 pairs of adjacent equal characters in s
. Formally, there are exactly k
 indices i
 (1≤i≤n−1
) satisfying si=si+1
.
Or determine that no such string exists.

∗
A binary string is a string where each character is either 0
 or 1
.

Input
Each test contains multiple test cases. The first line contains the number of test cases t
 (1≤t≤1000
). The description of the test cases follows.

The only line of each test case contains two integers n
 and k
 (2≤n≤2⋅105
, 0≤k≤n−1
).

It is guaranteed that the sum of n
 over all test cases does not exceed 2⋅105
.

Output
For each test case, output a binary string s
 of length n
 — the string you constructed. Print −1
 if such a string does not exist.

If there are multiple answers, you may output any of them.

Example
InputCopy
8
5 2
4 3
6 1
5 0
7 3
4 2
3 2
7 4
OutputCopy
01110
-1
101001
01010
0100011
0011
-1
0111000
Note
In the first test case, one possible answer is s=01110
. It contains three characters 1
 and two characters 0
, and there are exactly 2
 adjacent equal pairs in s
: (s2,s3)
 and (s3,s4)
.

In the second test case, k=n−1
. All characters in s
 should be equal, so the numbers of characters 0
 and 1
 could not differ by at most 1
. Thus, the answer is −1
.

In the third test case, note that 010110
 is also a possible answer. */

public class Main {

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                  int n = sc.nextInt();
                  int k = sc.nextInt();

                  int r = n - k;

                  if (r == 1) {
                        System.out.println(-1);
                        continue;
                  }

                  int zeros = (n + 1) / 2;
                  int ones = n / 2;

                  int zeroBlocks = (r + 1) / 2;
                  int oneBlocks = r / 2;

                  int extraZeros = zeros - zeroBlocks;
                  int extraOnes = ones - oneBlocks;

                  StringBuilder sb = new StringBuilder();

                  for (int i = 0; i < r; i++) {
                        if (i % 2 == 0) {
                              sb.append('0');

                              if (i == 0) {
                                    for (int j = 0; j < extraZeros; j++) {
                                          sb.append('0');
                                    }
                              }
                        } else {
                              sb.append('1');

                              if (i == 1) {
                                    for (int j = 0; j < extraOnes; j++) {
                                          sb.append('1');
                                    }
                              }
                        }
                  }

                  System.out.println(sb.toString());
            }

            sc.close();
      }

}
