package RangeQueries.Concepts.LazyPropagation;

import java.util.Scanner;

class Main{
    static int [] seg;
    static int [] lazy;
    static int [] arr;

    public static void build_st(int idx,int l,int r){
        if(l == r){
            seg[idx] = arr[l];
            return;
        }

        int mid = l+(r-l)/2;
        build_st(2*idx+1, l, mid);
        build_st(2*idx+2, mid+1, r);

        seg[idx] = seg[2*idx+1] + seg[2*idx+2];
    }

    public static void update_st(int idx,int l,int r,int ql,int qr,int val){
        if(lazy[idx] != 0){
            seg[idx] += lazy[idx] * (r-l+1);

            //cehck if has lower childs or not i.e not leaf
            if(l!= r){
                lazy[2*idx+1] += lazy[idx];
                lazy[2*idx+2] += lazy[idx];
            }

            lazy[idx] = 0;
        } 

        if(r < ql || l > qr)return;
        if(ql<= l && r <= qr){
            seg[idx] += val * (r-l+1);
            
            if(l!=r){
                lazy[2*idx+1] += val;
                lazy[2*idx+2] += val;
            }

            return;
        }

        int mid = l+(r-l)/2;
        update_st(2*idx+1, l, mid, ql, qr, val);
        update_st(2*idx+2, mid + 1, r, ql, qr, val);

        seg[idx] = seg[2*idx+1] + seg[2*idx+2];
    }

    public static int query(int idx,int l,int r,int ql,int qr){
        if(lazy[idx]!= 0){
            seg[idx] += lazy[idx] * (r - l + 1);
            if(l!= r){
                lazy[2*idx+1] += lazy[idx];
                lazy[2*idx+2] += lazy[idx];
            }

            lazy[idx] = 0;
        }

        if(r < ql || l > qr)return 0;
        if(ql<= l && r <= qr)return seg[idx];

        int mid = l+(r-l)/2;
        return query(2*idx+1, l, mid, ql, qr) + query(2*idx + 2, mid + 1, r, ql, qr);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        seg = new int [4*n];
        lazy = new int [4*n];
        arr = new int [n];

        for(int i = 0;i<n;i++)arr[i] = sc.nextInt();

        build_st(0,0,n-1);
        int res = 0;

        for(int i = 0;i<m;i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            int val = sc.nextInt();

            update_st(0,0,n-1,l,r,val);
            //random query

            res += query(0, 0, n-1, l, r);
        }

        for(int x:seg)System.out.print(x+" ");
        System.out.println();
        for(int x:lazy)System.out.print(x+" ");
        System.out.println();
        
        System.out.println(res);

        sc.close();
    }
}