//package CodeForces.Graphs.D_Roads_NotOnly_In_Berland;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class Main {
    static int [] par;
    static int [] size;

    public static int find (int x){
        if( x == par[x])return x;
        return  par[x] = find(par[x]);
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

        par = new int [n+1];
        size = new int [n+1];

        ArrayList<int[]> extraEdge = new ArrayList<>();
        HashSet<Integer> components = new HashSet<>();

        for(int i = 1;i<=n;i++){
            par[i] = i;
            size[i] = 1;
        }

        for(int i  = 0;i<n-1;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(find(a) != find(b)){
               union(a, b);
            }
            else if (find(a) == find(b))extraEdge.add(new int [] {a,b});
        }

        for(int i = 1;i<=n;i++){
            components.add(find(i));
        }

        ArrayList<Integer> leaders = new ArrayList<>(components);

        System.out.println(components.size() - 1);

        for(int i = 1;i<leaders.size();i++){
            int [] edge = extraEdge.get(i - 1);
            int oldu = edge[0];
            int oldv = edge[1];

            int newu = leaders.get(0);
            int newv = leaders.get(i);

            System.out.println(oldu+" "+oldv+" "+newu+" "+newv);
        }

        sc.close();
    }
}
