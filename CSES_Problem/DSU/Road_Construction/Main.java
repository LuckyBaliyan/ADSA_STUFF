//package CSES_Problem.DSU.Road_Construction;

public class Main {

    static int[] parent;
    static int[] size;

    static int components;
    static int maxSize = 1;

    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int readByte() throws Exception {
            if (ptr >= len) {
                len = System.in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws Exception {
            int c, sign = 1, val = 0;
            do {
                c = readByte();
            } while (c <= ' ');
            if (c == '-') {
                sign = -1;
                c = readByte();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner sc = new FastScanner();

        int n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        components = n;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            union(u, v);
            sb.append(components + " " + maxSize).append('\n');
        }

        System.out.println(sb.toString());
    }

    public static void union(int u, int v) {

        int pu = find(u);
        int pv = find(v);

        if (pu == pv) return;

        if (size[pu] > size[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
            maxSize = Math.max(maxSize, size[pu]);
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
            maxSize = Math.max(maxSize, size[pv]);
        }

        components--;
    }

    public static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}