//package CSES_Problem.Graphs.GameRoutes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<=n;i++){
           adj.add(new ArrayList<>());
        }

        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
        }

        //boolean [] visited = new boolean[n+1];

        int res = bfs(1,adj,n);
        System.out.println(res);
    }

    public static int bfs(int node,ArrayList<ArrayList<Integer>> adj,int n){
        //visited[node] = true;
        q.offer(node);
        int cnt = 0;

        while(!q.isEmpty()){
            int curr = q.poll();

            if(n == curr){
                cnt++;
            }

            for(int ne:adj.get(curr)){
                q.offer(ne);
            }
        }

        return cnt;
    }
}
