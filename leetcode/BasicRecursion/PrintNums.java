package leetcode.BasicRecursion;

/**
 * print numbers form 1 - n without using extra variable 
 * and print them in order
 */

public class PrintNums {
    static void printNumbers(int n){
        
        if(n==0) return;
        printNumbers(n-1);
        System.out.println(n); 

    }

    public static void main(String[] args) {
        printNumbers(5);
    }
}
