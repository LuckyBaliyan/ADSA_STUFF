package CSES_Problem.RangeQueries.DynamicRangeMinQuery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Miain {
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
           //seg = new long[4*200005];
        }

        public void build_st(int idx,int l,int r){
            if(l == r){
                seg[idx] = arr[l];
                return;
            }

            int mid = l + (r-l)/2;

            build_st(2*idx, l, mid);
            build_st(2*idx+1, mid+1, r);

            seg[idx] = Math.min(seg[2*idx],seg[2*idx+1]);
        }

        public long minQuery(int ql,int qr,int idx,int l,int r){
           if(r < ql || l > qr)return Long.MAX_VALUE;
           if(ql <= l && qr >= r)return seg[idx];

           int mid = l+(r-l)/2;

           long left = minQuery(ql, qr, 2*idx, l, mid);
           long right = minQuery(ql, qr, 2*idx+1, mid + 1, r);

           return Math.min(left,right);
        }

        public void updateQuery(int qi,long val,int idx,int l,int r){
            if(l == r){
                //arr[l] = val;
                seg[idx] = val;
                return;
            }

            int mid = l+(r-l)/2;
            if(qi>=l && qi<=mid)updateQuery(qi, val, 2*idx, l, mid);
            else updateQuery(qi, val, 2*idx+1, mid+1, r);

            seg[idx] = Math.min(seg[2*idx] ,seg[2*idx+1]);
        }

        public void printSeg(){
            for(long s:seg)System.out.print(s+" ");
        }
    }
    public static void main(String[] args)  throws Exception {
       // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // StringTokenizer st = new StringTokenizer(br.readLine());

       FastScanner sc = new FastScanner();

        int n = sc.nextInt();
        int q = sc.nextInt();

        //st = new StringTokenizer(br.readLine());
        arr = new long[n+1];
        for(int i = 1;i<=n;i++)arr[i] = sc.nextLong();

        SegmentTree sg = new SegmentTree(arr);
        sg.build_st(1, 1, n);

        StringBuilder sb = new StringBuilder();

        while(q-->0){
            //st = new StringTokenizer(br.readLine());

            int type = sc.nextInt();

            if(type == 1){
                int k = sc.nextInt();
                long u = sc.nextLong();

                sg.updateQuery(k, u, 1, 1, n);
            }
            else{
                int a = sc.nextInt();
                int b = sc.nextInt();

                sb.append(sg.minQuery(a, b, 1, 1, n)+"\n");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
