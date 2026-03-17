//package CSES_Problem.Graphs.Tree_Distance_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int [] distA;
    static int [] distB;
    static int [] distC;
    static boolean [] visited;

    public static void bfs(int node,Queue<Integer> q,ArrayList<ArrayList<Integer>> adj,int [] dist){
        q.offer(node);
        visited[node] = true;

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int ne:adj.get(curr)){
                if(!visited[ne]){
                    dist[ne] = 1 + dist[curr];
                    visited[ne] = true;
                    q.offer(ne);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = n-1;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<=n;i++)adj.add(new ArrayList<>());

        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());


            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        distA = new int [n+1];
        distB = new int [n+1];
        distC = new int [n+1];
        visited = new boolean[n+1];

        Queue<Integer> q = new ArrayDeque<>();

        bfs(1,q,adj,distA);

        int A = 1;
        for(int i = 1; i <= n; i++){
            if(distA[i] > distA[A]) A = i;
        }

        Arrays.fill(visited, false);

        bfs(A,q,adj,distB);

        int B = 1;
        for(int i = 1; i <= n; i++){
            if(distB[i] > distB[B]) B = i;
        }

        Arrays.fill(visited, false);

        bfs(B,q,adj,distC);

        StringBuilder sb = new StringBuilder();

        for(int i = 1;i< distB.length;i++){
            if(distB[i] > distC[i])sb.append(distB[i]+" ");
            else sb.append(distC[i]+" ");
        }

        System.out.println(sb.toString().trim());

    }
}
