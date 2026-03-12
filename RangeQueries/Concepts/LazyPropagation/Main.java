package RangeQueries.Concepts.LazyPropagation;

import java.util.Scanner;

public class Main {
    static long [] arr;
    static long [] seg;
    static long [] lazy;

    public static void build_st(int idx,int l,int r){
        if(l==r){
            seg[idx] = arr[l];
            return;
        }

        int mid = l+(r-l)/2;
        build_st(2*idx+1, l, mid);
        build_st(2*idx+2, mid+1, r);

        seg[idx] = seg[2*idx+1] + seg[2*idx+2];
    }

    public static void range_update(int idx,int ql,int qr,int l,int r,long nv){
        if(lazy[idx] != 0){
           seg[idx]+= (r-l+1)*lazy[idx];
           if(l!=r){
            lazy[2*idx+1] += lazy[idx];
            lazy[2*idx+2] += lazy[idx];
           }
           lazy[idx] = 0;
        }

        if(r < ql || l > qr)return;

        if(ql<= l && r <= qr){
            seg[idx] += (r-l+1)*nv;

            if(l!=r){
                lazy[2*idx+1] += nv;
                lazy[2*idx+2] += nv;
            }

            return;
        }

        int mid = l+(r-l)/2;
        range_update(2*idx+1, ql, qr, l, mid, nv);
        range_update(2*idx+2, ql, qr, mid+1, r, nv);

        seg[idx] = seg[2*idx+1] + seg[2*idx+2];
    }

    public static long query(int idx,int ql,int qr,int l,int r){
        if(lazy[idx] != 0){
           seg[idx]+= (r-l+1)*lazy[idx];
           if(l!=r){
            lazy[2*idx+1] += lazy[idx];
            lazy[2*idx+2] += lazy[idx];
           }
           lazy[idx] = 0;
        }

        if(r < ql || l > qr)return 0;
        if(ql<= l && r <= qr){
          return seg[idx];
        }

        int mid = l+(r-l)/2;
        long left = query(2*idx+1, ql, qr, l, mid);
        long right = query(2*idx+2, ql, qr, mid+1, r);

        return left+right;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        arr = new long [n];
        seg = new long [4*n];
        lazy = new long[4*n];

        for(int i = 0;i<n;i++)arr[i] = sc.nextInt();

        build_st(0,0,n-1);
        StringBuilder sb = new StringBuilder();

        /*for(long s:seg)System.out.print(s+" ");
        System.out.println();
        for(long l:lazy)System.out.print(l+" ");*/

        while(q-->0){
            int type = sc.nextInt();

            if(type == 1){
              int l = sc.nextInt();
              int r = sc.nextInt();

              sb.append(query(0, l, r, 0, n-1)+"\n");
            }
            else{
              int ql = sc.nextInt();
              int qr = sc.nextInt();
              long val = sc.nextInt();

              range_update(0, ql, qr, 0, n-1, val);
            }
        }

        System.out.println(sb.toString().trim());
        
        for(long s:seg)System.out.print(s+" ");
        System.out.println();
        for(long l:lazy)System.out.print(l+" ");
        sc.close();
    }
}
