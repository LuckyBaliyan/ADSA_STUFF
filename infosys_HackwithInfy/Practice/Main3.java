package infosys_HackwithInfy.Practice;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            int[] negsIn = new int[n];
            int negCnt = 0;

            for (int j = i; j < n; j++) {
                sum += a[j];
                if (a[j] < 0) negsIn[negCnt++] = a[j];

                boolean[] inSub = new boolean[n];
                for (int x = i; x <= j; x++) inSub[x] = true;

                int[] negsInSorted = Arrays.copyOf(negsIn, negCnt);
                Arrays.sort(negsInSorted);

                int[] posOut = new int[n];
                int poCnt = 0;
                int[] allSorted = a.clone();
                Arrays.sort(allSorted);
                
                int[] posInside = new int[n];
                int piCnt = 0;
                for (int x = i; x <= j; x++) if (a[x] > 0) posInside[piCnt++] = a[x];
                Arrays.sort(posInside, 0, piCnt);
                
                int ptr = piCnt - 1;
                for (int m = n - 1; m >= 0; m--) {
                    if (allSorted[m] <= 0) break;
                    if (ptr >= 0 && allSorted[m] == posInside[ptr]) { ptr--; continue; }
                    posOut[poCnt++] = allSorted[m];
                }

                int cur = sum;
                int swaps = k;
                int ni = 0, oi = 0;
                while (swaps > 0 && ni < negCnt && oi < poCnt) {
                    int neg = negsInSorted[ni];
                    int pos = posOut[oi];
                    if (pos + Math.abs(neg) > 0) {
                        cur += pos - neg;
                        ni++; oi++; swaps--;
                    } else break;
                }

                ans = Math.max(ans, cur);
            }
        }

        System.out.println(ans);
    }
}