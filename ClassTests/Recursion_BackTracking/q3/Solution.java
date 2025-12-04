package ClassTests.Recursion_BackTracking.q3;

public class Solution {
    static final int MOD = 1000000007;
    public static int sequnce(int n){
        if(n<0)return 0;
        if(n==0)return 1;
        if(n == 1)return 1;

        return (sequnce(n-6)%MOD)+(sequnce(n-4)%MOD)+(sequnce(n-3)%MOD)+(sequnce(n-2)%MOD)+(sequnce(n-1)%MOD);
    }
    public static void main(String[] args) {
        System.out.println(sequnce(4));
    }
}
