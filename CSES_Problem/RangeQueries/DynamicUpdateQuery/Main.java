//package CSES_Problem.RangeQueries.DynamicUpdateQuery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long [] arr;
    
      
    static class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    String nextLine() throws IOException {
        return br.readLine();
    }
  }

   static class SegmentTree{
        public long [] seg;

        SegmentTree(long [] arr){
           int n = arr.length;
           seg = new long[4*n];
           Arrays.fill(seg,0);
        }

        public void updateQuery(int ql,int qr,long val,int idx,int l,int r){
            // no overlap
            if(r < ql || l > qr) return;

            // complete overlap
            if(ql <= l && r <= qr){
                seg[idx] += val;
                return;
            }

            int mid = l+(r-l)/2;

            updateQuery(ql, qr, val, 2*idx, l, mid);
            updateQuery(ql, qr, val, 2*idx+1, mid+1, r);
        }

        public long getUpdated(int k,int idx,int l,int r){
            if(l == r)return seg[idx];

            int mid = l+(r-l)/2;

            if(k<=mid)return seg[idx] + getUpdated(k, 2*idx, l, mid);
            else return seg[idx] + getUpdated(k, 2*idx+1, mid+1, r);
        }

        public void printSeg(){
            for(long s:seg)System.out.print(s+" ");
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fc = new FastScanner();
        int n = fc.nextInt();
        int q = fc.nextInt();

        arr = new long[n+1];
        for(int i = 1;i<=n;i++)arr[i] = fc.nextLong();

        SegmentTree sg = new SegmentTree(arr);
        StringBuilder sb = new StringBuilder();

        while(q-->0){
            int type = fc.nextInt();

            if(type == 1){
                int a = fc.nextInt();
                int b = fc.nextInt();
                long u = fc.nextLong();

                sg.updateQuery(a, b, u, 1, 1, n);
            }
            else{
                int k = fc.nextInt();
                sb.append(arr[k]+sg.getUpdated(k, 1,1, n)+"\n");
            }
        }

        System.out.println(sb.toString().trim());
    }

}
