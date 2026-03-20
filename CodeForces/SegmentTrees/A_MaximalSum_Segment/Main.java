package CodeForces.SegmentTrees.A_MaximalSum_Segment;

import java.util.Scanner;

public class Main {
    static Node [] seg;
    static long [] arr;

    static class Node{
        long sum,pref,suff,ans;

        Node(long sum,long pref,long suff,long ans){
            this.sum = sum;
            this.pref = pref;
            this.suff = suff;
            this.ans = ans;
        }
    }

    public static void build_St(int idx,int l,int r){
        if(l==r){
            //if neg value we can't take them
            seg[idx] = new Node(
                arr[l],
               Math.max(arr[l],0),
               Math.max(arr[l],0),
               Math.max(arr[l],0)
            );

            return;
        }

        int mid = l+(r-l)/2;

        build_St(2*idx, l, mid);
        build_St(2*idx+1, mid + 1, r);

        seg[idx] = merge(seg[2*idx], seg[2*idx+1]);
    }

    public static void update_St(int qi,int idx,long val,int l,int r){
        if(l==r){
           seg[idx] = new Node(val,Math.max(val,0),Math.max(val,0),Math.max(val,0));
           return;
        }

        int mid = l+(r-l)/2;
        if(qi<=mid)update_St(qi, 2*idx, val, l, mid);
        else update_St(qi, 2*idx + 1, val, mid + 1, r);

        seg[idx] = merge(seg[2*idx], seg[2*idx+1]);
    }

    public static Node merge(Node left,Node right){
        long sum = left.sum + right.sum;
        long suff = Math.max(right.suff,right.sum + left.suff);
        long pref = Math.max(left.pref,left.sum + right.pref);
        long ans = Math.max(Math.max(left.ans, right.ans), left.suff + right.pref);

        return new Node(sum, pref, suff, ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new long[n+1];
        seg = new Node[4*n];

        for(int i = 1;i<=n;i++)arr[i] = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        build_St(1, 1, n);

        sb.append(seg[1].ans+"\n");

        while(m-->0){

            int i = sc.nextInt();
            long val = sc.nextLong();

            //beacuse they gave i from 0 so i+1
            update_St(i+1, 1, val, 1, n);

            sb.append(seg[1].ans+"\n");
        }

        System.out.println(sb.toString().trim()+"\n");
        sc.close();
    }
}
