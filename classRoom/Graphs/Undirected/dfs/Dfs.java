package classRoom.Graphs.Undirected.dfs;

import java.util.ArrayList;

public class Dfs {
    public static void dfsRec(ArrayList<ArrayList<Integer>> adj,int src,boolean [] visited,
        ArrayList<Integer> res){
        visited[src] = true;
        res.add(src);

        for(int i:adj.get(src)){
            if(!visited[i]){
                dfsRec(adj, i, visited, res);
            }
        }
    }

    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj){
        boolean [] visited = new boolean[adj.size()];
        ArrayList<Integer> res = new ArrayList<>();

        dfsRec(adj, 0, visited, res);
        return res;   
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < 7; i++){
            adj.add(new ArrayList<>());
        }
        
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(3);
        
        adj.get(1).add(4);
        adj.get(1).add(5);
        adj.get(1).add(6);

        System.out.println(dfs(adj));
    }
}
