package CSES_Problem.Graphs.CourseSchedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
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

    public static void main(String[] args) throws Exception{
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

        ArrayList<Integer> topo = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        int [] inDegree = new int[n+1];

        for(int i = 1;i<=n;i++){
            for(int ne:adj.get(i))inDegree[ne]++;
        }

        for(int i = 1;i<=n;i++){
            if(inDegree[i] == 0)q.offer(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);

            for(int ne:adj.get(node)){
                inDegree[ne]--;

                if(inDegree[ne] == 0)q.offer(ne);
            }
        }

        if(topo.size() != n){
            System.out.println("IMPOSSIBLE");
            return;
        }

        for(int node:topo)System.out.print(node+" ");
    }
}
