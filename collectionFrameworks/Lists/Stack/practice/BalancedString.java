package collectionFrameworks.Lists.Stack.practice;

import java.util.Stack;

public class BalancedString {
    public static boolean isBalancedString(String s){
        Stack<Character> ch = new Stack<>();

        for (char chr : s.toCharArray()) {
            if((chr == '(') || (chr == '{') || (chr =='[')){
                ch.push(chr);
            }
            else{
                if(ch.isEmpty()) return false;

                char top = ch.pop();
                if((chr == ')' && top != '(') ||
                 (chr == '}' && top != '{') ||
                 (chr == ']' && top != '[')
                ) return false;
            }
        }

        return ch.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalancedString("({[]})"));
    }
}
