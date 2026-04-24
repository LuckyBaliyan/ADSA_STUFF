//package CodeForces.Graphs.Kafka_And_Parks;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int ans;
    static int [] cats;
    static ArrayList<ArrayList<Integer>> adj;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        cats =  new int [n+1];
        for(int i = 1; i<=n; i++){
            cats[i] = sc.nextInt();
        }

        adj = new ArrayList<>();

        for(int i = 0; i<=n; i++)adj.add(new ArrayList<>());

        for(int i = 0; i<n-1; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        ans = 0;

        dfs(1, -1, 0);

        System.out.println(ans);

    }

    public static void dfs(int node, int par, int consicutiveCats){
        if(cats[node] == 1){
           consicutiveCats++;
        }
        else consicutiveCats = 0;

        if(consicutiveCats > m)return;

        boolean isLeaf = true;
        for(int ne : adj.get(node)){
            if(ne != par){
                isLeaf = false;
                dfs(ne, node, consicutiveCats);
            }
        }

        if(isLeaf){
            ans++;
        }
    }
}
