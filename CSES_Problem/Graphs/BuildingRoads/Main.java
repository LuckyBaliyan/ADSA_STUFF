package CSES_Problem.Graphs.BuildingRoads;

import java.util.ArrayList;

public class Main {
    static  ArrayList<Integer> leaders;

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

    public static int getRoads(ArrayList<ArrayList<Integer>> adj,int n,int m,
        boolean [] visited,ArrayList<Integer> ans){

        for(int i = 1;i<=n;i++){
            if(!visited[i]){
                ans.add(i);
                dfsRec(adj, i, n, m, visited, ans);
            }
        }

        return ans.size() - 1;

    }
    public static void dfsRec(ArrayList<ArrayList<Integer>> adj,int node,int n,int m,
        boolean []visited,ArrayList<Integer> ans){
        visited[node] = true;

        for(int i: adj.get(node)){
            if(!visited[i]){
                dfsRec(adj, i, n, m, visited, ans);
            }
        }
    }
    public static void main(String[] args) throws Exception{
        FastScanner sc = new FastScanner();

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<=n;i++){
           adj.add(new ArrayList<>());
        }

        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean [] visited = new boolean[n+1];
        leaders = new ArrayList<>();
        System.out.println(getRoads(adj,n,m,visited,leaders));
        for(int i = 1;i<leaders.size();i++){
            System.out.println(leaders.get(i-1)+" "+leaders.get(i));
        }

    }
}
