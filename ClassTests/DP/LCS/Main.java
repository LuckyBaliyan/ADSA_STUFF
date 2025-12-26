package ClassTests.DP.LCS;

import java.util.Scanner;

public class Main {
    public static String LCS(String s1,String s2,String ans,int i,int j){
       int n = s1.length();
       int m = s2.length();

       if(i == n || j== m)return ans;

       if(s1.charAt(i) == s2.charAt(j)) return LCS(s1, s2, ans+s1.charAt(i), i+1, j+1);
       String t1 = LCS(s1, s2, ans, i+1, j);
       String t2 = LCS(s1, s2, ans, i, j+1);

       return t1.length() > t2.length()?t1:t2;
       
    }
    public static void main(String[] args) {
        /*System.out.println(LCS("axyb", "abyxb", "", 0, 0));
        System.out.println(LCS("aa", "xayaz", "", 0, 0));*/

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();

        System.out.println(LCS(s, t, "", 0, 0));
    }
}
