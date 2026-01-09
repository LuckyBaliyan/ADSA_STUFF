package CSES_Problem.Graphs.countingRooms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int solve(char [][] map,int n,int m){
        boolean [][] visited = new boolean[n][m];
        int cnt = 0;


        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(map[i][j] == '.' && !visited[i][j]){
                    bfs(map,i,j,n,m,visited);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void bfs(char [][] map,int i,int j,int n,int m,boolean [][] visited){
        Queue<int []> q = new LinkedList<>();
        int [] dx = {1,0,-1,0};
        int [] dy = {0,1,0,-1};

        visited[i][j] = true;
        q.add(new int [] {i,j});

        while (!q.isEmpty()) {

            int [] arr = q.poll();
            int r = arr[0];
            int c = arr[1];

            for(int k = 0;k<4;k++){
                int row = r + dx[k];
                int col = c + dy[k];

                if(row >= 0 && row < n && col >= 0 && col < m && map[row][col] == '.' && !visited[row][col]){
                    visited[row][col] = true;
                    q.add(new int [] {row,col});
                }
            }
        }
    }
    /* 
    public static int solve(char [][] map,int n,int m){

        int cnt = 0;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(map[i][j] == '.'){
                  dfs(map,i,j,n,m);
                  cnt++;
                }
            }
        }

        return cnt;

    } 

    public static void dfs(char [][] map,int i,int j,int n,int m){
        if(i < 0 || i >=n || j < 0 || j >=m || map[i][j] != '.')return;

        map[i][j] = 'a';

        dfs(map,i+1,j,n,m);
        dfs(map,i,j+1,n,m);
        dfs(map,i-1,j,n,m);
        dfs(map,i,j-1,n,m);
    }
    */
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

        System.out.println(solve(map,n,m));

    }
}
