package leetcode.DP.LongestPalindromeSubString;

public class Main {
     public static void longestPalindrome(String s) {
       //return extremeNaive(s);
       solveDp(s);
    }

    public static void solveDp(String s){
        int n = s.length();

        boolean [][] dp = new boolean [n][n];

        for(int i = 0;i<n;i++)dp[i][i] = true;
        int maxLen = 1;
        int start = 0;

        for(int len = 2;len<=n;len++){
            for(int l = 0;l+len-1<n;l++){
                int r = l+len-1;

                if(s.charAt(l) == s.charAt(r)){
                    if(len == 2 || dp[l+1][r-1]){
                        dp[l][r] = true;
                        if(len > maxLen){
                            start = l;
                            maxLen = len;
                        }
                    }
                }
            }
        }

        for(int i =0;i<n;i++){
            for(int j = 0;j<n;j++)System.out.print(dp[i][j]+" ");

            System.out.println();
        }

        System.out.println("Max Length:"+maxLen);
        System.out.println("Longest Plaindromic Substring: "+s.substring(start, maxLen + start));
    }

    public static void main(String[] args) {
        longestPalindrome("babad");
    }

}
