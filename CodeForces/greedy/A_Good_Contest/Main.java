package CodeForces.greedy.A_Good_Contest;

import java.util.Scanner;

/*
A. Good Contest
time limit per test1 second
memory limit per test256 megabytes
The next programming contest has three problems and n
 participants.

Problem 1
 is easy, problem 2
 is medium, and problem 3
 is hard.

A participant is called weak if they did not solve all three problems.

Unfortunately, the scoreboard was lost. The only remaining information is an array a
 of length 3
, where ai
 is the number of participants who solved problem i
.

Among all scoreboards consistent with this information, find the minimum possible number of weak participants.

Input
The first line contains an integer t
 (1≤t≤3000
) — the number of test cases.

The first line of each test case contains an integer n
 (1≤n≤9
) — the number of participants.

The second line of each test case contains three integers a1,a2,a3
 (0≤ai≤n
), where ai
 is the number of participants who solved problem i
.

Output
For each test case, print a single integer — the minimum possible number of weak participants.

Example
InputCopy
6
3
3 3 3
4
4 4 3
1
1 1 1
9
9 8 9
5
0 5 5
6
4 3 2
OutputCopy
0
1
0
1
5
4
Note
In the first test case, all 3
 participants can have solved all three problems, so the answer is 0
.

In the second test case, participant 1
 could have solved only problems 1
 and 2
, while participants 2
, 3
, and 4
 solved all three problems. Therefore, participant 1
 is the only participant who is weak, so the answer is 1
. It can be shown that this is minimal.
*/

public class Main {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                  int n = sc.nextInt();
                  int[] arr = new int[3];

                  int min = Integer.MAX_VALUE;

                  for (int i = 0; i < 3; i++) {
                        arr[i] = sc.nextInt();
                        min = Math.min(min, arr[i]);
                  }

                  System.out.println(Math.abs(n - min));
            }

            sc.close();
      }
}
