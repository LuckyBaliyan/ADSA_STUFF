package CodeForces.DP.C_Number_Of_Ways;

import java.util.Scanner;

/*

C. Number of Ways

time limit per test2 seconds
memory limit per test256 megabytes
You've got array a[1], a[2], ..., a[n], consisting of n integers. Count the number of ways to split all the elements of the array 
into three contiguous parts so that the sum of elements in each part is the same.

Input
The first line contains integer n (1 ≤ n ≤ 5·105), showing how many numbers are in the array. The second line contains n integers a[1], a[2], ..., a[n] (|a[i]| ≤  109) — the elements of array a.

Output
Print a single integer — the number of ways to split the array into three parts with the same sum.

Examples
InputCopy
5
1 2 3 0 3
OutputCopy
2
InputCopy
4
0 1 -1 0
OutputCopy
1
InputCopy
2
4 1
OutputCopy
0


*/

public class Main {

      static long target;
      static int n;

      static long solve(long[] arr, int n) {
            long[] prefix = new long[n];

            prefix[0] = arr[0];

            for (int i = 1; i < n; i++) {
                  prefix[i] = arr[i] + prefix[i - 1];
            }

            long count = 0;
            long ans = 0;

            for (int i = 0; i < n - 1; i++) {
                  if (prefix[i] == 2 * target)
                        ans += count;
                  if (prefix[i] == target)
                        count++;
            }

            return ans;
      }

      public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            n = sc.nextInt();

            long[] arr = new long[n];

            long total = 0;

            for (int i = 0; i < n; i++) {
                  arr[i] = sc.nextLong();
                  total += arr[i];
            }

            if (n < 3 || total % 3 != 0) {
                  System.out.println(0);
                  return;
            }

            target = total / 3;

            System.out.println(solve(arr, n));
      }
}