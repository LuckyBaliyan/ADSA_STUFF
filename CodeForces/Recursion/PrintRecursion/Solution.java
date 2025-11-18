package CodeForces.Recursion.PrintRecursion;

public class Solution {
    static void myRec(int num){
        if(num <= 0) return;

        System.out.println("I Love Recursion!");
        myRec(num-1);
    }  

    public static void main(String[] args) {
        myRec(10);  // TC:- O(N) SC:- O(N)
    }
}
