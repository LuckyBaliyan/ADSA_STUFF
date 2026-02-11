//package CSES_Problem.Graphs.RoundTrip2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Main {
    static  ArrayList<Integer> ans = new ArrayList<>();
    static  Stack<Integer> st = new Stack<>();
    static class FastScanner {
    private final byte[] buffer = new byte[1 << 16]; // 64 KB
    private int ptr = 0, len = 0;

    private int readByte() throws Exception {
        if (ptr >= len) {
            len = System.in.read(buffer);
            ptr = 0;
            if (len <= 0) return -1;
        }
        return buffer[ptr++];
    }

    int nextInt() throws Exception {
        int c, sign = 1, val = 0;

        // skip whitespace
        do {
            c = readByte();
        } while (c <= ' ');

        // handle negative numbers
        if (c == '-') {
            sign = -1;
            c = readByte();
        }

        // read digits
        while (c > ' ') {
            val = val * 10 + (c - '0');
            c = readByte();
        }
        return val * sign;
    }
    }
    public static void main(String[] args) throws Exception {
        FastScanner fc = new FastScanner();

        int n = fc.nextInt();
        int m = fc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<=n;i++){
          adj.add(new ArrayList<>());
        }

        for(int i = 0;i<m;i++){
            int u = fc.nextInt();
            int v = fc.nextInt();

            adj.get(u).add(v);
        }

        int [] visitedPath = new int [n+1];
        boolean found = false;
        
        for(int i = 1;i<=n;i++){
            if(visitedPath[i] == 0){
                // here if the first component dose't have cycle so IMPOSSIBLE 
                // will be Printed IMMIDIATELY but we should check all components first
                /*if(!dfs(adj,visitedPath,st,i)){
                    System.out.println("IMPOSSIBLE");
                    return;
                }*/

                if(dfs(adj,visitedPath,st,i,ans)){
                    found = true;
                    break;
                }
            }
        }

        if(!found){
        System.out.println("IMPOSSIBLE");
        return;
        }

        System.out.println(ans.size());

        for(int city:ans){
            System.out.print(city+" ");
        }

    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> adj,int [] visitedPath,
        Stack<Integer> st,int node,ArrayList<Integer> ans){
        visitedPath[node] = 2;
        st.push(node);

        for(int ne:adj.get(node)){
            if(visitedPath[ne] == 0){
                if(dfs(adj, visitedPath, st, ne,ans))return true;
            }

            else if(visitedPath[ne] == 2){
                // if cycle exsist add the nodes only contributing to thar cycle

                ArrayList<Integer> temp = new ArrayList<>();
                for(int i = st.size() - 1;i>=0;i--){
                    temp.add(st.get(i));

                    if(st.get(i) == ne)break;
                }

                Collections.reverse(temp);
                temp.add(ne); // add again start at end to show the cycle

                ans.clear();
                ans.addAll(temp);

                return true;
            }
        }

        //bactrack State 
        visitedPath[node] = 1;
        st.pop();
        return false;
    }
}
