//package CodeForces.SegmentTrees.Step1.B_SegmentTreeForTheMin;

import java.util.Scanner;

public class Main {
    static long [] arr;
    static long [] st;

    public static long minQuery(int ql,int qr,int idx,int l,int r){
        if(r < ql || l > qr)return Long.MAX_VALUE;
        if(ql <=l && r <= qr)return st[idx];

        int mid = l + (r-l)/2;

        long left = minQuery(ql, qr, 2*idx+1, l, mid);
        long right = minQuery(ql, qr, 2*idx+2, mid+1, r);

        return Math.min(left,right);
    }

    public static void updateQuery(int qi,long val,int idx,int l,int r){
        if(l == r){
            st[idx] = val;
            return;
        }

        int mid = l+(r-l)/2;
        if(l<= qi && qi<=mid)updateQuery(qi, val, 2*idx+1, l, mid);
        else updateQuery(qi, val, 2*idx+2, mid+1, r);

        st[idx] = Math.min(st[2*idx+1] , st[2*idx+2]);
    }

    public static void build_st(int idx,int l,int r){
        if(l == r){
            st[idx] = arr[l];
            return;
        }

        int mid = l + (r-l)/2;

        build_st(2*idx+1, l, mid);
        build_st(2*idx+2, mid+1, r);

        st[idx] = Math.min(st[2*idx+1] , st[2*idx+2]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new long[n+1];
        st = new long[4*n];

        for(int i = 0;i<n;i++)arr[i] = sc.nextLong();

        build_st(0,0,n-1);
        StringBuilder sb = new StringBuilder();

        while(m-->0){
            int type = sc.nextInt();

            if(type == 1){
                int qi = sc.nextInt();
                long v = sc.nextLong();

                updateQuery(qi, v, 0, 0, n-1);
            }
            else{
                int ql = sc.nextInt();
                int qr = sc.nextInt();

                sb.append(minQuery(ql, qr-1, 0, 0, n-1)+"\n");
            }
        }

        System.out.println(sb.toString().trim());
    }
}