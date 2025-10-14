package leetcode.BinarySearch.leetcode_69;

public class Solution {
    static int mySqrt(int x){
        if(x<2){
            return x;
        }

        int left = 1;
        int right = x/2; // because always a number sqert is <= to its half

        while(left<=right){
            int mid = left+(right - left)/2;
            long sqr = (long) mid*mid;

            if(sqr == x) return mid;
            else if(sqr>x) right = mid -1;
            else left = mid+1;
        }

        return right;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(64));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(124));
        System.out.println(mySqrt(144));
        System.out.println(mySqrt(49));
    }
}
