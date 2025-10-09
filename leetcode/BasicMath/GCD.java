package leetcode.BasicMath;

public class GCD {
    /* By Brute force */
    static int findOurGcd(int num1,int num2){
        for(int i = Math.min(num1, num2);i>=1;i--){
            int gcd = 1;
            if(num1 % i == 0 && num2 % i == 0){
                gcd = i;
                return gcd;
            }
        }

        return 1;
    }

    /* Optimal Approach using Euclied Theroam 
     * gcd(a,b) = gcd(a%b,b) where a>b
     */

     static int gcdByEuclied(int n1,int n2){
        while (n1>0 && n2>0) {
            if(n1>n2){
                n1 = n1 % n2;
            }
            else{
                n2 = n2 % n1;
            }
        }

        return n1 == 0?n2:n1;
     }


    public static void main(String[] args) {
        int res = findOurGcd(52,10);
        int res2 = gcdByEuclied(52,10);

        System.out.println(res);
        System.out.println(res2);
    }

}
