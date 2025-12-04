package ClassTests.DP.frogJump;

public class Solution {
    public static int frogjump(int n,int [] stones){
        return frogjumpRec(n - 1, stones);
    }

    static int frogjumpRec(int i,int [] stones){
        if(i == 0)return 0;
        if(i == 1)return Math.abs(stones[1]-stones[0]);


        int jmp1 = frogjumpRec(i-1, stones) + Math.abs(stones[i] - stones[i - 1]);
        int jump2 = frogjumpRec(i-2, stones) + Math.abs(stones[i] - stones[i - 2]);


       return Math.min(jump2,jmp1);
    }
    public static void main(String[] args) {
        System.out.println(frogjump(4, new int [] {10,20,30,40,20}));
    }
}
