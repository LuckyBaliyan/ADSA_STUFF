package CodeForces.Graphs.E_CycleComponents;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int vertexCount;
    static boolean isCycle;
    static boolean [] visited;

    public static void dfs(int node,ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        vertexCount++;

        // if the curr node of the component is not connected to exactly two edges 
        // then it's not a cycle acc. to question
        if(adj.get(node).size() != 2)isCycle = false;

        for(int ne: adj.get(node)){
            if(!visited[ne]){
                dfs(ne, adj);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        visited = new boolean[n+1];

        for(int i = 0;i<=n;i++)adj.add(new ArrayList<>());

        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int cyclicComponents = 0;

        for(int i = 1;i<=n;i++){
            if(!visited[i]){
                vertexCount = 0;
                isCycle = true;
                dfs(i,adj);

                if(isCycle && vertexCount >= 3)cyclicComponents++;
            }
        }

        System.out.println(cyclicComponents);
    }
}
