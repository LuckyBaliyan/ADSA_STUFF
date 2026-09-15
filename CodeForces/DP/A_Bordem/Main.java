package CodeForces.DP.A_Bordem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
//import java.util.HashMap;
import java.util.StringTokenizer;

/*
A. Boredom
time limit per test1 second
memory limit per test256 megabytes
Alex doesn't like boredom. That's why whenever he gets bored, he comes up with games. One long winter evening he came up with a game and decided to play it.

Given a sequence a consisting of n integers. The player can make several steps. In a single step he can choose an element of the sequence (let's denote it ak) and delete it, at that all elements equal to ak + 1 and ak - 1 also must be deleted from the sequence. That step brings ak points to the player.

Alex is a perfectionist, so he decided to get as many points as possible. Help him.

Input
The first line contains integer n (1 ≤ n ≤ 105) that shows how many numbers are in Alex's sequence.

The second line contains n integers a1, a2, ..., an (1 ≤ ai ≤ 105).

Output
Print a single integer — the maximum number of points that Alex can earn.

Examples
InputCopy
2
1 2
OutputCopy
2
InputCopy
3
1 2 3
OutputCopy
4
InputCopy
9
1 2 1 3 2 2 2 2 3
OutputCopy
10
Note
Consider the third test example. At first step we need to choose any element equal to 2. After that step our sequence looks like this [2, 2, 2, 2]. Then we do 4 steps, on each step we choose any element equals to 2. In total we earn 10 points.
 */

public class Main {
      // static HashMap<Long, Integer> mp = new HashMap<>();
      static long[] memo;
      static long[] cnt;

      /*
       * public static long solve(long[] arr, int n, int i) {
       * if (i >= n)
       * return 0;
       * 
       * if(memo[i] != -1)return memo[i];
       * 
       * long skip = solve(arr, n, i + 1);
       * 
       * long take = 0;
       * 
       * int currentCnt = mp.getOrDefault(arr[i], 0);
       * int actualCnt1 = mp.getOrDefault(arr[i] - 1, 0);
       * int actualCnt2 = mp.getOrDefault(arr[i] + 1, 0);
       * 
       * if (currentCnt > 0) {
       * 
       * // take arr[i]
       * mp.put(arr[i], currentCnt - 1);
       * 
       * // delete arr[i] - 1 and arr[i] + 1
       * mp.put(arr[i] - 1, 0);
       * mp.put(arr[i] + 1, 0);
       * 
       * take = arr[i] + solve(arr, n, i + 1);
       * 
       * // backtrack: restore exactly what was there before
       * mp.put(arr[i], currentCnt);
       * mp.put(arr[i] - 1, actualCnt1);
       * mp.put(arr[i] + 1, actualCnt2);
       * }
       * 
       * // System.out.println(mp);
       * 
       * return memo[i] = Math.max(take, skip);
       * }
       */

      public static long solveOptimal(long num) {
            if (num <= 0)
                  return 0;

            if (memo[(int) num] != -1)
                  return memo[(int) num];

            // classic skip & take
            long skip = solveOptimal(num - 1);
            long take = num * cnt[(int) num] + solveOptimal(num - 2);

            return memo[(int) num] = Math.max(skip, take);
      }

      public static long solveTab(long num) {
            long[] dp = new long[1000001];

            dp[0] = 0;
            dp[1] = cnt[1] * 1;

            for (long i = 2; i <= num; i++) {
                  long skip = dp[(int) i - 1];
                  long take = i * cnt[(int) i] + dp[(int) i - 2];

                  dp[(int) i] = Math.max(skip, take);
            }

            return dp[(int) num];
      }

      public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            long[] arr = new long[n];
            cnt = new long[1000001];
            memo = new long[1000001];

            Arrays.fill(memo, -1);

            long maxNum = 0;

            for (int i = 0; i < n; i++) {
                  arr[i] = Integer.parseInt(st.nextToken());
                  cnt[(int) arr[i]]++;
                  maxNum = Math.max(arr[i], maxNum);
                  // mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
            }

            long res = solveTab(maxNum);
            System.out.println(res);
      }
}
