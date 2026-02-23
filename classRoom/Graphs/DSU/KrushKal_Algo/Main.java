package classRoom.Graphs.DSU.KrushKal_Algo;

import java.util.*;

public class Main {

    static class Pair {
        int u, v, weight;

        Pair(int u, int v, int weight) {
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

    public static int kruskal(int n, List<Pair> edges) {

        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;  
        }

        Collections.sort(edges, (a, b) -> a.weight - b.weight);

        int mstWeight = 0;
        int edgesUsed = 0;

        for (Pair edge : edges) {
            int u = edge.u;
            int v = edge.v;

            if (find(u) != find(v)) {
                union(u, v);
                mstWeight += edge.weight;
                edgesUsed++;

                if (edgesUsed == n - 1) break;
            }
        }

        return mstWeight;
    }

    public static void main(String[] args) {
        int n = 4;

        List<Pair> edges = new ArrayList<>();
        edges.add(new Pair(0, 1, 5));
        edges.add(new Pair(1, 2, 3));
        edges.add(new Pair(0, 2, 1));

        int result = kruskal(n, edges);
        System.out.println("MST Weight: " + result);
    }
}