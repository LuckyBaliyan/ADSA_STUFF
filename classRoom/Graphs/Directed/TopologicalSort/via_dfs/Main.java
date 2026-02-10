package classRoom.Graphs.Directed.TopologicalSort.via_dfs;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void dfs(ArrayList<ArrayList<Integer>> adj,boolean [] visited,
        Stack<Integer> st,int node
    ){
       visited[node] = true;

       for(int ne: adj.get(node)){
          if(!visited[ne]){
            dfs(adj,visited,st,ne);
          }
       }

       st.push(node);
    }

    public static void topologicalSort(int V,int E,int [][] edges){
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

       for(int i = 0;i<V;i++){
        adj.add(new ArrayList<>());
       }
     
       for(int [] e:edges){
        adj.get(e[0]).add(e[1]);
       }

       boolean [] visited = new boolean[V];
       Stack<Integer> st = new Stack<>();

       for(int i =0;i<V;i++){
        if(!visited[i]){
            dfs(adj,visited,st,i);
        }
       }

       while(!st.isEmpty()){
        int node = st.pop();
        System.out.print(node+" ");
       }

    }
    public static void main(String[] args) {
        //Asumming given graph is DAG (Directed Acyclic Graph)
        topologicalSort(6,6,new int [][] {{1,3},{2,3},{4,1},{4,0},{5,0},{5,2}});
    }
}
