package CSES_Problem.dp.Removing_Digits;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        //int copy = n;
        int ways = 0;

        /* 
        while(copy > 0){
           int lastNum = 0;
           if(copy % 10 != 0){
            lastNum = copy % 10; 
            copy = copy - lastNum;
            ways++;
           }
           else{
            int sec = copy / 10;
            lastNum = sec % 10;
            copy = copy - lastNum;
            ways++;
           }
        }
        */

        while( n > 0){
            int temp = n;
            int max = 0;

            while(temp > 0){
                int d = temp % 10;
                max = Math.max(max,d);
                temp /= 10; 
            }

            n -= max;
            ways++;
        }

        System.out.println(ways);
    }
}
