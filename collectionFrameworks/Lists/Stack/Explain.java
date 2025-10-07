package collectionFrameworks.Lists.Stack;

import java.util.Stack;

public class Explain {
    public static void main(String[] args) {
        Stack<String> names = new Stack<>();

        //Adding elements in stack 
        names.push("Avi");
        names.push("Ravi");
        names.push("mahi");

        System.out.println(names);

        //Deleting elements form stack
        names.pop();

        System.out.println(names);
        System.out.println(names.peek());

    }
}
