package CodeForces.Hashing.D_Remove_Two_Letters;

import java.util.HashSet;
import java.util.Scanner;

/*
D. Remove Two Letters
time limit per test2 seconds
memory limit per test256 megabytes
Dmitry has a string s
, consisting of lowercase Latin letters.

Dmitry decided to remove two consecutive characters from the string s
 and you are wondering how many different strings can be obtained after such an operation.

For example, Dmitry has a string "aaabcc". You can get the following different strings: "abcc"(by deleting the first two or second and third characters), "aacc"(by deleting the third and fourth characters),"aaac"(by deleting the fourth and the fifth character) and "aaab" (by deleting the last two).

Input
The first line of input data contains a single integer t
 (1≤t≤104
) — number of test cases.

The descriptions of the test cases follow.

The first line of the description of each test case contains an integer n
 (3≤n≤2⋅105
).

The second line of the description of each test case contains a string s
 of length n
 consisting of lowercase Latin letters.

It is guaranteed that the sum of n
 for all test cases does not exceed 2⋅105
.

Output
For each test case print one integer — the number of distinct strings that can be obtained by removing two consecutive letters.

Example
InputCopy
7
6
aaabcc
10
aaaaaaaaaa
6
abcdef
7
abacaba
6
cccfff
4
abba
5
ababa
OutputCopy
4
1
5
3
3
3
1
Note
The first example is explained in the statement.

In the third example, the following strings are obtained: "cdef", "adef", "abef", "abcf", "abcd".

In the seventh example, any deletion will result in the string "aba".


*/

public class Main {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                  int n = sc.nextInt();
                  String s = sc.next();

                  // HashSet<String> st = new HashSet<>();

                  /*
                   * *for (int i = 0; i < n - 1; i++) {
                   * st.add(s.substring(0, i) + s.substring(i + 2));
                   * }
                   * 
                   * System.out.println(st.size());
                   * 
                   */

                  int cnt = 0;

                  for (int i = 0; i < n - 2; i++) {
                        if (s.charAt(i) == s.charAt(i + 2))
                              cnt++;
                  }

                  System.out.println(n - 1 - cnt);
            }

            sc.close();
      }
}
