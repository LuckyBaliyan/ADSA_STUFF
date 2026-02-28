//package CodeForces.Graphs.C_NewsDistribution;

import java.util.Scanner;

public class Main {
    static int [] par;
    static int [] size;
    static int [] count;

    public static int find(int x){
        if(x == par[x])return x;

        return par[x] = find(par[x]);
    }

    public static void union(int u,int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv)return;

        if(size[pu] < size[pv]){
            par[pu] = pv;
            size[pv] += size[pu];
        }
        else{
            par[pv] = pu;
            size[pu] += size[pv];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        par = new int[n+1];
        count = new int [n+1];
        size = new int [n+1];

        for(int i = 0;i<=n;i++){
            par[i] = i;
            size[i] = 1;
            //count[i] = 1;
        }

        for(int i = 0;i<m;i++){
            int k = sc.nextInt();

            if(k <= 0)continue;

            int u = sc.nextInt();

            for(int j = 1;j<k;j++){
                int v = sc.nextInt();
                union(u,v);
               // count[u] += count[v] + 1;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1;i<=n;i++){
            sb.append(size[find(i)]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
