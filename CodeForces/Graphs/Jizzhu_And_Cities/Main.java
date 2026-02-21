//package CodeForces.Graphs.Jizzhu_And_Cities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    // --- Core method to handle long ---
    long nextLong() {
        return Long.parseLong(next());
    }

    int nextInt() {
        return Integer.parseInt(next());
    }
    }
    static class Tuple {
        int node;
        long cost;
        boolean isTrain;

        Tuple(int node,long cost,boolean isTrain){
            this.node = node;
            this.cost = cost;
            this.isTrain = isTrain;
        }
    }
    public static int removeTrains(ArrayList<ArrayList<Tuple>> adj,int n,int m,int k){
        long [] costArr = new long[n + 1];
        boolean [] usedTrains = new boolean[n+1];

        Arrays.fill(costArr,Long.MAX_VALUE);
        costArr[1] = 0;

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)->Long.compare(a.cost, b.cost));

        pq.offer(new Tuple(1, 0, false));


        while(!pq.isEmpty()){
            Tuple route = pq.poll();
            int node = route.node;
            long cost = route.cost;
            boolean isTrain = route.isTrain;

            if(cost > costArr[node])continue;

            for(Tuple ne:adj.get(node)){
               int v = ne.node;
               long newCost = ne.cost + cost;
               
               if(newCost < costArr[v]){
                   costArr[v] = newCost;
                   usedTrains[v] = ne.isTrain; // tells if we use a train here or not 
                  
                   pq.offer(new Tuple(v, newCost, ne.isTrain));
               }
               else if (newCost == costArr[v]){
                //prefer road over trains
                if(usedTrains[v] && !ne.isTrain)usedTrains[v] = false;
               }
            }
        }

        int usefullTracks = 0;

        // why from 2 beacuse we will go from first node evry time capital -->
        for(int i = 2;i<=n;i++){
          if(usedTrains[i])usefullTracks++;
        }

        return k - usefullTracks;
    }
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<ArrayList<Tuple>> adj = new ArrayList<>();

        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            long xi = sc.nextLong();

            adj.get(u).add(new Tuple(v, xi, false));
            adj.get(v).add(new Tuple(u, xi, false));
        }

        for(int i = 0;i<k;i++){
            int v = sc.nextInt();
            long yi = sc.nextLong();

            adj.get(1).add(new Tuple(v, yi, true));
            adj.get(v).add(new Tuple(1, yi, true));
        }

        System.out.println(removeTrains(adj,n,m,k));
    }
}
