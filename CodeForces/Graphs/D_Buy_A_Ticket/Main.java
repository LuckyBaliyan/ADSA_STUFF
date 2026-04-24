package CodeForces.Graphs.D_Buy_A_Ticket;

import java.io.*;
import java.util.*;

public class Main {

    static class Pair {
        int node;
        long cost;

        Pair(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        long[] dist = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));

        for (int i = 1; i <= n; i++) {
            pq.offer(new Pair(i, dist[i]));
        }

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (curr.cost > dist[curr.node]) continue;

            for (Pair nei : adj.get(curr.node)) {
                long newCost = curr.cost + 2 * nei.cost;

                if (newCost < dist[nei.node]) {
                    dist[nei.node] = newCost;
                    pq.offer(new Pair(nei.node, newCost));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(dist[i]).append(" ");
        }

        System.out.println(sb);
    }
}