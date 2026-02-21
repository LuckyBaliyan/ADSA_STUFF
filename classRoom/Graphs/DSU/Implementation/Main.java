package classRoom.Graphs.DSU.Implementation;

import java.util.Scanner;

public class Main {
    static int [] par,rank;
    public static int find(int x){
        if(par[x] != x)return find(par[x]);
        return x;
    }
    public static void union(int u,int v){
       int uParent = find(u);
       int vParent = find(v);
   
       if(uParent == vParent) return;
   
       if(rank[uParent] > rank[vParent]){
           par[vParent] = uParent;
       }
       else if(rank[uParent] < rank[vParent]){
           par[uParent] = vParent;
       }
       else{
           par[vParent] = uParent; 
           rank[uParent]++;          
       }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        par = new int[n+1];
        rank = new int[n+1];

        for(int i = 0;i<=n;i++){
            par[i] = i;
            rank[i] = 0;
        }

        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            union(u,v);
        }

        for(int x : par)System.out.print(x+" ");

        if(find(1) == find(2))System.out.println("Connected");
        else System.out.println("Not Connected");
    }
}
