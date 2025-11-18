package CodeForces.Recursion.Print1ToN;

public class Solution {
    static void PrintNums(int n){
        if(n<= 0) return;

        PrintNums(n-1);
        System.out.println(n);
    }

    static void PrintNumRev(int n){
        if(n<=0) return;

        System.out.println(n);
        PrintNumRev(n-1);
    }

    public static void main(String[] args) {
        PrintNums(10);
        System.out.println();
        PrintNumRev(6);
    }
}
