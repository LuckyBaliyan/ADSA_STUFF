//package CodeForces.ConceptsRevision.B_Taxi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] count = new int[5];

        for (int i = 0; i < n; i++) {
            count[sc.nextInt()]++;
        }

        int taxi = 0;

        // groups of 4
        taxi += count[4];

        // groups of 3 (pair with 1 if possible)
        taxi += count[3];
        count[1] -= Math.min(count[1], count[3]);

        // groups of 2 (pair among themselves)
        taxi += count[2] / 2;

        // if one group of 2 left
        if (count[2] % 2 == 1) {
            taxi++;
            count[1] -= Math.min(2, count[1]);
        }

        // remaining groups of 1
        if (count[1] > 0) {
            taxi += (count[1] + 3) / 4;
        }

        System.out.println(taxi);
        sc.close();
    }
}