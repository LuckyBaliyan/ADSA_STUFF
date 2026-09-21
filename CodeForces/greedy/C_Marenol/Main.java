package CodeForces.greedy.C_Marenol;

/*
C1. Marenol (easy version)
time limit per test2 seconds
memory limit per test256 megabytes
This is the easy version of the problem. In this version, you are only asked to determine whether string a
 can be transformed into string b
.

Yousef has given you two binary strings, a
 and b
, of the same length n
.

You are allowed to perform any of the following operations:

Choose a substring∗
 in a
 equal to 001
 and replace it with 100
, or vice versa (i.e., 001→100
 or 100→001
).
Choose a substring in a
 equal to 110
 and replace it with 011
, or vice versa (i.e., 011→110
 or 110→011
).
Your task is to determine whether it is possible to transform string a
 into string b
 using a finite number of operations.

∗
A string a
 is a substring of a string b
 if a
 can be obtained from b
 by deletion of several (possibly zero or all) characters from the beginning and several (possibly zero or all) characters from the end.

Input
The first line contains a single integer t
 (1≤t≤104
) — the number of test cases.

The first line of each test case contains a single integer n
 (1≤n≤2⋅105
) — the length of each string.

The second line of each test case contains a binary string a
 (|a|=n
), consisting of only characters 0
 and/or 1
.

The third line of each test case contains a binary string b
 (|b|=n
), consisting of only characters 0
 and/or 1
.

It is guaranteed that the sum of n
 over all test cases does not exceed 2⋅105
.

Output
For each test case, output "YES" if the string a
 can be transformed into string b
 using a finite number of operations, and "NO" otherwise.

You can output the answer in any case (upper or lower). For example, the strings "yEs", "yes", "Yes", and "YES" will be recognized as positive responses.

Example
InputCopy
9
1
0
0
2
01
10
3
001
100
4
1010
0101
4
1100
1000
5
01001
10010
6
110000
000011
6
111000
000111
7
1001100
0000111
OutputCopy
YES
NO
YES
NO
NO
YES
YES
NO
YES
Note
In the first test case, it already holds that a=b
. Therefore, the answer is YES.

In the second test case, we cannot perform any operation. Since a≠b
, the answer is NO.

In the third test case, we can choose the substring a[1,3]=001
 and replace it with 100
, making a=b
. Therefore, the answer is YES.

In the seventh test case, we can do the following in order:

1
100
00
 →
 1
001
00
100
100
 →
 100
001
100
001
 →
 001
001
00
100
1
 →
 00
001
1
Therefore, the answer is YES.
*/

import java.util.Scanner;

public class Main {

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                  int n = sc.nextInt();

                  String a = sc.next();
                  String b = sc.next();

                  int[] cnta = new int[2];
                  int[] cntb = new int[2];

                  for (int i = 0; i < n; i++) {
                        cnta[i % 2] += (a.charAt(i) == '1') ? 1 : 0;
                        cntb[i % 2] += (b.charAt(i) == '1') ? 1 : 0;
                  }

                  if ((cnta[0] == cntb[0] && cnta[1] == cntb[1])) {
                        System.out.println("YES");
                  } else {
                        System.out.println("NO");
                  }
            }

            sc.close();
      }

}