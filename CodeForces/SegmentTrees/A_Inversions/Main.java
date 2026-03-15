package CodeForces.SegmentTrees.A_Inversions;

import java.util.Scanner;

public class Main {
    static long [] seg;
    static long [] arr;

    public static void update_St(int idx,int l,int r,long j){
        if(l==r){
            seg[idx] = 1;
            return;
        }

        int mid = l+(r-l)/2;
        if(j <= mid)update_St(2*idx, l, mid, j);
        else update_St(2*idx+1, mid + 1, r, j);

        seg[idx] = seg[2*idx] + seg[2*idx+1];
    }

    public static long query(int idx,int l,int r,long ql,int qr){
        if(r < ql || l > qr)return 0;
        if(ql<=l && r <= qr)return seg[idx];

        int mid = l+(r-l)/2;
        return query(2*idx, l, mid, ql, qr) + query(2*idx+1, mid + 1, r, ql, qr);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        seg = new long[4*n+5];
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<n;i++){
            long j = sc.nextLong();

            sb.append(query(1,1,n,j+1,n)+"\n");
            update_St(1,1,n,j);
        }

        System.out.println(sb.toString().trim());
        sc.close();
    }
}
