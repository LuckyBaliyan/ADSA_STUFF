package classRoom.Graphs.Directed.Dijkastra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

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
    static class Pair {
        int node;
        long weight;

        Pair(long weight,int node){
            this.weight = weight;
            this.node = node;
        }
        
    }
    public static void Dijkastra(long [] paths,ArrayList<ArrayList<Pair>> adj){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Long.compare(a.weight,b.weight));
        pq.offer(new Pair(0, 1));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u=curr.node;
            long d=curr.weight;

            if(d > paths[u]) continue;

            for(Pair ne:adj.get(u)){
                int v = ne.node;
                long w = ne.weight;

                if(d + w < paths[v]){
                    paths[v] = d + w;
                    pq.offer(new Pair(paths[v],v));
                }
            }
        }

    }
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0;i<=n;i++){
           adj.add(new ArrayList<>());
        }

        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            long w = sc.nextInt();

            adj.get(u).add(new Pair(w, v));
        }

        long [] paths = new long[n+1];
        Arrays.fill(paths,Long.MAX_VALUE);
        paths[1] = 0;
        Dijkastra(paths,adj);

        for(long x : paths){
            if( x != Long.MAX_VALUE)
            System.out.print(x+" ");
        }
    }
}
