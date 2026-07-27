package CodeForces.Graphs.C_ArrowPath;

import java.util.Scanner;

public class Main {
      static char[][] grid;
      static boolean[][] visited;
      static int[] dr = { -1, 1, 0, 0 };
      static int[] dc = { 0, 0, -1, 1 };

      public static String solve(int n) {
            boolean res = dfs(0, 0, n);
            return res ? "YES" : "NO";
      }

      public static boolean checkBounds(int i, int j, int n) {
            if (i < 0 || i > 1 || j < 0 || j > n - 1)
                  return true;
            return false;
      }

      public static boolean dfs(int i, int j, int n) {
            if (checkBounds(i, j, n))
                  return false;

            if (i == 1 && j == n - 1)
                  return true;

            if (visited[i][j])
                  return false;

            // mark current cell as visited
            visited[i][j] = true;

            for (int d = 0; d < 4; d++) {
                  int nr = i + dr[d];
                  int nc = j + dc[d];

                  if (checkBounds(nr, nc, n))
                        continue;

                  // check for the cell we are going to reach after the 1'st move
                  if (grid[nr][nc] == '<')
                        nc--;
                  else
                        nc++;

                  if (nc < 0 || nc > n - 1)
                        continue;

                  if (dfs(nr, nc, n))
                        return true;
            }

            return false;
      }

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                  int n = sc.nextInt();

                  grid = new char[2][n];
                  visited = new boolean[2][n];

                  grid[0] = sc.next().toCharArray();
                  grid[1] = sc.next().toCharArray();

                  String res = solve(n);

                  System.out.println(res);
            }

            sc.close();
      }
}
