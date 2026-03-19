//package CSES_Problem.BinaryLifiting.PlanetQueries;

import java.io.*;

public class Main {
    static final int LOG = 31;
    static int[][] up;

    // Fast Scanner
    static class FastReader {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastReader() {
            in = System.in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0)
                    return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;

            do {
                c = read();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = read();
            }

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }

            return val * sign;
        }
    }

    static int query(int x, int k) {
        for (int j = 0; j < LOG; j++) {
            if ((k & (1 << j)) != 0) {
                x = up[x][j];
                if (x == 0)
                    return -1;
            }
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        StringBuilder sb = new StringBuilder();

        int n = fr.nextInt();
        int q = fr.nextInt();

        up = new int[n + 1][LOG];

        // read parents
        for (int i = 1; i <= n; i++) {
            up[i][0] = fr.nextInt();
        }

        // binary lifting precompute
        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                int mid = up[i][j - 1];
                up[i][j] = (mid == 0) ? 0 : up[mid][j - 1];
            }
        }

        // queries
        while (q-- > 0) {
            int x = fr.nextInt();
            int k = fr.nextInt();

            sb.append(query(x, k)).append("\n");
        }

        System.out.print(sb);
    }
}
