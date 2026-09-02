package CodeForces.Graphs.A_Shortest_Path_Of_The_King;

/*
A. Shortest path of the king
time limit per test1 second
memory limit per test64 megabytes

The king is left alone on the chessboard. In spite of this loneliness, he doesn't lose heart, 
because he has business of national importance. For example, he has to pay an official visit to square t. 
As the king is not in habit of wasting his time, he wants to get from his current position s to square t in the least number of moves. Help him to do this.


In one move the king can get to the square that has a common side or a common vertex with the square the king is currently in (generally there are 8 different squares he can move to).

Input
The first line contains the chessboard coordinates of square s, the second line — of square t.

Chessboard coordinates consist of two characters, the first one is a lowercase Latin letter (from a to h), the second one is a digit from 1 to 8.

Output
In the first line print n — minimum number of the king's moves. Then in n lines print the moves themselves. Each move is described with one of the 8: L, R, U, D, LU, LD, RU or RD.

L, R, U, D stand respectively for moves left, right, up and down (according to the picture), and 2-letter combinations stand for diagonal moves. If the answer is not unique, print any of them.

Examples
InputCopy
a8
h1
OutputCopy
7
RD
RD
RD
RD
RD
RD
RD
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
      static Map<Character, Integer> map = new HashMap<>();

      static {

            map.put('a', 0);
            map.put('b', 1);
            map.put('c', 2);
            map.put('d', 3);
            map.put('e', 4);
            map.put('f', 5);
            map.put('g', 6);
            map.put('h', 7);
      }

      static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
      static int[] dc = { -1, 1, -1, 0, -1, 1, 1, 0 };
      static String[] dm = {
                  "LD",
                  "LU",
                  "D",
                  "R",
                  "RD",
                  "RU",
                  "U",
                  "L"
      };

      static ArrayList<String> moves;

      public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            String s = st.nextToken();
            st = new StringTokenizer(br.readLine());

            String t = st.nextToken();

            int sx = map.get(s.charAt(0));
            int sy = Integer.parseInt(s.substring(1)) - 1;

            int tx = map.get(t.charAt(0));
            int ty = Integer.parseInt(t.substring(1)) - 1;

            // System.out.println(sx + " " + sy + " " + tx + " " + ty);

            moves = new ArrayList<>();

            Queue<int[]> q = new LinkedList<>();

            q.offer(new int[] { sx, sy });

            boolean[][] visited = new boolean[8][8];
            int[][] parentR = new int[8][8];
            int[][] parentC = new int[8][8];

            String[][] moveName = new String[8][8];

            for (int i = 0; i < 8; i++) {
                  Arrays.fill(parentR[i], -1);
                  Arrays.fill(parentC[i], -1);
            }

            visited[sx][sy] = true;

            while (!q.isEmpty()) {
                  int[] curr = q.poll();
                  int x = curr[0];
                  int y = curr[1];

                  if (x == tx && y == ty)
                        break;

                  for (int i = 0; i < 8; i++) {
                        int nr = x + dr[i];
                        int nc = y + dc[i];

                        if (nr < 0 || nr >= 8 || nc < 0 || nc >= 8 || visited[nr][nc])
                              continue;

                        visited[nr][nc] = true;
                        parentR[nr][nc] = x;
                        parentC[nr][nc] = y;

                        moveName[nr][nc] = dm[i];

                        q.offer(new int[] { nr, nc });
                  }
            }

            ArrayList<String> moves = new ArrayList<>();

            int x = tx;
            int y = ty;

            while (x != sx || y != sy) {
                  int pr = parentR[x][y];
                  int pc = parentC[x][y];

                  moves.add(moveName[x][y]);

                  x = pr;
                  y = pc;
            }

            Collections.reverse(moves);

            System.out.println(moves.size());
            for (String move : moves)
                  System.out.println(move);

      }
}
