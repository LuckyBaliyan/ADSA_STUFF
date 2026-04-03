package infosys_HackwithInfy.Practice;

import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main6 {
    public static int minOperations(int N, List<Integer> A) {
        if (N == 0 || A.isEmpty()) {
            return 0;
        }

        int maxVal = A.get(0);
        for (int i = 1; i < N; i++) {
            if (A.get(i) > maxVal) {
                maxVal = A.get(i);
            }
        }

        int totalOperations = 0;
        for (int i = 0; i < N; i++) {
            totalOperations += (maxVal - A.get(i));
        }

        return totalOperations;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        if (!scan.hasNextInt()) return;
        
        int N = scan.nextInt();
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (scan.hasNextInt()) {
                A.add(scan.nextInt());
            }
        }
        
        System.out.println(minOperations(N, A));
    }
}