//package CSES_Problem.Graphs.RoundingTrip1;

import java.util.ArrayList;
import java.util.Collections;


public class Main {
    public static ArrayList<Integer> res;
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
    public static void main(String[] args) throws Exception {
        FastScanner fc = new FastScanner();

        int n = fc.nextInt();
        int m = fc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i =0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i =0;i<m;i++){
            int u = fc.nextInt();
            int v = fc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean [] visited = new boolean[n+1];
        int [] parent = new int [n+1];
        res = new ArrayList<>();

        boolean found = false;

        for(int i = 1;i<=n;i++){
            if(!visited[i]){
                if(dfs(i,-1,visited,parent,adj)){
                    found = true;
                    break;
                }
            }
        }

        if(!found){
            System.out.println("IMPOSSIBLE");
            return;
        }

        System.out.println(res.size());

        for(int city:res)System.out.print(city+" ");
    }

    public static boolean dfs(int node,int p,boolean [] visited,int [] parent,
    ArrayList<ArrayList<Integer>> adj
    ){
        visited[node] = true;

        for(int ne:adj.get(node)){
          if(!visited[ne]){
            parent[ne] = node;
            if(dfs(ne, node, visited, parent, adj))return true;
          }
          else if(ne != p){

             int curr = node;
             res.add(ne);


             while(curr != ne){
                res.add(curr);
                curr = parent[curr];
             }

             res.add(ne);
             Collections.reverse(res);
             return true;
          }
        }
        return false;
    }
}
