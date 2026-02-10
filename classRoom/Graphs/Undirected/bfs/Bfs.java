package classRoom.Graphs.Undirected.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> res = new ArrayList<>();
        boolean [] visited = new boolean[adj.size()];

        Queue<Integer> q = new LinkedList<>();
        visited[0] = true;
        q.offer(0);

        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
           
            for(int i:adj.get(node)){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int V = 4;
        
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        adj.get(0).add(1);
        adj.get(1).add(0);
        
        adj.get(0).add(2);
        adj.get(2).add(0);
        
        adj.get(1).add(3);
        adj.get(3).add(1);
        
        adj.get(2).add(3);
        adj.get(3).add(2);

        System.out.println(bfs(adj));
    }
}
