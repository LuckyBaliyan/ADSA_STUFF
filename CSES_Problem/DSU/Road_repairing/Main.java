package CSES_Problem.DSU.Road_repairing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
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
            do {
                c = readByte();
            } while (c <= ' ');
            if (c == '-') {
                sign = -1;
                c = readByte();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    static class Pair {
        int u, v;
        long weight;

        Pair(int u, int v, long weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    static int[] parent;
    static int[] size;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

 
    static void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv) return;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }

    public static long kruskal(int n, List<Pair> edges) {

        parent = new int[n+1];
        size = new int[n+1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;  
        }

        Collections.sort(edges, (a, b) -> Long.compare(a.weight,b.weight));

        long mstWeight = 0;
        int edgesUsed = 0;

        for (Pair edge : edges) {
            int u = edge.u;
            int v = edge.v;

            if (find(u) != find(v)) {
                union(u, v);
                mstWeight += edge.weight;
                edgesUsed++;
            }
        }

        if (edgesUsed != n-1) return -1;
        return mstWeight;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fc = new FastScanner();

        int n = fc.nextInt();
        int m = fc.nextInt();

        List<Pair> edges = new ArrayList<>();

        for(int i = 0;i<m;i++){
            int u = fc.nextInt();
            int v = fc.nextInt();
            int w = fc.nextInt();

            edges.add(new Pair(u, v, w));
        }
     
        //dont call these types of sensitive functions twince just store 1 answer 
        //from theme
        long ans = kruskal(n, edges);

        if(ans == -1){
            System.out.println("IMPOSSIBLE");
            return;
        }

        System.out.println(ans);
    }
}
