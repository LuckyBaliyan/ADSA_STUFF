package CodeForces.bruteForce.A_Goals_Of_Victory;

import java.util.Scanner;

/*
A. Goals of Victory
time limit per test1 second
memory limit per test256 megabytes
There are n
 teams in a football tournament. Each pair of teams match up once. After every match, Pak Chanek receives two integers as the result of the match, the number of goals the two teams score during the match. The efficiency of a team is equal to the total number of goals the team scores in each of its matches minus the total number of goals scored by the opponent in each of its matches.

After the tournament ends, Pak Dengklek counts the efficiency of every team. Turns out that he forgot about the efficiency of one of the teams. Given the efficiency of n−1
 teams a1,a2,a3,…,an−1
. What is the efficiency of the missing team? It can be shown that the efficiency of the missing team can be uniquely determined.

Input
Each test contains multiple test cases. The first line contains an integer t
 (1≤t≤500
) — the number of test cases. The following lines contain the description of each test case.

The first line contains a single integer n
 (2≤n≤100
) — the number of teams.

The second line contains n−1
 integers a1,a2,a3,…,an−1
 (−100≤ai≤100
) — the efficiency of n−1
 teams.

Output
For each test case, output a line containing an integer representing the efficiency of the missing team.

Example
InputCopy
2
4
3 -4 5
11
-30 12 -57 7 0 -81 -68 41 -89 0
OutputCopy
-4
265
Note
In the first test case, below is a possible tournament result:

Team 1
 vs. Team 2
: 1−2
Team 1
 vs. Team 3
: 3−0
Team 1
 vs. Team 4
: 3−2
Team 2
 vs. Team 3
: 1−4
Team 2
 vs. Team 4
: 1−3
Team 3
 vs. Team 4
: 5−0
The efficiency of each team is:

Team 1
: (1+3+3)−(2+0+2)=7−4=3
Team 2
: (2+1+1)−(1+4+3)=4−8=−4
Team 3
: (0+4+5)−(3+1+0)=9−4=5
Team 4
: (2+3+0)−(3+1+5)=5−9=−4
Therefore, the efficiency of the missing team (team 4
) is −4
.

It can be shown that any possible tournament of 4
 teams that has the efficiency of 3
 teams be 3
, −4
, and 5
 will always have the efficiency of the 4
-th team be −4
.
*/

public class Main {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                  int n = sc.nextInt();
                  int[] arr = new int[n];

                  for (int i = 0; i < n - 1; i++)
                        arr[i] = sc.nextInt();

                  int sum = 0;

                  for (int eff : arr)
                        sum += eff;

                  System.out.println(-1 * sum);
            }

            sc.close();
      }
}
