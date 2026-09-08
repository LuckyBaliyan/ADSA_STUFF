package CodeForces.bruteForce.C_Traget_Practice;

import java.util.Scanner;

/*
C. Target Practice
time limit per test1 second
memory limit per test256 megabytes
A 10×10
 target is made out of five "rings" as shown. Each ring has a different point value: the outermost ring — 1 point, the next ring — 2 points, ..., the center ring — 5 points.


Vlad fired several arrows at the target. Help him determine how many points he got.

Input
The input consists of multiple test cases. The first line of the input contains a single integer t
 (1≤t≤1000
) — the number of test cases.

Each test case consists of 10 lines, each containing 10 characters. Each character in the grid is either X
 (representing an arrow) or .
 (representing no arrow).

Output
For each test case, output a single integer — the total number of points of the arrows.

Example
InputCopy
4
X.........
..........
.......X..
.....X....
......X...
..........
.........X
..X.......
..........
.........X
..........
..........
..........
..........
..........
..........
..........
..........
..........
..........
..........
..........
..........
..........
....X.....
..........
..........
..........
..........
..........
XXXXXXXXXX
XXXXXXXXXX
XXXXXXXXXX
XXXXXXXXXX
XXXXXXXXXX
XXXXXXXXXX
XXXXXXXXXX
XXXXXXXXXX
XXXXXXXXXX
XXXXXXXXXX
OutputCopy
17
0
5
220
Note
In the first test case, there are three arrows on the outer ring worth 1 point each, two arrows on the ring worth 3 points each, and two arrows on the ring worth 4 points each. The total score is 3×1+2×3+2×4=17
.

In the second test case, there aren't any arrows, so the score is 0
*/

public class Main {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {

                  long typ1 = 0;
                  long typ2 = 0;
                  long typ3 = 0;
                  long typ4 = 0;
                  long typ5 = 0;

                  for (int i = 0; i < 10; i++) {
                        String line = sc.next();

                        for (int j = 0; j < 10; j++) {
                              char ch = line.charAt(j);

                              if (ch == 'X') {
                                    if (i == 0 && j <= 9 || i <= 9 && j == 0 || i == 9 && j <= 9 || i <= 9 && j == 9)
                                          typ1++;
                                    else if (i == 1 && j <= 8 || i <= 8 && j == 1 || i == 8 && j <= 8
                                                || i <= 8 && j == 8)
                                          typ2++;
                                    else if (i == 2 && j <= 7 || i <= 7 && j == 2 || i == 7 && j <= 7
                                                || i <= 7 && j == 7)
                                          typ3++;
                                    else if (i == 3 && j <= 6 || i <= 6 && j == 3 || i == 6 && j <= 6
                                                || i <= 6 && j == 6)
                                          typ4++;
                                    else if (i == 4 && j <= 5 || i <= 5 && j == 4 || i == 5 && j <= 5
                                                || i <= 5 && j == 5)
                                          typ5++;
                              }
                        }
                  }

                  System.out.println(typ1 + 2 * typ2 + 3 * typ3 + 4 * typ4 + 5 * typ5);
            }

            sc.close();
      }
}
