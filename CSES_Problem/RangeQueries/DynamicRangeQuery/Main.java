package CSES_Problem.RangeQueries.DynamicRangeQuery;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static long [] arr;

    static class SegmentTree{
        public long [] seg;

        SegmentTree(long [] arr){
           int n = arr.length;
           //seg = new long[4*n];
           seg = new long[4*200005];
        }

        public void build_st(int idx,int l,int r){
            if(l == r){
                seg[idx] = arr[l];
                return;
            }

            int mid = l + (r-l)/2;

            build_st(2*idx, l, mid);
            build_st(2*idx+1, mid+1, r);

            seg[idx] = seg[2*idx] + seg[2*idx+1];
        }

        public long sumQuery(int ql,int qr,int idx,int l,int r){
           if(r < ql || l > qr)return 0;
           if(ql <= l && qr >= r)return seg[idx];

           int mid = l+(r-l)/2;

           long left = sumQuery(ql, qr, 2*idx, l, mid);
           long right = sumQuery(ql, qr, 2*idx+1, mid + 1, r);

           return left + right;
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

            seg[idx] = seg[2*idx] + seg[2*idx+1];
        }

        public void printSeg(){
            for(long s:seg)System.out.print(s+" ");
        }
    }
    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new long[n+1];
        for(int i = 1;i<=n;i++)arr[i] = Long.parseLong(st.nextToken());

        SegmentTree sg = new SegmentTree(arr);
        sg.build_st(1, 1, n);

        StringBuilder sb = new StringBuilder();

        while(q-->0){
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());

            if(type == 1){
                int k = Integer.parseInt(st.nextToken());
                long u = Long.parseLong(st.nextToken());

                sg.updateQuery(k, u, 1, 1, n);
            }
            else{
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                sb.append(sg.sumQuery(a, b, 1, 1, n)+"\n");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
