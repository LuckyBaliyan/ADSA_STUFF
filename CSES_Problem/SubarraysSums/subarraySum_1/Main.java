//package CSES_Problem.SubarraysSums.subarraySum_1;

import java.util.HashMap;

public class Main {
    static class FastScanner {
    private final byte[] buffer = new byte[1 << 16]; // 64 KB
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

        do { c = readByte(); } while (c <= ' ');

        if (c == '-') { sign = -1; c = readByte(); }

        while (c > ' ') {
            val = val * 10 + (c - '0');
            c = readByte();
        }
        return val * sign;
    }

    long nextLong() throws Exception {
        int c;
        long sign = 1, val = 0;

        do { c = readByte(); } while (c <= ' ');

        if (c == '-') { sign = -1; c = readByte(); }

        while (c > ' ') {
            val = val * 10 + (c - '0');
            c = readByte();
        }
        return val * sign;
    }
}
    public static int getNumberOfSubarrays(long [] arr, int n, long x){
        HashMap<Long, Integer> map = new HashMap<>();
        long prefix = 0;
        int cnt = 0;

        //handle answern exsist in start
        map.put((long) 0,1);

        for(long num : arr){
            prefix += num;
            cnt += map.getOrDefault(prefix - x, 0);
            map.put(prefix, map.getOrDefault(prefix, 0)+1);
        }

        return cnt;
    }
    public static void main(String[] args) throws Exception {
        FastScanner fc = new FastScanner();

        int n = fc.nextInt();
        long x = fc.nextLong();

        long [] vals = new long[n];

        for(int i = 0; i<n; i++)vals[i] = fc.nextLong();

        System.out.println(getNumberOfSubarrays(vals,n,x));
    }
}
