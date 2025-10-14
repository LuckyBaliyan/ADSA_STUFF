package leetcode.HashingProblems.Leetcode_17;

import java.util.ArrayList;
import java.util.List;
/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

 */

public class Solution {
    static List<String> LettersCombination(String digits){
        if(digits.length() == 0){
           return new ArrayList<>();
        }

        //First call
        return getLettersCombination(digits,0);
    }

    static String [] codes = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    //Recursive function

    static List<String> getLettersCombination(String digits,int indx){

        //Unfolding Step
        if(indx == digits.length()){
            List<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }

        List<String> myRes = new ArrayList<>();
        List<String> recRes = getLettersCombination(digits, indx+1);

        char ch = digits.charAt(indx);
        String code = codes[ch - '0'];

        //Mapping step
        for(String s:recRes){
            for(int i =0;i<code.length();i++){
                char w = code.charAt(i);
                myRes.add(w+s);
            }
        }

        return myRes;
    }

    public static void main(String[] args) {
        System.out.println(LettersCombination("23"));
    }
}
