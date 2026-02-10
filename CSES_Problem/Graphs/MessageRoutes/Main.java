package CSES_Problem.Graphs.MessageRoutes;

import java.util.ArrayDeque;
import java.util.ArrayList;
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

    public static void bfs(ArrayList<ArrayList<Integer>> adj,boolean [] visited,int src,
        int [] Path){
        Queue<Integer> q = new ArrayDeque<>();

        visited[src] = true;
        Path[src] = -1;
        q.offer(src);

        while(!q.isEmpty()){
            int node = q.poll();

            for(int i:adj.get(node)){
                if(!visited[i]){
                    visited[i] = true;
                    Path[i] = node;
                    q.add(i);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        FastScanner fc = new FastScanner();

        int n = fc.nextInt();
        int m = fc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        boolean [] visited = new boolean[n+1];
        int [] Path = new int [n+1];

        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<m;i++){
            int u = fc.nextInt();
            int v = fc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        /*for(int i = 1;i<=n;i++){
            if(!visited[i]){
                bfs(adj,visited,i,Path);
            }
        }*/  // hey i'ts not multi source BFS we have to only start from 1 

        bfs(adj, visited, 1, Path);



        if(!visited[n]){
            System.out.println("IMPOSSIBLE");
            return;
        }

        ArrayList<Integer> route = new ArrayList<>();

        int cur = n;
        while (cur != -1) {
            route.add(cur);
            cur = Path[cur];
        }
        
        System.out.println(route.size());
        for (int i = route.size() - 1; i >= 0; i--) {
            System.out.print(route.get(i) + " ");
        }
    }
}
