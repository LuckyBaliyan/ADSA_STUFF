//package CSES_Problem.Graphs.BitMap;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int [] dr = {-1,1,0,0};
    static int [] dc = {0,0,-1,1};
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do { c = read(); } while (c <= ' ');
            if (c == '-') { sign = -1; c = read(); }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();

        int  t = sc.nextInt();

        for(int i = 0;i<t;i++){
           int n = sc.nextInt();
           int m = sc.nextInt();

           int [][] Map = new int [n][m];
           boolean [][] visited = new boolean[n][m];

           Queue<int []> q = new ArrayDeque<>();

           for(int j = 0;j<n;j++){
            for(int k = 0;k<m;k++){
                Map[j][k] = sc.nextInt();
            }
           }

           solve(Map,visited,n,m,q);

           for(int j = 0;j<n;j++){
            for(int k = 0;k<m;k++){
                System.out.print(Map[j][k]+" ");
            }
            System.out.println();
           }

        }
    }

    public static void solve(int [][] Map,boolean [][] visited,
        int n,int m,Queue<int[]> q){

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(Map[i][j] == 1){
                    Map[i][j] =  0;
                    q.offer(new int [] {i,j,Map[i][j]});
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            int [] curr = q.poll();

            int x = curr[0];
            int y = curr[1];
            int val = curr[2];

            for(int i = 0;i<4;i++){
               int nr = x + dr[i];
               int nc = y + dc[i];

               if(nr < 0 || nr >= n || nc < 0 || nc >=m || visited[nr][nc]
               )continue;

               if(Map[nr][nc] == 0 && !visited[nr][nc]){
                  Map[nr][nc] = val + 1;
                  visited[nr][nc] = true;
                  q.offer(new int [] {nr,nc,Map[nr][nc]});
               }
            }
        }
    }
}
