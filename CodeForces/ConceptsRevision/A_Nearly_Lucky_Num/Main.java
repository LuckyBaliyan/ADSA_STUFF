package CodeForces.ConceptsRevision.A_Nearly_Lucky_Num;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        int lucky = 0;

        while(n > 0){
            long checkNum = n % 10;
            n /= 10;

            if(checkNum == 4 || checkNum == 7)lucky++; 
        }

        String res = (lucky == 4 || lucky == 7)?"YES":"NO";
        System.out.println(res);

        sc.close();
    }
}
