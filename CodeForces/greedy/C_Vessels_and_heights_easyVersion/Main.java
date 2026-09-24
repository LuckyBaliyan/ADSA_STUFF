package CodeForces.greedy.C_Vessels_and_heights_easyVersion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
C. Vessels, Heights and Two Versions (Easy Version)
time limit per test2 seconds
memory limit per test256 megabytes

This is the easy version of the problem. The difference between the versions is that in this version, constraints on n
 and on the number of test cases are smaller. You can hack only if you solved all versions of this problem.

There are n
 communicating vessels of infinite height arranged in a circle. The base area of each vessel is 1
 cm2
, and between the i
-th vessel and the (imodn)+1
-th vessel there is a connection of negligible volume at height hi
 cm. For each vessel i
, find the maximum total volume of water in cm3
 that can be placed in these vessels under the condition that the i
-th vessel remains empty.

Formally, you are given an array h1,h2,…,hn
. A cyclic array of non-negative integers w1,w2,…,wn
 is called good if the following holds:

For every i
 from 1
 to n
, if max(wi,wimodn+1)>hi
, then wi=wimodn+1
. In other words, if the maximum of two neighboring elements of the array w
 exceeds the corresponding element of the array h
, then these two neighboring elements of the array w
 must be equal.
For each i
 from 1
 to n
, output the maximum possible sum w1+w2+…+wn
 among all good arrays w1,w2,…,wn
, under the condition that wi=0
.

Input
Each test contains multiple test cases. The first line contains the number of test cases t
 (1≤t≤1000
). The description of the test cases follows.

The first line of each test case contains one integer n
 (3≤n≤3000
) — the number of vessels.

The second line of each test case contains n
 integers h1,h2,…,hn
 (1≤hi≤109
) — the heights of the partitions between the vessels.

It is guaranteed that the sum of n
 over all test cases does not exceed 3000
.

Output
For each test case, output n
 integers — the l
-th integer means the maximum total volume of water in cm3
 in the vessels under the condition that the l
-th vessel remains empty.

Example
InputCopy
4
4
1 2 3 4
5
5 3 1 5 2
6
3 4 2 6 1 5
7
1 2 1 4 2 3 5
OutputCopy
6 6 7 9 
17 16 14 14 17 
21 21 20 20 21 21 
17 17 17 17 21 21 22 
Note
Consider the first test case.

To keep vessel 1
 empty, one good array is w=[0,1,2,3]
, with a total of 6
 cm3
 of water.
To keep vessel 2
 empty, one good array is w=[1,0,2,3]
, with a total of 6
 cm3
 of water.
To keep vessel 3
 empty, one good array is w=[2,2,0,3]
, with a total of 7
 cm3
 of water.
To keep vessel 4
 empty, one good array is w=[3,3,3,0]
, with a total of 9
 cm3
 of water.
For example, the array w=[2,2,0,4]
 is not good, because max(w3,w4)>h3
, and therefore w3=w4
 must hold.

It can be shown that each of the arrays above has the maximum possible sum among all suitable options.


 */

public class Main {
      public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());

            while (t-- > 0) {
                  st = new StringTokenizer(br.readLine());
                  int n = Integer.parseInt(st.nextToken());

                  long[] arr = new long[n];

                  st = new StringTokenizer(br.readLine());

                  for (int i = 0; i < n; i++)
                        arr[i] = Long.parseLong(st.nextToken());

                  // brute force check the maximum water each cell can fill after gettig empted
                  for (int i = 0; i < n; i++) {
                        long[] cw = new long[n];
                        long[] ccw = new long[n];

                        long mx = 0;

                        for (int d = 1; d < n; d++) {
                              int edge = (i + d - 1) % n;

                              mx = Math.max(mx, arr[edge]);

                              cw[d] = mx;
                        }

                        mx = 0;

                        for (int d = n - 1; d >= 1; d--) {
                              int edge;

                              if (d == n - 1) {
                                    edge = (i - 1 + n) % n;
                                    mx = arr[edge];
                              } else {
                                    edge = (i + d) % n;
                                    mx = Math.max(mx, arr[edge]);
                              }
                              ccw[d] = mx;
                        }

                        long v = 0;

                        for (int d = 1; d < n; d++) {
                              v += Math.min(cw[d], ccw[d]);
                        }
                        System.out.print(v + " ");
                  }
                  System.out.println();
            }
      }
}
