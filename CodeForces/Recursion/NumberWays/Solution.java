package CodeForces.Recursion.NumberWays;

public class Solution {
    static int countSteps(int s, int e){
        if(s>e)return 0;
        if(s == e) return 1;
        return countSteps(s+1, e)+countSteps(s+2, e)+countSteps(s+3, e);

    }

    public static void main(String[] args) {
       int count = countSteps(2,5);
       System.out.println(count);
    }
}
