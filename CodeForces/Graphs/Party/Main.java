//package CodeForces.Graphs.Party;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int dfs(int node,int [] parent,
        ArrayList<ArrayList<Integer>> adj){
        int maxLen = 0;

        for(int ne:adj.get(node)){
            maxLen = Math.max(maxLen, dfs(ne, parent, adj));
        }

        return maxLen + 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();


        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        //The trick is from evry parent (root) i.e -1 we are cehcking maxDepth
        int [] parent = new int [n+1];

        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 1; i <= n; i++){
            parent[i] = sc.nextInt();

            if(parent[i] != -1){
                adj.get(parent[i]).add(i);
            }
        }


        int ans = 0;

        for(int i = 1;i<=n;i++){
           if(parent[i] == -1){
            ans = Math.max(ans,dfs(i,parent,adj));
           }
        }

        System.out.println(ans);
    }
}
