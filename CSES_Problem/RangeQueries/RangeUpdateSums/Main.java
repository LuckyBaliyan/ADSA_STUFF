//package CSES_Problem.RangeQueries.RangeUpdateSums;

import java.io.*;
import java.util.*;

public class Main {
    static long [] seg;
    static long [] arr;
    static long [] lazyAdd;
    static long [] lazySet;
    static boolean [] isSet;

    public static void build(int idx,int l,int r){
        if(l == r){
            seg[idx] = arr[l];
            return;
        }
    
        int mid = (l+r)/2;
        build(2*idx, l, mid);
        build(2*idx+1, mid+1, r);
    
        seg[idx] = seg[2*idx] + seg[2*idx+1];
    }

    public static void push(int idx,int l,int r){
        if(isSet[idx]){
            seg[idx] = (r-l+1) * lazySet[idx];

            if(l!=r){
                isSet[2*idx] = true;
                isSet[2*idx+1] = true;

                lazySet[2*idx] = lazySet[idx];
                lazySet[2*idx+1] = lazySet[idx];

                lazyAdd[2*idx] = 0;
                lazyAdd[2*idx+1] = 0;

            }

            isSet[idx] = false;
        }

        if(lazyAdd[idx] != 0){
           seg[idx] += lazyAdd[idx] * (r-l+1);

           if(l!=r){
                if(isSet[2*idx]){
                    lazySet[2*idx] += lazyAdd[idx];
                } else {
                    lazyAdd[2*idx] += lazyAdd[idx];
                }
            
                if(isSet[2*idx+1]){
                    lazySet[2*idx+1] += lazyAdd[idx];
                } else {
                    lazyAdd[2*idx+1] += lazyAdd[idx];
                }
            }

           lazyAdd[idx] = 0;
        }
    }

    public static void updateAdd(int idx,int l,int r,int ql,int qr,long val){
        push(idx, l, r);

        if(r < ql || l > qr)return;
        if(ql<= l && r <= qr){
            lazyAdd[idx] += val;
            push(idx, l, r);
            return;
        }

        int mid = l+(r-l)/2;
        updateAdd(2*idx, l, mid, ql, qr, val);
        updateAdd(2*idx+1, mid + 1, r, ql, qr, val);

        seg[idx] = seg[2*idx] + seg[2*idx+1];
    }

    public static void updateSet(int idx,int l,int r,int ql,int qr,long val){
        push(idx, l, r);

        if(r < ql || l > qr)return;
        if(ql <= l && r <= qr){
            isSet[idx] = true;
            lazyAdd[idx] = 0;
            lazySet[idx] = val;
            push(idx, l, r);
            return;
        }

        int mid = l+(r-l)/2;
        updateSet(2*idx, l, mid, ql, qr, val);
        updateSet(2*idx+1, mid+1, r, ql, qr, val);

        seg[idx] = seg[2*idx] + seg[2*idx+1];
    }

    public static long query(int idx,int l,int r,int ql,int qr){
        push(idx, l, r);

        if(r < ql || l > qr)return 0;
        if(ql<= l && r <= qr)return seg[idx];

        int mid = l+(r-l)/2;
        return query(2*idx, l, mid, ql, qr) + query(2*idx+1, mid+1, r, ql, qr);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws Exception {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws Exception {
            return Integer.parseInt(next());
        }

        long nextLong() throws Exception {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int q = fs.nextInt();

        arr = new long [n+1];

        for(int i = 1;i<=n;i++)arr[i] = fs.nextLong();

        seg = new long [4*n+5];
        lazyAdd = new long [4*n+5];
        lazySet = new long [4*n+5];
        isSet = new boolean[4*n+5];
        StringBuilder sb = new StringBuilder();

        build(1, 1, n);

        for(int i = 0;i<q;i++){
            int type = fs.nextInt();

            if(type == 1){
               int l = fs.nextInt();
               int r = fs.nextInt();
               long val = fs.nextLong();

               updateAdd(1, 1, n, l, r, val);
            }
            else if (type == 2){
               int l = fs.nextInt();
               int r = fs.nextInt();
               long val = fs.nextLong();

               updateSet(1, 1, n, l, r, val);
            }
            else{
                int l = fs.nextInt();
                int r = fs.nextInt();

                sb.append(query(1, 1, n, l, r)+"\n");
            }
        }

        System.out.println(sb.toString().trim()+" ");
    }
}