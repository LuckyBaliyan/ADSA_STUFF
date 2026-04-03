package CodeForces.ConceptsRevision.BoyOrGirl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String Pattern = sc.nextLine();
        int [] freq = new int [26];

        for(int i = 0;i<Pattern.length();i++){
            freq[Pattern.charAt(i) - 'a']++;
        }

        int count = 0;
        for(int i = 0;i<26;i++){
            if(freq[i] > 0)count++;
        }

        String res = (count % 2 == 0) ? "CHAT WITH HER!":"IGNORE HIM!";
        System.out.println(res);

        sc.close();
    }
}
