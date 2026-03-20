//package CodeForces.SegmentTrees.A_Knights;

import java.util.Scanner;

public class Main {
    static int [] seg;
    static int [] res;

    public static void build_St(int idx,int l,int r){
        if(l == r){
            //initially everyOne is alive
            seg[idx] = 1;
            return;
        }

        int mid = l+(r-l)/2;
        build_St(2*idx, l, mid);
        build_St(2*idx+1, mid + 1, r);

        seg[idx] = seg[2*idx] + seg[2*idx+1];
    }

    public static void update_St(int idx,int l,int r,int ql,int qr,int xi){
        if(seg[idx] == 0 || r < ql || l > qr)return;

        if(l == r){
            if(l != xi){
               //add the winner at diffrent knight as dead index
               res[l] = xi;
               //dead the knight
               seg[idx] = 0;
            }
            return;
        }

        int mid = l+(r-l)/2;
        update_St(2*idx, l, mid, ql, qr, xi);
        update_St(2*idx+1, mid + 1, r, ql, qr, xi);

        seg[idx] = seg[2*idx] + seg[2*idx+1];
    } 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n  = sc.nextInt();
        int m = sc.nextInt();

        seg = new int [4*n+5];
        res = new int [n+1];

        build_St(1, 1, n);

        for(int i = 0;i<m;i++){
            int li = sc.nextInt();
            int ri = sc.nextInt();
            int xi = sc.nextInt();

            update_St(1,1,n,li,ri,xi);
        }

        for(int i = 1;i<=n;i++)System.out.print(res[i]+" ");
        sc.close();
    }
}
