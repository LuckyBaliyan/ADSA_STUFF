package leetcode.BasicMath;


/* Ex:- 153 = 1^3+5^3+7^3 = 153 true
 *  12 = 1^2 + 2^2 = 5 false
 */

public class Armstrong {
    public static boolean isArmstrong(int x){
        int xCopy = x;
        int modi = 0;
        int powerCount = 0;

        while(xCopy != 0){
           xCopy /= 10;
           powerCount++;
        }

        int secCopy = x;

        while( secCopy != 0){
            modi += Math.pow((secCopy%10),powerCount);
            secCopy /=10;
        }

        return modi == x;
    }

    public static void main(String[] args) {
        System.out.println(isArmstrong(153));
        System.out.println(isArmstrong(370));
        System.out.println(isArmstrong(371));
        System.out.println(isArmstrong(15));
    }
}
