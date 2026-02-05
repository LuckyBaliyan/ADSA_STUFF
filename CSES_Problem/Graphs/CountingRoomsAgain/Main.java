package CSES_Problem.Graphs.CountingRoomsAgain;

import java.util.Scanner;

public class Main {
    public static int countingRooms(char [][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;

        boolean [][] visited = new boolean[n][m];

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == '.' && !visited[i][j]){
                    dfs(grid,visited,i,j,n,m);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void dfs(char [][] grid,boolean [][] visited,int i,int j,int n,int m){
        visited[i][j] = true;

        if(i > 0 && !visited[i-1][j] && grid[i-1][j] == '.')dfs(grid,visited,i-1,j,n,m);
        if(i+1 < n && !visited[i+1][j] && grid[i+1][j] == '.')dfs(grid,visited,i+1,j,n,m);
        if(j > 0 && !visited[i][j-1] && grid[i][j-1] == '.')dfs(grid,visited,i,j-1,n,m);
        if(j+1 < m && !visited[i][j+1] && grid[i][j+1] == '.')dfs(grid,visited,i,j+1,n,m);
    }

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

        int  n = sc.nextInt();
        int m = sc.nextInt();

        char [][] map = new char[n][m];

        for(int i = 0;i<n;i++){
            String s= sc.next();
            for(int j = 0;j<m;j++){
                map[i][j] = s.charAt(j);
            }
        }

        System.out.println(countingRooms(map));
    }
}
