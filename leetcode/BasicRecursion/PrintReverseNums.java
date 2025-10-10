package leetcode.BasicRecursion;

/**
 * Print NUms form n - 1
 */

public class PrintReverseNums {
    static void printReverse(int n){
        if(n == 0) return;
        System.out.println(n);
        printReverse(n-1);
    }

    /**
     * Using Head Recursion
    */

    static void headRec(int n,int i){
        if(i > n) return;
        headRec(n,i+1);
        System.out.println(i);
    }

    public static void main(String[] args) {
        printReverse(5);
        System.out.println();
        headRec(5,1);
    }
}
