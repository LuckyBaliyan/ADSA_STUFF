package infosys_HackwithInfy.DP.decodeWays2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
      static Map<String, Character> map;
      static int[][] dp;

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            String digits = sc.next();

            System.out.println(getDecodeWays2(digits));

            sc.close();
      }

      public static int isVowel(char ch) {
            if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
                  return 1;
            else
                  return 0;
      }

      public static int getDecodeWays2(String digits) {
            int n = digits.length();
            map = new HashMap<>();

            map.put("1", 'A');
            map.put("2", 'B');
            map.put("3", 'C');
            map.put("4", 'D');
            map.put("5", 'E');
            map.put("6", 'F');
            map.put("7", 'G');
            map.put("8", 'H');
            map.put("9", 'I');
            map.put("10", 'J');
            map.put("11", 'K');
            map.put("12", 'L');
            map.put("13", 'M');
            map.put("14", 'N');
            map.put("15", 'O');
            map.put("16", 'P');
            map.put("17", 'Q');
            map.put("18", 'R');
            map.put("19", 'S');
            map.put("20", 'T');
            map.put("21", 'U');
            map.put("22", 'V');
            map.put("23", 'W');
            map.put("24", 'X');
            map.put("25", 'Y');
            map.put("26", 'Z');

            dp = new int[n][2];

            for (int[] d : dp)
                  Arrays.fill(d, -1);

            return solve(digits, 0, n, isVowel(digits.charAt(0)));
      }

      public static int solve(String d, int i, int n, int isVowel) {
            if (i == n)
                  return 1;

            if (d.charAt(i) == '0')
                  return 0;

            if (dp[i][isVowel] != -1)
                  return dp[i][isVowel];

            int ways = 0;

            // chekc for at max 2 digits since z--> 26 (till)
            for (int idx = i; idx < i + 2; idx++) {
                  if (idx < n) {
                        // select curr prefix i.e "1" or "12"
                        String choosen = d.substring(i, idx + 1);

                        // "12" is a key in map while "52" is't
                        if (map.containsKey(choosen)) {
                              char curr = map.get(choosen);

                              int currIsVowel = isVowel(curr);

                              if (!(currIsVowel == 1 && isVowel == 1)) {
                                    ways += solve(d, idx + 1, n, currIsVowel);
                              }
                        }
                  }
            }

            return dp[i][isVowel] = ways;
      }
}
