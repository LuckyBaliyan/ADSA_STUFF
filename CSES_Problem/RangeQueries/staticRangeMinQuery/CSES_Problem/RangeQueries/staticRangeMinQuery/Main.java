package CSES_Problem.RangeQueries.staticRangeMinQuery;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long [] arr;

    static class SegmentTree{
        public long [] seg;

        SegmentTree(long [] arr){
           int n = arr.length;
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

            seg[idx] = Math.min(seg[2*idx], seg[2*idx+1]);
        }

        public long minQuery(int ql,int qr,int idx,int l,int r){
           if(r < ql || l > qr)return Long.MAX_VALUE;
           if(ql <= l && qr >= r)return seg[idx];

           int mid = l+(r-l)/2;

           long left = minQuery(ql, qr, 2*idx, l, mid);
           long right = minQuery(ql, qr, 2*idx+1, mid + 1, r);

           return Math.min(left,right);
        }

        public void printSeg(){
            for(long s:seg)System.out.print(s+" ");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        arr = new long[n+1];
        st = new StringTokenizer(br.readLine());

        for(int i = 1;i<=n;i++)arr[i] = Integer.parseInt(st.nextToken());

        SegmentTree sg = new SegmentTree(arr);
        sg.build_st(1,1,n);

        StringBuilder sb = new StringBuilder();

        while(q--> 0){
            st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            sb.append(sg.minQuery(l, r, 1, 1, n)+"\n");
        }

        System.out.println(sb.toString().trim());
    }
}
