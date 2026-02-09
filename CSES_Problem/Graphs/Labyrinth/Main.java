//package CSES_Problem.Graphs.Labyrinth;

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

    public static String getPath(Pair start,Pair end,Pair[][] parent){
        ArrayList<Pair> path = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        Pair curr = end;
        path.add(curr);

        while(!(curr.x == start.x && curr.y == start.y)){
            curr = parent[curr.x][curr.y];
            path.add(curr);
        }

        //Collections.reverse(path);

        for(int i = path.size()-1;i > 0;i--){
            Pair a = path.get(i);
            Pair next = path.get(i-1);

            if(a.x == next.x+1)sb.append("U");
            if(a.x == next.x - 1)sb.append("D");
            if(a.y == next.y + 1)sb.append("L");
            if(a.y == next.y - 1)sb.append("R");
        }

        //sb.reverse();

        return sb.toString();
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

                if(nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc] ||
                    grid[nr][nc] == '#'
                )continue;

                q.offer(new Pair(nr, nc));
                visited[nr][nc] = true;
                Parent[nr][nc] = new Pair(x, y);

                if(grid[nr][nc] == 'B')return true;
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

        Pair start = new Pair(-1,-1);

        int ex = -1;
        int ey = -1;

        Pair end = new Pair(ex, ey);

        for(int i= 0;i<n;i++){
            String s = sc.next();
            for(int j = 0;j<m;j++){
                grid[i][j] = s.charAt(j);
                if(grid[i][j] == 'A'){
                    sr = i;
                    sy = j;
                    start = new Pair(sr,sy);
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
        System.out.println(found?"YES":"NO");

        if(!found)return;

        String path = getPath(start, end, Parent);
        System.out.println(path.length());
        System.out.println(path);
    }
}
