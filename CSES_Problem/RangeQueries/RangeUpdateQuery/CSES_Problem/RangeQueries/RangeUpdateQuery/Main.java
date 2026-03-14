package CSES_Problem.RangeQueries.RangeUpdateQuery;

import java.io.*;
import java.util.*;

class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreElements()) {
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

    String nextLine() throws IOException {
        return br.readLine();
    }
}

public class Main {
    static int[] arr;
    static long[] st;
    static long[] lazy;
    public static void build(int i, int l, int r) {
        if (l == r) {
            st[i] = arr[l];
            return;
        }
        int mid = l + (r-l)/2;
        build(2*i+1, l, mid);
        build(2*i+2, mid+1, r);
        st[i] = st[2*i+1] + st[2*i+2];
    }
    public static void update(int i, int l, int r, int ql, int qr, int u) {
        if (lazy[i] != 0) {
            st[i] += (r-l+1)*lazy[i];
            if (l != r) {
                lazy[2*i+1] += lazy[i];
                lazy[2*i+2] += lazy[i];
            }
            lazy[i] = 0;
        }
        // completely outside
        if (r < ql || qr < l) {
            return;
        }
        // completely inside
        if (ql <= l && r <= qr) {
            st[i] += (r-l+1)*u;
            if (l != r) {
                lazy[2*i+1] += u;
                lazy[2*i+2] += u;
            }
            return;
        }
        // overlapping
        int mid = l + (r-l)/2;
        update(2*i+1, l, mid, ql, qr, u);
        update(2*i+2, mid+1, r, ql, qr, u);
        st[i] = st[2*i+1] + st[2*i+2];
    }
    public static long query(int i, int l, int r, int idx) {
        if (lazy[i] != 0) {
            st[i] += (r-l+1)*lazy[i];
            if (l != r) {
                lazy[2*i+1] += lazy[i];
                lazy[2*i+2] += lazy[i];
            }
            lazy[i] = 0;
        }
        if (l == r) {
            return st[i];
        }
        int mid = l + (r-l)/2;
        if (idx <= mid) {
            return query(2*i+1, l, mid, idx);
        } else {
            return query(2*i+2, mid+1, r, idx);
        }
    }
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int q = sc.nextInt();
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        st = new long[4*n];
        lazy = new long[4*n];
        build(0, 0, n-1);
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            int type = sc.nextInt();
            if (type == 1) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int u = sc.nextInt();
                update(0, 0, n-1, a-1, b-1, u);
            } else if (type == 2) {
                int k = sc.nextInt();
                long ans = query(0, 0, n-1, k-1);
                // System.out.println(ans);
                sb.append(ans).append("\n");
            }
        }
        System.out.println(sb.toString().trim());
    }
}