package CSES_Problem.dP_on_graphs.Dijkastra.Investigation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static final int MOD = 1000000007;
    static class Pair{
        int node;
        long price;
        Pair(int node,long price){
            this.node = node;
            this.price = price;
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

        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());
        
        for(int i = 0;i<m;i++){
           int u = fc.nextInt();
           int v = fc.nextInt();

           long price = fc.nextInt();
           adj.get(u).add(new Pair(v, price));
        }

        PriorityQueue<Pair> q = 
        new PriorityQueue<>((a,b)->Long.compare(a.price, b.price));

        int [] ways = new int[n+1];
        int [] minFlights = new int [n+1];
        int [] maxFlights = new int [n+1];

        long [] cost = new long [n+1];
        Arrays.fill(cost,Long.MAX_VALUE);
        cost[1] = 0;
        
        q.offer(new Pair(1, 0));
        ways[1] = 1;
        minFlights[1] = 0;
        maxFlights[1] = 0;

        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.node;
            long d = p.price;

            if(d > cost[node])continue;

            for(Pair ne:adj.get(node)){
                int v = ne.node;
                long price = ne.price;

                if(d + price < cost[v]){
                   cost[v] = d + price;
                   ways[v] = ways[node];
                   minFlights[v] = minFlights[node] + 1;
                   maxFlights[v] = maxFlights[node] + 1;

                   q.offer(new Pair(v, cost[v]));
                }
                else if(d + price == cost[v]){
                    ways[v] = (ways[v] + ways[node])%MOD;
                    minFlights[v] = Math.min(
                                      minFlights[v],
                                      minFlights[node]+1
                                    );
                    maxFlights[v] = Math.max(
                        maxFlights[v], 
                        maxFlights[node] + 1
                    ); 
                }
            }
        }

        System.out.println(cost[n] +" "+ways[n]+
        " "+minFlights[n]+" "+maxFlights[n]);
    }
}
