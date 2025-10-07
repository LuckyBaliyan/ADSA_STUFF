package collectionFrameworks.Lists.Stack.practice;

import java.util.Stack;

public class PalindromeString {
    public static void main(String[] args) {
        String name = "MADAM".toLowerCase().trim();
        Stack<Character> chars = new Stack<>();

        boolean result =  true;

        //pushing the values in the stack
        for(int i = 0;i<name.length();i++){
            chars.push(name.charAt(i));
        }

        //comparing making a string by poping them one by one 
        for(int i=0;i<name.length()-1;i++){
            if(name.charAt(i) != chars.pop()){
                result = false;
                break;
            }
        }

        System.out.println(result);
    }
}
