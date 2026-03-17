package CSES_Problem.Graphs.Tree_Diameter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pair{
        int node, dist;
        Pair(int node,int dist){
            this.node = node;
            this.dist = dist;
        }
    }

    static int [] visited;


    public static Pair bfs(Pair p,Queue<Pair> q,int n,ArrayList<ArrayList<Pair>> adj){
         visited = new int[n + 1];
         q.clear();
     
         Pair max = p;
         q.offer(p);
         visited[p.node] = 1;

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            if(curr.dist > max.dist){
                max = curr;
            }

            for(Pair  ne: adj.get(curr.node)){
                if(visited[ne.node]  == 0){
                    visited[ne.node] = 1;
                    q.offer(new Pair(ne.node, curr.dist + 1));
                }
            }
        }

        return max;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = n-1;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0;i<=n;i++)adj.add(new ArrayList<>());

        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj.get(u).add(new Pair(v, 0));
            adj.get(v).add(new Pair(u, 0));
        }

        Queue<Pair> q = new LinkedList<>();
        visited = new int[n + 1];

        Pair start = new Pair(1, 0);
        visited[start.node] = 1;

        Pair A = bfs(start,q,n,adj);
        Pair B = bfs(new Pair(A.node, 0), q, n, adj);

        System.out.println(B.dist);
    }
}
