package leetcode.Recursion;

public class Solution {
    public void reverseString(char[] s) {
        revrseRecursive(s,0,s.length-1,s.length);
    }

    public static void revrseRecursive(char [] s,int l,int r,int n){
        if(n == 1)return;
        if(l>=r)return;

        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
        revrseRecursive(s,l+1,r-1,n);
    }

    //Second approach

    public static void reverseStringWithoutSwap(char [] s,int l,int n){
        reverseRec(s, l, n);
    }

    public static void reverseRec(char [] s,int l,int n){
        if(n == 0) return;
        if(l == n)return;

        char temp = s[l];
        reverseRec(s, l+1, n);
        s[n-l-1] = temp;
    }

    public static void main(String[] args) {
        char [] s = {'a','b','c','d'};
       reverseStringWithoutSwap(s, 0, s.length);
       for (char c : s) {
        System.out.print(c+" ");
       }
    }
}
