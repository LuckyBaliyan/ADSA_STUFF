package CSES_Problem.Graphs.Labyrinth;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static boolean [][] visited;
    static int [] dr = {-1,1,0,0};
    static int [] dc = {0,0,-1,1};
    static Queue<Pair> q = new ArrayDeque<>();

    static class Pair{
        int x,y;
        Pair(int x,int y){
          this.x = x;
          this.y = y;
        }
    }

    public static String getPath(Pair start,Pair end,Pair Parent){
        ArrayList<Pair> path = new ArrayList<>();
        path.add(end);

        int x1 = end.x;
        int y1 = end.y;



    }

    public static boolean bfs(char [][] grid,int n,int m,int sr,int sc,boolean [][] visited,
        Pair [][] Parent,Queue<Pair> q
    ){
        q.offer(new Pair(sr, sc));
        visited[sr][sc] = true;

        while(!q.isEmpty()){
            Pair p = q.poll();

            int x = p.x;
            int y = p.y;

            for(int i = 0;i<4;i++){
                int nr = x + dr[i];
                int nc = y + dc[i];

                if(nr < 0 || nr >= n || nc < 0 || nc > m || visited[nr][nc] ||
                    grid[nr][nc] == '#'
                )continue;

                if(grid[nr][nc] == 'B')return true;

                q.offer(new Pair(nr, nc));
                visited[nr][nc] = true;
                Parent[nr][nc] = new Pair(x, y);
            }
        }

        return false;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char [][] grid = new char[n][m];
        visited = new boolean[n][m];

        int sr = -1;
        int sy = -1;

        Pair start;

        int ex = -1;
        int ey = -1;

        Pair end;

        for(int i= 0;i<n;i++){
            String s = sc.next();
            for(int j = 0;j<m;j++){
                grid[i][j] = s.charAt(j);
                if(grid[i][j] == 'A'){
                    sr = i;
                    sy = j;
                    start = new Pair(sr, sy);
                }
                else if(grid[i][j] == 'B'){
                    ex = i;
                    ey = j;
                    end =  new Pair(ex, ey);
                }
            }
        }

        Pair [][] Parent = new Pair[n][m];

        boolean found = bfs(grid,n,m,sr,sy,visited,Parent,q);
        System.out.println(found?"Yes":"No");
    }
}
