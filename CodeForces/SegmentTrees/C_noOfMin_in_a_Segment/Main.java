//package CodeForces.SegmentTrees.C_noOfMin_in_a_Segment;

import java.util.Scanner;

public class Main {
    static long [] arr;

    static class Pair{
        long val;int cnt;

        Pair(long val,int cnt){
            this.val = val;
            this.cnt = cnt;
        }
    }

    static class SegmentTree{
        public Pair [] seg;

        SegmentTree(long [] arr){
           int n = arr.length;
           seg = new Pair[4*n];
        }

        public void build_st(int idx,int l,int r){
            if(l == r){
                seg[idx] = new Pair(arr[l],1);
                return;
            }

            int mid = l + (r-l)/2;

            build_st(2*idx+1, l, mid);
            build_st(2*idx+2, mid+1, r);

            seg[idx] = merge(seg[2*idx+1],seg[2*idx+2]);
        }

        public Pair minQuery(int ql,int qr,int idx,int l,int r){
           if(r < ql || l > qr)return new Pair(Long.MAX_VALUE, 0);
           if(ql <= l && qr >= r)return seg[idx];

           int mid = l+(r-l)/2;

           Pair left = minQuery(ql, qr, 2*idx+1, l, mid);
           Pair right = minQuery(ql, qr, 2*idx+2, mid + 1, r);

           return merge(left, right);
        }

        public void updateQuery(int qi,long val,int idx,int l,int r){
            if(l == r){
                //arr[l] = val;
                seg[idx] = new Pair(val, 1);
                return;
            }

            int mid = l+(r-l)/2;
            if(qi>=l && qi<=mid)updateQuery(qi, val, 2*idx+1, l, mid);
            else updateQuery(qi, val, 2*idx+2, mid+1, r);

            seg[idx] = merge(seg[2*idx+1], seg[2*idx+2]);
        }

        public Pair merge(Pair p1,Pair p2){
            long a = p1.val;
            int cnta = p1.cnt;

            long b = p2.val;
            int cntb = p2.cnt;

            if(a < b)return p1;
            if(b < a)return p2;

            return new Pair(a, cnta + cntb);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new long [n];
        for(int i = 0;i<n;i++)arr[i] = sc.nextInt();

        SegmentTree sg = new SegmentTree(arr);
        sg.build_st(0, 0, n-1);

        StringBuilder sb = new StringBuilder();

        while(m-->0){
            int type = sc.nextInt();

            if(type == 1){
                int i = sc.nextInt();
                int v = sc.nextInt();

                sg.updateQuery(i, v, 0, 0, n-1);
            }
            else{
               int l = sc.nextInt();
               int r = sc.nextInt();

               Pair res = sg.minQuery(l, r-1, 0, 0, n-1);
               sb.append(res.val+" "+res.cnt+"\n");
            }
        }

        System.out.println(sb.toString().trim());

        sc.close();
    }
}
