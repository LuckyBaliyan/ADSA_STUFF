package CSES_Problem.Graphs.Monsters;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int [] dr = {-1,1,0,0};
    static int [] dc = {0,0,-1,1};
    static class Pair {
       int x;
       int y;

       Pair(int x,int y){
        this.x = x;
        this.y = y;
       }
        
    }

    public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    char [][] map = new char[n][m];
    boolean [][] visited = new boolean[n][m];

    int [][] Monsters = new int[n][m];
    int [][] soilder = new int[n][m];

    for(int i = 0; i < n; i++){
        Arrays.fill(Monsters[i], Integer.MAX_VALUE);
    }

    Pair start = new Pair(0, 0);
    Queue<Pair> q = new LinkedList<>();

    for(int i = 0; i < n; i++){
        String s = br.readLine();   // read full row

        for(int j = 0; j < m; j++){
            map[i][j] = s.charAt(j);

            if(map[i][j] == 'A'){
                start.x = i;
                start.y = j;
                visited[i][j] = true;
            }

            if(map[i][j] == 'M'){
                Monsters[i][j] = 0;
                q.offer(new Pair(i, j));
            }
        }
    }

    bfsMonsters(q, Monsters, map, n, m);

    Pair parent[][] = new Pair[n][m];

    Queue<Pair> q2 = new LinkedList<>();
    q2.offer(start);

    Pair end = new Pair(0, 0);

    if(!bfsSoilder(q2, map, parent, Monsters, soilder, visited, n, m, end)){
        System.out.println("NO");
        return;
    }

    // Track path
    ArrayList<Pair> path = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    Pair curr = end;
    path.add(end);

    while(!(curr.x == start.x && curr.y == start.y)){
        curr = parent[curr.x][curr.y];
        path.add(curr);
    }

    for(int i = path.size()-1; i > 0; i--){
        Pair a = path.get(i);
        Pair next = path.get(i-1);

        if(a.x == next.x+1) sb.append("U");
        if(a.x == next.x-1) sb.append("D");
        if(a.y == next.y+1) sb.append("L");
        if(a.y == next.y-1) sb.append("R");
    }

    System.out.println("YES");
    System.out.println(sb.length());
    System.out.println(sb.toString());
}

    public static boolean bfsSoilder(Queue<Pair> q2,char [][] grid,Pair [][] parent,
        int [][] Monsters,int [][] soilder,boolean[][] visited,
        int n,int m,Pair end){

            while(!q2.isEmpty()){
              Pair curr = q2.poll();
              int r = curr.x;
              int c = curr.y;

              if(r == 0 ||r == n-1 || c == 0 || c == m-1){
                end.x = r;
                end.y = c;
                return true; 
              }

              for(int i = 0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >=0 && nr < n && nc >=0 && nc < m && grid[nr][nc] != '#' && !visited[nr][nc]){
                    if(soilder[r][c] + 1 < Monsters[nr][nc]){
                        soilder[nr][nc] =  soilder[r][c] + 1;
                        parent[nr][nc] = new Pair(r, c);

                        visited[nr][nc] = true;
                        q2.offer(new Pair(nr, nc));
                    }
                }
              }
            }
       
       return false;
    }

    public static void bfsMonsters(Queue<Pair> q,int [][] Monsters,char [][] grid,int n,int m){
       while(!q.isEmpty()){
         Pair curr = q.poll();
         int r = curr.x;
         int c = curr.y;

         for(int i = 0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr >=0 && nr < n && nc >=0 && nc < m && grid[nr][nc] != '#'){
                if(Monsters[r][c] + 1 < Monsters[nr][nc]){
                    Monsters[nr][nc] = Monsters[r][c] + 1;
                    q.offer(new Pair(nr, nc));
                }
            }
         }
       }
    }
}
