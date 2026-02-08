package CodeForces.Graphs.The_Lakes;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int maxVol;
    public static int [] dr = {-1,1,0,0};
    public static int [] dc = {0,0,-1,1};

    public static int countVolume(int [][] grid,int n,int m){
        maxVol = 0; // reset it for each test case;
        boolean [][] visited = new boolean[n][m];

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] != 0 && !visited[i][j]){
                    int lakeVolume  = bfs(grid,n,m,i,j,visited);
                    maxVol = Math.max(maxVol,lakeVolume);
                }
            }
        }

        return maxVol;
    }

    public static int bfs(int [][] grid,int n,int m,int sr,int sc,boolean [][] visited){
        Queue<int []> q = new ArrayDeque<>();
        q.add(new int [] {sr,sc});
        visited[sr][sc] = true;

        int volume  = 0;

        while(!q.isEmpty()){
            int [] arr = q.poll();
            int r = arr[0];
            int c = arr[1];

            volume += grid[r][c];

            for(int i = 0;i<4;i++){
                int nr = r + dr[i];
                int nc =  c + dc[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m &&
                !visited[nr][nc] && grid[nr][nc] != 0){
                    visited[nr][nc] = true;
                    q.offer(new int [] {nr,nc});
                }
            }
        }

        
        return volume;
    }

    /*public static int dfs(int [][] grid,int n,int m,int i,int j,boolean [][] visited){
        visited[i][j] = true;
        int cellVolume = grid[i][j];

        if(i > 0 && !visited[i-1][j] && grid[i-1][j] != 0)
        cellVolume += dfs(grid,n,m,i-1,j,visited);
        if(i + 1 < n && !visited[i+1][j] && grid[i+1][j] != 0)
        cellVolume += dfs(grid,n,m,i+1,j,visited);
        if(j > 0 && !visited[i][j-1] && grid[i][j-1] != 0)
        cellVolume += dfs(grid,n,m,i,j-1,visited);
        if(j + 1 < m && !visited[i][j+1] && grid[i][j+1] != 0)
        cellVolume += dfs(grid,n,m,i,j+1,visited);

        return cellVolume;
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0;i<t;i++){
            int n  = sc.nextInt();
            int m = sc.nextInt();

            int [][] grid = new int [n][m];

            for(int j = 0;j<n;j++){
                for(int k = 0;k<m;k++){
                   grid[j][k] = sc.nextInt();
                }
            }

            System.out.println(countVolume(grid,n,m));
        }
    }
}
