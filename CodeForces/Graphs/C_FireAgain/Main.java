package CodeForces.Graphs.C_FireAgain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int [] dr = {-1,0,1,0};
    static int [] dc = {0,-1,0,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sc = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(sc.nextToken());
        int M = Integer.parseInt(sc.nextToken());

        boolean [][] visited = new boolean[N][M];

        Queue<int []> q = new LinkedList<>();

        int K = Integer.parseInt(br.readLine());
        sc = new StringTokenizer("");

        for(int i = 0; i < K; i++){
           while (sc.countTokens() < 2) {
               sc = new StringTokenizer(br.readLine());
           }
        
           int x = Integer.parseInt(sc.nextToken()) - 1;
           int y = Integer.parseInt(sc.nextToken()) - 1;
        
           q.offer(new int[]{x, y});
           visited[x][y] = true;
        }

        int lastR = 0;
        int lastC = 0;

        while(!q.isEmpty()){
            int [] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            lastR = r;
            lastC = c;

            for(int i = 0; i<4; i++){
               int nr = r + dr[i];
               int nc = c + dc[i];

               if(nr >= 0 && nr < N && nc >= 0 && nc < M && 
                !visited[nr][nc]){
                    q.offer(new int [] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }

        System.out.println((lastR + 1) + " " + (lastC+1));
    }
}
