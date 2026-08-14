package CodeForces.Strings.A_StringRotation_Game;

import java.util.Scanner;

/*
A. String Rotation Game
time limit per test1 second
memory limit per test256 megabytes
Define a block in a string as a contiguous substring of characters of the same type that cannot be extended either to the left or the right. For example, in the string aabcccdaa, there are five blocks:

aa (1
-st to 2
-nd characters)
b (3
-rd character)
ccc (4
-th to 6
-th characters)
d (7
-th character)
aa (8
-th to 9
-th characters).
You are playing a game where you are given a string s
 of length n
. You can cyclically rotate∗
 the string however you want. Your score is then calculated as the number of blocks in the final string. Please find the maximum score possible.

∗
Formally, choose an index 1≤i≤n
, and replace the string s1s2…sn
 with the string si+1si+2…sns1s2…si
. For example, the string abcde can be rotated to string deabc by choosing i=3
.

Input
Each test contains multiple test cases. The first line contains the number of test cases t
 (1≤t≤500
). The description of the test cases follows.

The first line of each test case contains a single integer n
 (1≤n≤100
).

The second line of each test case contains the string s
 of length n
.

Strings s
 consist of lowercase Latin characters only.

Output
For each testcase, output a single integer denoting the maximum score you can achieve.

Example
InputCopy
4
4
abcd
4
abbc
4
abba
6
abbccc
OutputCopy
4
4
3
4
Note
In the first test case, score of the original string abcd is 4
. It can be shown that a score greater than 4
 cannot be achieved.

In the second test case, cyclically rotating the string by 2
 positions will give us string bcab. Score of this string is 4
. It can be shown that a score greater than 4
 cannot be achieved.


*/

public class Main {
      static int maxScore = 0;

      public static int getCurrScore(String s, int n) {
            if (s.length() == 0)
                  return 0;
            if (s.length() == 1)
                  return 1;

            int block = 0;

            int i = 0;
            // start j with 1 and avoid uncessary overcount of last
            int j = 1;

            while (i < n && j < n) {
                  while (j < n && s.charAt(i) == s.charAt(j))
                        j++;

                  block++;
                  i = j;
            }

            return block;
      }

      public static int getMaxScore(String s, int n) {
            String temp = s;

            for (int i = 0; i < n; i++) {
                  StringBuilder sb = new StringBuilder();

                  char first = temp.charAt(0);
                  String rem = temp.substring(1, n);
                  sb.append(rem);
                  sb.append(first);

                  temp = sb.toString();

                  int score = getCurrScore(sb.toString(), n);
                  maxScore = Math.max(score, maxScore);
            }

            return maxScore;
      }

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                  int n = sc.nextInt();
                  String s = sc.next();

                  maxScore = 0;

                  System.out.println(getMaxScore(s, n));
            }

            sc.close();
      }
}
