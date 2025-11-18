package CodeForces.Recursion.CSES_Problem.WierdSequence;

public class Solution {
    static void  giveSequence(long n){
        System.out.print(n+"-->");
        
        if(n <= 1){
            return;
        }

        if(n%2 == 0){
            giveSequence(n/2);
        }
        else{
        giveSequence((n*3)+1);
        }
    }


    public static void main(String[] args) {
        giveSequence(3);
    }
}
