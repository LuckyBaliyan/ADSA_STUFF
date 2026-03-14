//package CodeForces.SegmentTrees.B_K_ones;

import java.util.Scanner;

public class Main {
    static long [] seg;
    static long [] arr;

    public static void build_St(int idx,int l,int r){
        if(l == r){
            seg[idx] = arr[l];
            return;
        }

        int mid = l+(r-l)/2;
        build_St(2*idx,l,mid);
        build_St(2*idx+1,mid+1,r);

        seg[idx] = seg[2*idx] + seg[2*idx+1]; //will count total one's out there 
    }

    public static void update_St(int qi,int idx,int l,int r){
        if(l==r){
            seg[idx] = (seg[idx] == 1)?0:1;
            return;
        }

        int mid = l+(r-l)/2;
        if(qi<=mid)update_St(qi, 2*idx, l, mid);
        else update_St(qi, 2*idx+1, mid+1, r);

        seg[idx] = seg[2*idx] + seg[2*idx+1];
    }

    public static long getKthone(long k,int idx,int l,int r){
        if(k > seg[idx])return -1;
        if(l==r)return l - 1;

        int mid = l+(r-l)/2;
        if(seg[2*idx] >= k)return getKthone(k, 2*idx, l, mid);
        else return getKthone(k - seg[2*idx], 2*idx+1, mid + 1, r);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new long [n+1];
        seg = new long[4*n+5];

        for(int i = 1;i<=n;i++)arr[i] = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        build_St(1, 1, n);

        while(m-->0){
            int type = sc.nextInt();
            
            if(type == 1){
               int i = sc.nextInt();
               update_St(i+1, 1, 1, n);
            }
            else{
               int k = sc.nextInt();
               sb.append(getKthone(k+1, 1, 1, n)+"\n");
            }
        }

        System.out.println(sb.toString().trim());
        sc.close();
    }
}
