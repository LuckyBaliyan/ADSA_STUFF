package CodeForces.Graphs.A_Computer_Game;

/*
A. Computer Game
time limit per test2 seconds
memory limit per test256 megabytes
Monocarp is playing a computer game. Now he wants to complete the first level of this game.

A level is a rectangular grid of 2
 rows and n
 columns. Monocarp controls a character, which starts in cell (1,1)
 — at the intersection of the 1
-st row and the 1
-st column.

Monocarp's character can move from one cell to another in one step if the cells are adjacent by side and/or corner. Formally, it is possible to move from cell (x1,y1)
 to cell (x2,y2)
 in one step if |x1−x2|≤1
 and |y1−y2|≤1
. Obviously, it is prohibited to go outside the grid.

There are traps in some cells. If Monocarp's character finds himself in such a cell, he dies, and the game ends.

To complete a level, Monocarp's character should reach cell (2,n)
 — at the intersection of row 2
 and column n
.

Help Monocarp determine if it is possible to complete the level.

Input
The first line contains a single integer t
 (1≤t≤100
) — the number of test cases. Then the test cases follow. Each test case consists of three lines.

The first line contains a single integer n
 (3≤n≤100
) — the number of columns.

The next two lines describe the level. The i
-th of these lines describes the i
-th line of the level — the line consists of the characters '0' and '1'. The character '0' corresponds to a safe cell, the character '1' corresponds to a trap cell.

Additional constraint on the input: cells (1,1)
 and (2,n)
 are safe.

Output
For each test case, output YES if it is possible to complete the level, and NO otherwise.

Example
InputCopy
4
3
000
000
4
0011
1100
4
0111
1110
6
010101
101010
OutputCopy
YES
YES
NO
YES
Note
Consider the example from the statement.

In the first test case, one of the possible paths is (1,1)→(2,2)→(2,3)
.

In the second test case, one of the possible paths is (1,1)→(1,2)→(2,3)→(2,4)
.

In the fourth test case, one of the possible paths is (1,1)→(2,2)→(1,3)→(2,4)→(1,5)→(2,6)
.
*/

import java.util.Scanner;

public class Main {

      static boolean[][] visited;

      public static boolean dfs(int[][] grid, int r, int c, int n) {
            visited[r][c] = true;

            if (r == 1 && c == n - 1)
                  return true;

            if (r + 1 < 2 && c + 1 < n && grid[r + 1][c + 1] == 0 && !visited[r + 1][c + 1]) {
                  if (dfs(grid, r + 1, c + 1, n))
                        return true;
            }

            if (r + 1 < 2 && c - 1 >= 0 && grid[r + 1][c - 1] == 0 && !visited[r + 1][c - 1]) {
                  if (dfs(grid, r + 1, c - 1, n))
                        return true;
            }

            if (r - 1 >= 0 && r < 2 && c + 1 < n && grid[r - 1][c + 1] == 0 && !visited[r - 1][c + 1]) {
                  if (dfs(grid, r - 1, c + 1, n))
                        return true;
            }

            if (r - 1 >= 0 && r < 2 && c - 1 >= 0 && c < n && grid[r - 1][c - 1] == 0 && !visited[r - 1][c - 1]) {
                  if (dfs(grid, r - 1, c - 1, n))
                        return true;
            }

            if (r + 1 < 2 && c >= 0 && c < n && grid[r + 1][c] == 0 && !visited[r + 1][c]) {
                  if (dfs(grid, r + 1, c, n))
                        return true;
            }

            if (r - 1 >= 0 && r < 2 && c >= 0 && c < n && grid[r - 1][c] == 0 && !visited[r - 1][c]) {
                  if (dfs(grid, r - 1, c, n))
                        return true;
            }

            if (r >= 0 && r < 2 && c + 1 < n && grid[r][c + 1] == 0 && !visited[r][c + 1]) {
                  if (dfs(grid, r, c + 1, n))
                        return true;
            }

            if (r >= 0 && r < 2 && c - 1 >= 0 && grid[r][c - 1] == 0 && !visited[r][c - 1]) {
                  if (dfs(grid, r, c - 1, n))
                        return true;
            }

            return false;
      }

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                  int n = sc.nextInt();
                  int[][] grid = new int[2][n];

                  for (int i = 0; i < 2; i++) {
                        String row = sc.next();

                        for (int j = 0; j < n; j++) {
                              grid[i][j] = row.charAt(j) - '0';
                        }
                  }

                  visited = new boolean[2][n];

                  boolean reachable = dfs(grid, 0, 0, n);

                  System.out.println(reachable ? "YES" : "NO");
            }

            sc.close();
      }
}
