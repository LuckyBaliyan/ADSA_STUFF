package infosys_HackwithInfy.Practice;

import java.io.InputStream;
import java.io.IOException;

import java.util.*;

public class Main5 {
    static long MOD = 1000000007;
    static long INV2 = 500000004;
    static long[] seg, lazyX, lazyY;
    static boolean[] hasLazy;

    static void build(long[] arr, int node, int l, int r) {
        if (l == r) {
            seg[node] = arr[l] % MOD;
            return;
        }
        int mid = (l + r) / 2;
        build(arr, 2 * node, l, mid);
        build(arr, 2 * node + 1, mid + 1, r);
        seg[node] = (seg[2 * node] + seg[2 * node + 1]) % MOD;
    }

    static long getSum(long a, long d, long n) {
        long term1 = (2 * a) % MOD;
        long term2 = ((n - 1) % MOD * (d % MOD)) % MOD;
        long sum = (n % MOD * (term1 + term2) % MOD) % MOD;
        return (sum * INV2) % MOD;
    }

    static void push(int node, int l, int r) {
        if (hasLazy[node]) {
            int mid = (l + r) / 2;
            
            long xL = lazyX[node];
            long yL = lazyY[node];
            int lenL = mid - l + 1;
            lazyX[2 * node] = xL;
            lazyY[2 * node] = yL;
            hasLazy[2 * node] = true;
            seg[2 * node] = getSum(xL, yL, lenL);

            long xR = (xL + (long)lenL * yL) % MOD;
            long yR = yL;
            int lenR = r - mid;
            lazyX[2 * node + 1] = xR;
            lazyY[2 * node + 1] = yR;
            hasLazy[2 * node + 1] = true;
            seg[2 * node + 1] = getSum(xR, yR, lenR);

            hasLazy[node] = false;
        }
    }

    static void update(int node, int l, int r, int ql, int qr, long x, long y) {
        if (r < ql || l > qr) return;
        if (l >= ql && r <= qr) {
            long startVal = (x + (long)(l - ql) * y) % MOD;
            lazyX[node] = startVal;
            lazyY[node] = y % MOD;
            hasLazy[node] = true;
            seg[node] = getSum(startVal, y % MOD, r - l + 1);
            return;
        }
        push(node, l, r);
        int mid = (l + r) / 2;
        update(2 * node, l, mid, ql, qr, x, y);
        update(2 * node + 1, mid + 1, r, ql, qr, x, y);
        seg[node] = (seg[2 * node] + seg[2 * node + 1]) % MOD;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        long[] A = new long[n];
        for (int i = 0; i < n; i++) A[i] = sc.nextLong();

        seg = new long[4 * n];
        lazyX = new long[4 * n];
        lazyY = new long[4 * n];
        hasLazy = new boolean[4 * n];

        build(A, 1, 0, n - 1);

        if (!sc.hasNextInt()) {
            System.out.println((seg[1] + MOD) % MOD);
            return;
        }
        
        int q = sc.nextInt();
        while (q-- > 0) {
            int ql = sc.nextInt();
            int qr = sc.nextInt();
            long x = sc.nextLong();
            long y = sc.nextLong();
            update(1, 0, n - 1, ql, qr, x, y);
        }

        System.out.println((seg[1] + MOD) % MOD);
    }
}

/* 
public class Main5 {
    static class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int head, tail;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            if (head >= tail) {
                head = 0;
                try {
                    tail = stream.read(buf, 0, buf.length);
                } catch (IOException e) {
                    return -1;
                }
                if (tail <= 0) return -1;
            }
            return buf[head++];
        }

        public long nextLong() {
            int c = read();
            while (c <= 32) {
                if (c == -1) return -1;
                c = read();
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = read();
            }
            long res = 0;
            while (c > 32) {
                res = res * 10 + c - '0';
                c = read();
            }
            return negative ? -res : res;
        }

        public int nextInt() {
            return (int) nextLong();
        }
    }

    static int find(int i, int[] parent) {
        int root = i;
        while (root != parent[root]) {
            root = parent[root];
        }
        int curr = i;
        while (curr != root) {
            int nxt = parent[curr];
            parent[curr] = root;
            curr = nxt;
        }
        return root;
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        if (n == -1) return;
        long[] A = new long[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextLong();
        }
        int q = sc.nextInt();
        int[][] queries = new int[q][4];
        for (int i = 0; i < q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
            queries[i][2] = sc.nextInt();
            queries[i][3] = sc.nextInt();
        }

        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int j = q - 1; j >= 0; j--) {
            int l = queries[j][0];
            int r = queries[j][1];
            long x = queries[j][2];
            long y = queries[j][3];

            int curr = find(l, parent);
            while (curr <= r) {
                A[curr] = x + (curr - l) * y;
                parent[curr] = curr + 1;
                curr = find(curr, parent);
            }
        }

        long sum = 0;
        long MOD = 1000000007;
        for (int i = 0; i < n; i++) {
            sum = (sum + (A[i] % MOD)) % MOD;
        }
        System.out.println(sum);
    }
}

*/