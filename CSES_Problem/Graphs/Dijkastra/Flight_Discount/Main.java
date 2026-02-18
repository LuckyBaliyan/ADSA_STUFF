package CSES_Problem.Graphs.Dijkastra.Flight_Discount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static class Pair{
        long cost;
        int node;
        int isApplied;

        Pair(long cost,int node,int isApplied){
            this.cost = cost;
            this.node = node;
            this.isApplied = isApplied;
        }
    }

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

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<m;i++){
            int u = fc.nextInt();
            int v = fc.nextInt();
            long c = fc.nextInt();

            adj.get(u).add(new Pair(c, v, 0));
        }

        long [][] min = new long[n+1][2];

        for(long [] arr:min)Arrays.fill(arr,Long.MAX_VALUE);

        min[1][0] = 0;

        PriorityQueue<Pair> q = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return Long.compare(a.cost, b.cost);  // Min-heap based on cost
            }
        });


        q.offer(new Pair(0, 1, 0));

        while(!q.isEmpty()){
            Pair pr = q.poll();

            long d = pr.cost;
            int node = pr.node;
            int cuponApplied = pr.isApplied;

            if (d > min[node][cuponApplied]) continue;


            for(Pair ne:adj.get(node)){
                int v = ne.node;
                long cost = ne.cost;
                //int cuponApplied2 = ne.isApplied;

                if(cuponApplied == 0){
                   if(d + cost < min[v][0]){
                      min[v][0] = d + cost;
                      q.offer(new Pair(min[v][0], v, 0));
                   }

                   if(d + cost/2 < min[v][1]){
                    min[v][1] = d + cost/2;
                    q.offer(new Pair(min[v][1], v, 1));
                   }
                }
                else{
                    if(d + cost < min[v][1]){
                        min[v][1] = d + cost; 
                        q.offer(new Pair(min[v][1], v, 1));
                    }
                }
            }
            
        }

        long ans =  Math.min(min[n][0],min[n][1]);
        System.out.println(ans);
    }
}
