package CodeForces.Graphs.C_FireAgain;

import java.io.File;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n, m, k;
    static boolean[][] visited;
    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { 1, -1, 0, 0 };

    static Queue<int[]> q = new LinkedList<>();

    public static int[] bfs() {

        int lastX = 0;
        int lastY = 0;

        while (!q.isEmpty()) {

            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            if (visited[r][c])
                continue;

            visited[r][c] = true;

            lastX = r;
            lastY = c;

            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < m &&
                        !visited[nr][nc]) {

                    q.offer(new int[] { nr, nc });
                }
            }
        }

        return new int[] { lastX, lastY };
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        visited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            q.offer(new int[] { x, y });
        }

        int[] ans = bfs();

        System.out.println((ans[0] + 1) + " " + (ans[1] + 1));
        sc.close();
    }
}