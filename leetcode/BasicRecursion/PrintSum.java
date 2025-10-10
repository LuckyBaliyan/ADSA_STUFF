package leetcode.BasicRecursion;

/**
 * print sum of first N numbers
 */


public class PrintSum {
    static int sumFirst(int n,int sum){
        if(n==0) return sum;
        return sumFirst(n-1, sum+n);
    }

    /** 
     * Enhanced version
     */

    static int sumFirst(int n){
        if(n == 0) return n;
        return n + sumFirst(n-1);
    }

    public static void main(String[] args) {
        System.out.println(sumFirst(4,0));
        System.out.println(sumFirst(4));
    }
}
