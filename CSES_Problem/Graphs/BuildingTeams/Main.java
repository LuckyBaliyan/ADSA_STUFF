//package CSES_Problem.Graphs.BuildingTeams;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class FastScanner {
    private final byte[] buffer = new byte[1 << 16]; // 64 KB
    private int ptr = 0, len = 0;

    private int readByte() throws Exception {
        if (ptr >= len) {
            len = System.in.read(buffer);
            ptr = 0;
            if (len <= 0) return -1;
        }
        return buffer[ptr++];
    }

    int nextInt() throws Exception {
        int c, sign = 1, val = 0;

        // skip whitespace
        do {
            c = readByte();
        } while (c <= ' ');

        // handle negative numbers
        if (c == '-') {
            sign = -1;
            c = readByte();
        }

        // read digits
        while (c > ' ') {
            val = val * 10 + (c - '0');
            c = readByte();
        }
        return val * sign;
    }
    }
    public static void main(String[] args) throws Exception{
        FastScanner fc = new FastScanner();

        int n = fc.nextInt();
        int m = fc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<m;i++){
            int u = fc.nextInt();
            int v = fc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<int []> q = new LinkedList<>();
        //boolean[] visited = new boolean[n+1];
        int [] teams = new int[n+1];  

        for(int i = 1;i<=n;i++){
            if(teams[i] == 0){
              if(!bfs(i,q,teams,adj)){
                System.out.println("IMPOSSIBLE");
                return;
               }
            }
        }

        for(int team : teams){
            if(team != 0)
            System.out.print(team + " ");
        }
    }

    public static boolean bfs(int node,Queue<int[]> q,
        int [] teams, ArrayList<ArrayList<Integer>> adj){
        teams[node] = 1;
        q.offer(new int [] {node,1});

        while (!q.isEmpty()) {
            int [] curr = q.poll();

            int i = curr[0];
            int team =  curr[1];

            for(int ne: adj.get(i)){
                if(teams[ne] == 0){
                  int newTeam = team == 1?2:1;
                  teams[ne] = newTeam;
                  q.offer(new int [] {ne,newTeam}); 
                }
                else if(teams[ne] == team)return false;
            }
            
        }

        return true;
    }
}
