package CodeForces.Graphs.A_Shortest_Path_with_Obstacle;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



/*
A. Shortest Path with Obstacle
time limit per test2 seconds
memory limit per test512 megabytes
There are three cells on an infinite 2-dimensional grid, labeled A
, B
, and F
. Find the length of the shortest path from A
 to B
 if:

in one move you can go to any of the four adjacent cells sharing a side;
visiting the cell F
 is forbidden (it is an obstacle).
Input
The first line contains an integer t
 (1≤t≤104
) — the number of test cases in the input. Then t
 test cases follow. Before each test case, there is an empty line.

Each test case contains three lines. The first one contains two integers xA,yA
 (1≤xA,yA≤1000
) — coordinates of the start cell A
. The second one contains two integers xB,yB
 (1≤xB,yB≤1000
) — coordinates of the finish cell B
. The third one contains two integers xF,yF
 (1≤xF,yF≤1000
) — coordinates of the forbidden cell F
. All cells are distinct.

Coordinate x
 corresponds to the column number and coordinate y
 corresponds to the row number (see the pictures below).

Output
Output t
 lines. The i
-th line should contain the answer for the i
-th test case: the length of the shortest path from the cell A
 to the cell B
 if the cell F
 is not allowed to be visited.

Example
InputCopy
7

1 1
3 3
2 2

2 5
2 1
2 3

1000 42
1000 1
1000 1000

1 10
3 10
2 10

3 8
7 8
3 7

2 1
4 1
1 1

1 344
1 10
1 1
OutputCopy
4
6
41
4
4
2
334
 */

public class Main {
      static int[] dr = { -1, 1, 0, 0 };
      static int[] dc = {0, 0, -1, 1};

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                  sc.nextLine();

                  int xA = sc.nextInt();
                  int yA = sc.nextInt();

                  sc.nextLine();

                  int xB = sc.nextInt();
                  int yB = sc.nextInt();

                  sc.nextLine();

                  int xF = sc.nextInt();
                  int yF = sc.nextInt();


                  Queue<int[]> q = new LinkedList<>();
                  q.offer(new int[] { xA, yA, 0 });

                  boolean [][] visited = new boolean[1001][1001];
                  visited[xA][yA] = true;


                  while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        int r = curr[0];
                        int c = curr[1];
                        int dist = curr[2];

                        if (r == xB && c == yB) {
                              System.out.println(dist);
                              break;
                        }

                        for(int i = 0; i<4; i++){
                              int nr = r + dr[i];
                              int nc = c + dc[i];

                              if(nr  >=0 && nc >=0 && nr < 1001 && nc < 1001 && !visited[nr][nc] && !(nr == xF && nc == yF)){
                                    visited[nr][nc] = true;
                                    q.offer(new int [] {nr, nc, dist + 1});
                              }
                        }
                  }
            }
      }
}
