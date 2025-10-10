package leetcode.BasicRecursion;

/**
 * Print Your Name n times with recursion 
 * without using any counter
 */

public class PrintName {
    static void displayName(int k, int n){
        if(k == n) return;
        System.out.println("Lucky Baliyan");
        displayName(k+1, n);
    }

    public static void main(String[] args) {
        displayName(0, 3);
    }
}
