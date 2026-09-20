package CodeForces.greedy.A_You_Delete_I_Delete;

import java.util.Scanner;

/* 
A. You Delete, I Delete
time limit per test1 second
memory limit per test256 megabytes
Alice and Bob are given a binary string∗
 s
 of length n
. It contains at least one 0
 and at least one 1
.

They each perform exactly one operation in the following order:

First, Alice chooses an occurrence of 0
 in s
 and deletes it.
Then, Bob chooses an occurrence of 1
 in the resulting string and deletes it.
Alice wants the final string to be lexicographically†
 as large as possible, while Bob wants it to be lexicographically as small as possible. Determine the final string if both players act optimally.

∗
A binary string is a string consisting only of the characters 0
 and 1
.

†
For two distinct binary strings a
 and b
 of the same length, a
 is lexicographically smaller than b
 if, at the first position where they differ, a
 has the smaller digit.

Input
Each test contains multiple test cases. The first line contains the number of test cases t
 (1≤t≤100
). The description of the test cases follows.

The only line of each test case contains a binary string s
 of length n
 (3≤n≤100
).

It is guaranteed that s
 contains at least one 0
 and at least one 1
.

Output
For each test case, output the final string if both players act optimally.

Example
InputCopy
4
101
11001
0010
0101010000010100100101
OutputCopy
1
101
00
01010000010100100101
Note
In the first test case, Alice must delete the only 0
. Bob may delete either occurrence of 1
, so the resulting string is 1
.

In the second test case, Alice may delete either occurrence of 0
. Bob optimally deletes one of the first two occurrences of 1
, so the resulting string is 101
.

In the third test case, Alice may delete any occurrence of 0
. Bob then deletes the only occurrence of 1
, so the resulting string is 00
.
*/

public class Main {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                  String s = sc.next();
                  int n = s.length();
                  boolean[] isDeleted = new boolean[n];

                  boolean f1 = false;
                  boolean f2 = false;

                  for (int i = 0; i < n; i++) {
                        if (s.charAt(i) == '1' && !f1) {
                              isDeleted[i] = true;
                              f1 = true;
                        } else if (s.charAt(i) == '0' && !f2) {
                              isDeleted[i] = true;
                              f2 = true;
                        }

                        if (f1 && f2)
                              break;
                  }

                  StringBuilder sb = new StringBuilder();
                  for (int i = 0; i < n; i++) {
                        if (!isDeleted[i]) {
                              sb.append(s.charAt(i));
                        }
                  }

                  System.out.println(sb.toString());
            }

            sc.close();
      }
}
