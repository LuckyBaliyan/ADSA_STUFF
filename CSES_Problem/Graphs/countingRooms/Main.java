//package CSES_Problem.Graphs.countingRooms;

import java.util.Scanner;

public class Main {
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
