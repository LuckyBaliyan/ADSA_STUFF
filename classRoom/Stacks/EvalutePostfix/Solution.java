package classRoom.Stacks.EvalutePostfix;

import java.util.Stack;

public class Solution {
  static int evalutePostfix(String s){
    Stack<Integer> st = new Stack<>();

    for(int i = 0;i<s.length();i++){
        if(Character.isDigit(s.charAt(i))){
            st.push(s.charAt(i) - '0');
        }
        else{
            int b = st.pop();
            int a  = st.pop();

            switch (s.charAt(i)) {
                case '*':
                    st.push(a*b);
                    break;
                case '^':
                   st.push((int) Math.pow(a,b));
                   break;
                case '+':
                   st.push(a+b);
                   break;
                case '/':
                    st.push(a/b);
                    break;

                case '-':
                    st.push(a-b);
                    break;
            
                default:
                    break;
            }
        }
    }

    return st.pop();
  }

  public static void main(String[] args) {
    System.out.println(evalutePostfix("23+89/3245-89^7"));
  }
}
