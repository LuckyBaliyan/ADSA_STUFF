package CodeForces.Graphs.Ice_Skating;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static int countHills(int [][] grid,int v){
        int n = grid.length;
        int m = grid[0].length;

        boolean [][] visited = new boolean[n][m];
        int count  =  0;

        for(int i = 0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
               if(!visited[i][j]){
                  dfs(grid,visited,i,j,n,m);
                  count++;
               }
            }
        }

        return count - 1;
    }

    public static void dfs(int [][] grid,boolean [][] visited,int i,int j,int n,int m){
        visited[i][j] = true;
        
        if(i > 0 && !visited[i-1][j] && grid[i-1][j] == 1)dfs(grid,visited,i-1,j,n,m);
        if(i+1 < n && !visited[i+1][j] && grid[i+1][j] == 1)dfs(grid,visited,i+1,j,n,m);
        if(j>0 && !visited[i][j-1] &&  grid[i][j-1] == 1)dfs(grid,visited,i,j-1,n,m);
        if(j+1 < m && !visited[i][j+1] &&  grid[i][j+1] == 1)dfs(grid,visited,i,j+1,n,m);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int [][] grid = new int[N][2];

        //HashSet
        HashSet<Integer> st = new HashSet<>();

        for(int i = 0;i<N;i++){
            for(int j = 0;j<2;j++){
                int vertice = sc.nextInt();
                st.add(vertice);
                grid[i][j] = vertice;
            }
        }

        int v = st.size();

        int [][] adj = new int [v+1][v+1];

        for(int i = 0;i<v;i++){
            adj[grid[i][0]][grid[i][1]] = 1;
            adj[grid[i][1]][grid[i][0]] = 1;
        }

        System.out.println(countHills(adj,v));
    }
}
