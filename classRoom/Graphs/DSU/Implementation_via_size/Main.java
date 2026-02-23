package classRoom.Graphs.DSU.Implementation_via_size;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int [] parent;
    static int [] size;

    static int components;
    static int maxSize = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n+1];
        for(int i = 1;i<=n;i++)parent[i] = i;
        size = new int [n+1];
        Arrays.fill(size,1);

        components = n;

        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            DSU_bysize(u,v,parent,size);
        }

        System.out.println(components+" "+maxSize);
    }

    public static void DSU_bysize(int u,int  v,int [] parent,int [] size){
        int ul_pu = find(u,parent);
        int ul_pv = find(v,parent);

        if(ul_pu == ul_pv)return;

        if(size[ul_pu] > size[ul_pv]){
            parent[ul_pv] = ul_pu;
            size[ul_pu] = size[ul_pu];

            maxSize = Math.max(maxSize, ul_pu);
        }
        else{
            parent[ul_pu] = ul_pv;
            size[ul_pv] = size[ul_pv];

            maxSize = Math.max(maxSize, ul_pv);
        }

        components--;
    }

    public static int find(int x,int [] parent){
        if(x == parent[x])return x;
        return parent[x] =  find(parent[x], parent);
    }
}
