package classRoom.Graphs.CycleDetection.ViaDfs;

import java.util.ArrayList;
import java.util.Scanner;

public class Detect {
    public static boolean isCycle(ArrayList<ArrayList<Integer>> adj,int src,boolean [] visited,int parent){
        visited[src] = true;

        for(int neighbour: adj.get(src)){
            if(!visited[neighbour]){
                isCycle(adj, neighbour, visited, src);
            }
            else if (neighbour !=  parent){
              return true;
            }
        }

        return false;
        
    }

    public static boolean dfsCycle(ArrayList<ArrayList<Integer>> adj){
        boolean [] visited = new boolean[adj.size()];

        for(int u = 0;u<adj.size();u++){
            if(!visited[u]){
                if(isCycle(adj, u, visited, -1))return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();


        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        System.out.println(dfsCycle(adj));

        sc.close();
    }
}
