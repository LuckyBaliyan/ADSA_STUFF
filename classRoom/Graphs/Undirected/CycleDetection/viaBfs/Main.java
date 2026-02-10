package classRoom.Graphs.Undirected.CycleDetection.viaBfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
    public static boolean bfs(ArrayList<ArrayList<Integer>> adj,boolean [] visited
        ,int src
    ){
        Queue<int []> q = new ArrayDeque<>();
        visited[src] = true;
        q.add(new int [] {src,-1});

        while(!q.isEmpty()){
            int [] curr = q.poll();
            int node = curr[0];
            int parent = curr[1];

            for(int i:adj.get(node)){
                if(!visited[i]){
                    visited[i] = true;
                    q.offer(new int [] {i,node});
                }

                else if ( i !=  parent)return true;
            }
        }

        return false;
    }
    public static boolean detecCycle(int [][] edges,int V){
        boolean [] visited = new boolean[V];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int [] e:edges){
           adj.get(e[0]).add(e[1]);
           adj.get(e[1]).add(e[0]);
        }

        for(int i = 0;i<V;i++){
            if(!visited[i]){
                if(bfs(adj,visited,i))return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        System.out.println(detecCycle(new int [][] {{0,1},{0,2},{1,2},{2,3}},4));
    }
}
