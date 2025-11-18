package CodeForces.Recursion.Fibo;

public class Solution {
    //Last Number 
    static int  printFibo(int n){
        if( n<=1) return n;

        return printFibo(n-1)+printFibo(n-2);
    }

    //Print the series 
    static void PrintSequence(int n){
        for(int i = 0;i<=n;i++){
           System.out.print(printFibo(i)+" ");
        }
    }

    public static void main(String[] args) {
        System.out.println(printFibo(10));
        PrintSequence(10);
    }
}
