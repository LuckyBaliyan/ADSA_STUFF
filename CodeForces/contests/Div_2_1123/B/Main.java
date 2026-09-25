package CodeForces.contests.Div_2_1123.B;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            TreeMap<Integer, Integer> mp = new TreeMap<>();

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                mp.put(x, mp.getOrDefault(x, 0) + 1);
            }

            ArrayList<Integer> ans = new ArrayList<>();

            int mx = mp.lastKey();
            int mxFreq = mp.get(mx);

            for (int i = 0; i < mxFreq; i++) {
                ans.add(mx);
            }

            mp.remove(mx);

           
            ArrayList<Integer> keys =
                    new ArrayList<>(mp.descendingKeySet());

           
            int maxFreq = 0;

            for (int freq : mp.values()) {
                maxFreq = Math.max(maxFreq, freq);
            }

           
            for (int level = 1; level <= maxFreq; level++) {

                for (int x : keys) {

                    if (mp.get(x) >= level) {
                        ans.add(x);
                    }
                }
            }

            for (int x : ans) {
                System.out.print(x + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}