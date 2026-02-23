package classRoom.Graphs.DSU.DSU_CLASS_TEMPLATE;

import java.util.Scanner;

public class Main {
    static class DSU{
        public int components;
        public int [] parent;
        public int [] rank;

        public DSU(int n){
            components = n;
            parent = new int [n+1];
            rank = new int [n+1];

            for(int i = 0;i<=n;i++){
                parent[i] = i;
            }
        }

        public  void unionByRanks(int u,int v){
            int p_u = find(u);
            int p_v = find(v);

            if(p_u == p_v)return; //already part of same components

            if(rank[p_u] < rank[p_v]){
                //if anyOne is smaller then attach it height will not increase 
                //are bhai rank only increase when rank increases
                parent[p_u] = p_v;
            }
            else if(rank[p_v] < rank[p_u]){
                parent[p_v] = p_u;
            }
            else{
                // if raks are same then add anyone to anyone
                parent[p_v] = p_u;
                rank[p_u]++;
            }

            components--;
        }

        public int find(int node){
            if(node == parent[node])return node;
            //path compression reutrn find(parent[node]) will give O(log n)
            return parent[node] = find(parent[node]); 
            // will give O(1) in case of finding ultimate parent 
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        //int m = sc.nextInt();

        DSU ds = new DSU(n);

        ds.unionByRanks(1, 2);
        ds.unionByRanks(2, 3);
        ds.unionByRanks(3, 7);
        System.out.println("Disconnected Components at level 3:"+ ds.components);
        if(ds.find(1) == ds.find(3))// not better way if(ds.parent[1] == ds.parent[3])
        System.out.println("1 & 3 belongs to same component at lvl3");
        else System.out.println("1 & 3 are not in same components at lvl3");
        ds.unionByRanks(2, 3);
        ds.unionByRanks(4, 5);
        ds.unionByRanks(6, 7);
        ds.unionByRanks(5, 6);
        ds.unionByRanks(3, 7);

        System.out.println("connected Components:"+ ds.components);
        for(int i: ds.parent)System.out.print(i +" ");
        System.out.println();
        for(int r:ds.rank)System.out.print(r+" ");
        
        sc.close();
    }
}
