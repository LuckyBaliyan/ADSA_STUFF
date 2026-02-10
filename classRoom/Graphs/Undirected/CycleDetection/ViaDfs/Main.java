package classRoom.Graphs.Undirected.CycleDetection.ViaDfs;

import java.util.ArrayList;

public class Main {
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean [] visited,
      int node,int parent
    ){
        visited[node] = true;

        for(int i:adj.get(node)){
            if(!visited[i]){
                if(dfs(adj, visited, i, node))return true;
            }

            else if (i != parent)return true;
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
                if(dfs(adj,visited,i,-1))return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        System.out.println(detecCycle(new int [][] {{0,1},{0,2},{1,2},{2,3}},4));
    }
}
