package CSES_Problem.DSU.Network_BreakDown;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Pair{
        int node;long cost;
        Pair(int node,long cost){
            this.node = node;
            this.cost = cost;
        }
    }
    private static final String ArrayList = null;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Pair> adj = new ArrayList<>();

        int [][] edges = new int [m][2];
        int [][] breakDowns = new int [k][2];

        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            edges[i][0] = Integer.parseInt(st.nextToken());
        }
  
    }
}