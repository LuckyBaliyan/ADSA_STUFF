package CSES_Problem.RangeQueries.XorSumQueries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
           //seg = new long[4*n];
           seg = new long[4*n];
        }

        public void build_st(int idx,int l,int r){
            if(l == r){
                seg[idx] = arr[l];
                return;
            }

            int mid = l + (r-l)/2;

            build_st(2*idx, l, mid);
            build_st(2*idx+1, mid+1, r);

            seg[idx] = seg[2*idx] ^ seg[2*idx+1];
        }

        public long xorQuery(int ql,int qr,int idx,int l,int r){
           if(r < ql || l > qr)return 0;
           if(ql <= l && qr >= r)return seg[idx];

           int mid = l+(r-l)/2;

           long left = xorQuery(ql, qr, 2*idx, l, mid);
           long right = xorQuery(ql, qr, 2*idx+1, mid + 1, r);

           return left ^ right;
        }

        public void updateQuery(int qi,long val,int idx,int l,int r){
            if(l == r){
                arr[l] = val;
                seg[idx] = val;
                return;
            }

            int mid = l+(r-l)/2;
            if(qi>=l && qi<=mid)updateQuery(qi, val, 2*idx, l, mid);
            else updateQuery(qi, val, 2*idx+1, mid+1, r);

            seg[idx] = seg[2*idx] ^ seg[2*idx+1];
        }

        public void printSeg(){
            for(long s:seg)System.out.print(s+" ");
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fc = new FastScanner();

        int n = fc.nextInt();
        int q = fc.nextInt();

        arr = new long [n+1];
        for(int i = 1;i<=n;i++)arr[i] = fc.nextLong();

        SegmentTree s = new SegmentTree(arr);
        s.build_st(1, 1, n);

        StringBuilder sb = new StringBuilder();


        while(q-->0){
            int ql  = fc.nextInt();
            int qr = fc.nextInt();

            sb.append(s.xorQuery(ql,qr,1,1,n)+"\n");
        }

        System.out.println(sb.toString().trim());
    }
}
