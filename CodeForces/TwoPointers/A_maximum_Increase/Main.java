package CodeForces.TwoPointers.A_maximum_Increase;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*A. Maximum Increase
time limit per test1 second
memory limit per test256 megabytes
You are given array consisting of n integers. Your task is to find the maximum length of an increasing subarray of the given array.

A subarray is the sequence of consecutive elements of the array. Subarray is called increasing if each element of this subarray strictly greater than previous.

Input
The first line contains single positive integer n (1 ≤ n ≤ 105) — the number of integers.

The second line contains n positive integers a1, a2, ..., an (1 ≤ ai ≤ 109).

Output
Print the maximum length of an increasing subarray of the given array.

Examples
InputCopy
5
1 7 2 11 15
OutputCopy
3
InputCopy
6
100 100 100 100 100 100
OutputCopy
1
InputCopy
3
1 2 3
OutputCopy
3

 */

import java.util.*;

public class Main {
      public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            long[] arr = new long[n];

            for (int i = 0; i < n; i++)
                  arr[i] = Long.parseLong(st.nextToken());

            int l = 0;
            int r = 1;
            int p = 0;
            int ans = 1;

            while (r < n) {
                  if (arr[p] >= arr[r]) {
                        ans = Math.max(ans, (r - l));
                        l = r;
                        p = r;
                        r++;
                        continue;
                  }

                  r++;
                  p++;
            }

            ans = Math.max(ans, (r - l));

            System.out.println(ans);
      }
}
