package CodeForces.greedy.B_Yet_Another_Coin_Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*B. Yet Another Coin Problem
time limit per test1 second
memory limit per test256 megabytes
You have 5
 different types of coins, each with a value equal to one of the first 5
 triangular numbers: 1
, 3
, 6
, 10
, and 15
. These coin types are available in abundance. Your goal is to find the minimum number of these coins required such that their total value sums up to exactly n
.

We can show that the answer always exists.

Input
The first line contains one integer t
 (1≤t≤104
) — the number of test cases. The description of the test cases follows.

The first line of each test case contains an integer n
 (1≤n≤109
) — the target value.

Output
For each test case, output a single number — the minimum number of coins required.

Example
InputCopy
14
1
2
3
5
7
11
12
14
16
17
18
20
98
402931328
OutputCopy
1
2
1
3
2
2
2
3
2
3
2
2
8
26862090
Note
In the first test case, for n=1
, the answer is 1
 since only one 1
 value coin is sufficient. 1=1⋅1
.

In the fourth test case, for n=5
, the answer is 3
, which can be achieved using two 1
 value coins and one 3
 value coin. 5=2⋅1+1⋅3
.

In the seventh test case, for n=12
, the answer is 2
, which can be achieved using two 6
 value coins.

In the ninth test case, for n=16
, the answer is 2
, which can be achieved using one 1
 value coin and one 15
 value coin or using one 10
 value coin and one 6
 value coin. 16=1⋅1+1⋅15=1⋅6+1⋅10
. */

public class Main {
      static long[] coins = { 1, 3, 6, 10, 15 };
      static HashMap<Integer, Integer> map;

      public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());

            map = new HashMap<>();

            map.put(0, 0); // important to avoid null pointer exception
            map.put(1, 1);
            map.put(2, 2);
            map.put(3, 1);
            map.put(4, 2);
            map.put(5, 3);
            map.put(6, 1);
            map.put(7, 2);
            map.put(8, 3);
            map.put(9, 2);
            map.put(10, 1);
            map.put(11, 2);
            map.put(12, 2);
            map.put(13, 2);
            map.put(14, 3);
            map.put(15, 1);

            while (t-- > 0) {
                  StringTokenizer st = new StringTokenizer(br.readLine());
                  long n = Long.parseLong(st.nextToken());

                  long cnt = 0;

                  if (n <= 15) {
                        cnt = map.get((int) n);
                  } else {
                        // first calculate the no of 15s for a large n greedy play
                        long num15s = n / 15;
                        long rem = n % 15;

                        cnt += num15s + map.get((int) rem);
                        if (rem >= 5) {
                              cnt = Math.min(num15s + map.get((int) rem), (num15s + 1 + map.get((int) rem - 5)));
                        }
                  }

                  System.out.println(cnt);
            }
      }
}
