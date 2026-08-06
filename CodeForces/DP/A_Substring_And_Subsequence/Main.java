package CodeForces.DP.A_Substring_And_Subsequence;

import java.util.Arrays;
import java.util.Scanner;

/*
A. Substring and Subsequence
time limit per test2 seconds
memory limit per test256 megabytes
One day Polycarpus got hold of two non-empty strings s and t, consisting of lowercase Latin letters. 
Polycarpus is quite good with strings, so he immediately wondered, how many different pairs of "x y" are there, 
such that x is a substring of string s, y is a subsequence of string t, and the content of x and y is the same. 
Two pairs are considered different, if they contain different substrings of string s or different subsequences of string t.
 Read the whole statement to understand the definition of different substrings and subsequences.

The length of string s is the number of characters in it. If we denote the length of the string s as |s|, 
we can write the string as s = s1s2... s|s|.

A substring of s is a non-empty string x = s[a... b] = sasa + 1... sb (1 ≤ a ≤ b ≤ |s|). For example, "code" and "force" 
are substrings or "codeforces", while "coders" is not. Two substrings s[a... b] and s[c... d] are considered to be different 
if a ≠ c or b ≠ d. For example, if s="codeforces", s[2...2] and s[6...6] are different, though their content is the same.

A subsequence of s is a non-empty string y = s[p1p2... p|y|] = sp1sp2... sp|y| (1 ≤ p1 < p2 < ... < p|y| ≤ |s|). For example, "coders" 
is a subsequence of "codeforces". Two subsequences u = s[p1p2... p|u|] and v = s[q1q2... q|v|] are considered different if the 
sequences p and q are different.

Input
The input consists of two lines. The first of them contains s (1 ≤ |s| ≤ 5000), and the second one contains t (1 ≤ |t| ≤ 5000). 
Both strings consist of lowercase Latin letters.

Output
Print a single number — the number of different pairs "x y" such that x is a substring of string s, y is a subsequence of string t,
 and the content of x and y is the same. As the answer can be rather large, print it modulo 1000000007 (109 + 7).

Examples
InputCopy
aa
aa
OutputCopy
5
InputCopy
codeforces
forceofcode
OutputCopy
60
Note
Let's write down all pairs "x y" that form the answer in the first sample: 
"s[1...1] t[1]", "s[2...2] t[1]", "s[1...1] t[2]","s[2...2] t[2]", "s[1...2] t[1 2]".


*/

public class Main {
      static final long MOD = 1_000_000_007;
      static long[][] dp;

      public static long getCount(String s, String t) {
            int n = s.length();
            int m = t.length();

            long res = 0;

            // we are gonna try for each substring of s to match a subsequence with t
            for (int i = 0; i < n; i++) {
                  for (int j = i; j < n; j++) {

                        // new dp for evry newly generated substring state
                        dp = new long[j - i + 2][m + 1];
                        for (long[] d : dp)
                              Arrays.fill(d, -1);

                        res += solve(s.substring(i, j + 1), t, (j - i + 1), m, 0, 0);
                  }
            }

            return res % MOD;
      }

      private static long solve(String s, String t, int n, int m, int it, int is) {
            // means u able to get a subsequnce equals to the current substring
            if (is == n)
                  return 1;

            // return 0 when firts or th nth check completes
            if (it == m)
                  return 0;

            if (dp[is][it] != -1)
                  return dp[is][it];

            // skip or take a char to match with the string s
            long res = 0;

            if (s.charAt(is) == t.charAt(it)) {
                  res = (res + solve(s, t, n, m, it + 1, is + 1)) % MOD;
            }

            res = (res + solve(s, t, n, m, it + 1, is)) % MOD;

            return dp[is][it] = res;
      }

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            String s = sc.next();
            String t = sc.next();

            System.out.println(getCount(s, t));

            sc.close();
      }
}
