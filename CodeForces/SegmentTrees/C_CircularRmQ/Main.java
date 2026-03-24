//package CodeForces.SegmentTrees.C_CircularRmQ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long [] seg;
    static long [] lazy;
    static long [] arr;

    public static void build_st(int idx,int l,int r){
        if(l == r){
            seg[idx] = arr[l];
            return;
        }

        int mid = l+(r-l)/2;
        build_st(2*idx+1, l, mid);
        build_st(2*idx+2, mid+1, r);

        seg[idx] = Math.min(seg[2*idx+1],seg[2*idx+2]);
    }

    public static void update_st(int idx,int l,int r,int ql,int qr,long val){
        if(lazy[idx] != 0){
            seg[idx] += lazy[idx];
            if(l!=r){
                lazy[2*idx+1] += lazy[idx];
                lazy[2*idx+2] += lazy[idx];
            }

            lazy[idx] = 0;
        }

        if(r < ql || l >qr)return;
        if(ql <= l && r <= qr){
            seg[idx] += val;
            if(l!=r){
                lazy[2*idx+1] += val;
                lazy[2*idx+2] += val;
            }
            return;
        }

        int mid = l+(r-l)/2;
        update_st(2*idx+1, l, mid, ql, qr, val);
        update_st(2*idx+2, mid+1, r, ql, qr, val);

        seg[idx] = Math.min(seg[2*idx+1],seg[2*idx+2]);
    }

    public static long query(int idx,int l,int r,int ql,int qr){
        if(lazy[idx]!= 0){
            seg[idx] += lazy[idx];

            if(l!=r){
                lazy[2*idx+1] += lazy[idx];
                lazy[2*idx+2] += lazy[idx];
            }

            lazy[idx] = 0;
        }

        if(r < ql || l > qr)return Long.MAX_VALUE;
        if(ql <=  l && r <= qr)return seg[idx];

        int mid = l+(r-l)/2;
        return Math.min(query(2*idx+1, l, mid, ql, qr),query(2*idx+2, mid+1, r, ql, qr));
    }

    public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    arr = new long[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) arr[i] = Long.parseLong(st.nextToken());

   
    seg = new long[4 * n];
    lazy = new long[4 * n];


    build_st(0, 0, n - 1);

    StringBuilder sb = new StringBuilder();


    int m = Integer.parseInt(br.readLine());

    for(int i = 0; i < m; i++){
        String queryType = br.readLine();

        StringTokenizer qt = new StringTokenizer(queryType);

        int l = Integer.parseInt(qt.nextToken());
        int r = Integer.parseInt(qt.nextToken());

        if(qt.hasMoreTokens()){
            long v = Long.parseLong(qt.nextToken());

            if(l <= r) update_st(0, 0, n - 1, l, r, v);
            else{
                update_st(0, 0, n - 1, l, n - 1, v);
                update_st(0, 0, n - 1, 0, r, v);
            }
        }
        else{
            long ans;
            if(l <= r) ans = query(0, 0, n - 1, l, r);
            else{
                ans = Math.min(
                    query(0, 0, n - 1, l, n - 1),
                    query(0, 0, n - 1, 0, r)
                );
            }
            sb.append(ans).append("\n");
        }
    }

    System.out.println(sb.toString().trim());
  }
}