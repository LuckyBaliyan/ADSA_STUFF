package CSES_Problem.RangeQueries.RangeUpdateQuery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long [] arr;
    static long [] seg;
    static long [] lazy;

    static class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    String nextLine() throws IOException {
        return br.readLine();
    }
}

    public static void build_st(int idx,int l,int r){
        if(l==r){
            seg[idx] = arr[l];
            return;
        }

        int mid = (l+r)/2;

        build_st(2*idx, l, mid);
        build_st(2*idx+1, mid+1, r);

        seg[idx] = seg[2*idx] + seg[2*idx+1];
    }

    public static void push(int idx,int l,int r){
        if(lazy[idx] != 0){
            seg[idx]+= (r-l+1)*lazy[idx];

            if(l!=r){
                lazy[2*idx] += lazy[idx];
                lazy[2*idx+1] += lazy[idx];
            }

            lazy[idx] = 0;
        }
    }
    
    public static void range_update(int ql,int qr,int idx,long val,int l,int r){
        push(idx, l, r);

        if(r < ql || l > qr)return;
        if(ql <= l && r <= qr){
          lazy[idx] += val;
          push(idx,l,r);
          return;
        }

        int mid = (l+r)/2;
        range_update(ql, qr, 2*idx, val, l, mid);
        range_update(ql, qr, 2*idx+1, val, mid+1, r);

        seg[idx] = seg[2*idx] + seg[2*idx+1];
        
    }

    public static long query(int idx,int k,int l,int r){
       push(idx, l, r);

       int mid = (l+r)/2;
       if(l == r)return seg[idx];

       if(k <= mid) return query(2*idx, k, l, mid);
       else return query(2*idx+1, k, mid+1, r);
    }
    public static void main(String[] args) throws IOException {
   
        FastScanner fc = new FastScanner();

       int n = fc.nextInt();
       int q = fc.nextInt();

       arr = new long[n+1];
       seg = new long[4*n + 5];
       lazy = new long[4*n + 5];

       StringBuilder sb = new StringBuilder();

       for(int i = 1;i<=n;i++)arr[i] = fc.nextLong();

       build_st(1, 1, n);

       while(q-->0){
           int type = fc.nextInt();

           if(type == 1){
            int a = fc.nextInt();
            int b = fc.nextInt();
            long u = fc.nextLong();

            range_update(a, b, 1, u, 1, n);
            
           }
           else{

            int k = fc.nextInt();

            sb.append(query(1,k,1,n)+"\n");
           }
       }

       System.out.println(sb.toString().trim());
    }
}
