package infosys_HackwithInfy.Graphs.Beauty;

import java.io.*;
import java.util.*;

public class Main {

    static int[] par;
    static int[] size;
    static int[] adj;

    static int find(int x) {
        if (par[x] == x) return x;
        return par[x] = find(par[x]);
    }

    static void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv) return;

        if (size[pu] >= size[pv]) {
            par[pv] = pu;
            size[pu] += size[pv];
            adj[pu] += adj[pv];

            if (Math.abs(u - v) == 1)
                adj[pu]++;

        } else {
            par[pu] = pv;
            size[pv] += size[pu];
            adj[pv] += adj[pu];

            if (Math.abs(u - v) == 1)
                adj[pv]++;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int q = Integer.parseInt(br.readLine().trim());
        int t = Integer.parseInt(br.readLine().trim());

        par = new int[n + 1];
        size = new int[n + 1];
        adj = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            par[i] = i;
            size[i] = 1;
            adj[i] = 0;
        }

        long beauty = 0;

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            } else {
                int u = Integer.parseInt(st.nextToken());
                int root = find(u);
                beauty += size[root] - adj[root];
            }
        }

        System.out.println(beauty);
    }
}