import java.util.Scanner;

public class Main {
    static long[] seg;
    static long[] arr;

    public static void build_st(int idx, int l, int r) {
        if (l == r) {
            seg[idx] = arr[l];
            return;
        }

        int mid = l + (r - l) / 2;
        build_st(2 * idx, l, mid);
        build_st(2 * idx + 1, mid + 1, r);

        seg[idx] = Math.max(seg[2 * idx], seg[2 * idx + 1]);
    }

    public static void update_St(int i, long v, int idx, int l, int r) {
        if (l == r) {
            seg[idx] = v;
            return;
        }

        int mid = l + (r - l) / 2;

        if (i <= mid)
            update_St(i, v, 2 * idx, l, mid);
        else
            update_St(i, v, 2 * idx + 1, mid + 1, r);

        seg[idx] = Math.max(seg[2 * idx], seg[2 * idx + 1]);
    }

    public static int giveX(long x, int ql, int idx, int l, int r) {

        if (r < ql || seg[idx] < x)
            return -1;

        if (l == r)
            return l;

        int mid = l + (r - l) / 2;

        int left = giveX(x, ql, 2 * idx, l, mid);

        if (left != -1)
            return left;

        return giveX(x, ql, 2 * idx + 1, mid + 1, r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new long[n + 1];
        seg = new long[4 * n + 5];

        for (int i = 1; i <= n; i++)
            arr[i] = sc.nextLong();

        build_st(1, 1, n);
        StringBuilder sb = new StringBuilder();

        while (m-- > 0) {
            int type = sc.nextInt();

            if (type == 1) {
                int i = sc.nextInt();
                long v = sc.nextLong();

                update_St(i + 1, v, 1, 1, n);
            } else {

                long x = sc.nextLong();
                int l = sc.nextInt();

                int ans = giveX(x, l + 1, 1, 1, n);
                if (ans == -1)
                    sb.append((-1) + "\n");
                else
                    sb.append((ans - 1) + "\n");
            }
        }

        System.out.println(sb.toString().trim());
        sc.close();
    }
}