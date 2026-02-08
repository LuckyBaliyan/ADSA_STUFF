package ClassTests.Graphs.walls_and_gates;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int [] dr  = {-1,1,0,0};
    static int [] dc = {0,0,-1,1};

    public static void mutate(int [][] grid,int  n,int m){
        boolean [][] visited = new boolean[n][m];
        Queue<int [] > q = new ArrayDeque<>();

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 0){
                  visited[i][j] = true;
                  q.offer(new int [] {i,j,grid[i][j]});
                }
            }
        }

        while(!q.isEmpty()){
            int [] currCell = q.poll();
            int r = currCell[0];
            int c = currCell[1];
            int val =  currCell[2];

            for(int  i = 0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc] || grid[nr][nc] == 1)
                continue;

                if(grid[nr][nc] == -2 && !visited[nr][nc]){
                    grid[nr][nc] = val + 1;
                    q.offer(new int [] {nr,nc,grid[nr][nc]});
                    visited[nr][nc] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int [][] grid = new int [n][m];

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                grid[i][j] = sc.nextInt();
            }
        }

        mutate(grid,n,m);

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}
