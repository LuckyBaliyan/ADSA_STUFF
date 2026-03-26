package infosys_HackwithInfy.Practice;

import java.util.*;
import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        long m = sc.nextLong();
        
        long[] v = new long[n];
        long[] d = new long[n];
        
        for (int i = 0; i < n; i++) v[i] = sc.nextLong();
        for (int i = 0; i < n; i++) d[i] = sc.nextLong();
        
        long low = 0, high = (long) 2e9;
        long threshold = 0;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (countMeals(v, d, mid) >= m) {
                threshold = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        long totalTaste = 0;
        long mealsTaken = 0;
        
        for (int i = 0; i < n; i++) {
            if (v[i] >= threshold + 1) {
                long count = (v[i] - (threshold + 1)) / d[i] + 1;
                long lastTerm = v[i] - (count - 1) * d[i];
                totalTaste += count * (v[i] + lastTerm) / 2;
                mealsTaken += count;
            }
        }
        
        if (mealsTaken < m) {
            totalTaste += (m - mealsTaken) * threshold;
        }
        
        System.out.println(totalTaste);
    }
    
    private static long countMeals(long[] v, long[] d, long x) {
        if (x <= 0) return (long) 2e18; 
        long count = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] >= x) {
                count += (v[i] - x) / d[i] + 1;
            }
        }
        return count;
    }
}
