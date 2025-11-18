/*
 * Given a stack s, delete the middle element of the stack without using any additional data structure.

Middle element:- floor((size_of_stack+1)/2) (1-based indexing) from the bottom of the stack.

Note: The output shown by the compiler is the stack from top to bottom.

Examples:

Input: s = [10, 20, 30, 40, 50]
Output: [50, 40, 20, 10]
Explanation: The bottom-most element will be 10 and the top-most element will be 50.
 Middle element will be element at index 3 from bottom, which is 30. Deleting 30, stack will look like {10 20 40 50}.
 */

package gfg.Stacks;

import java.util.Stack;

class Solution {
 
    static Stack<Integer> DeleteMidOfStack(Stack<Integer> s){
        if(s.size() == 0){
            s.pop();
            return s;
        }

        double mid = Math.floor((s.size()/2)+1);
    
        Stack<Integer> temp  = new Stack<>();

        for(int i = 1;i<mid;i++){
            temp.push(s.pop());
        }

        s.pop();

        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }

        return s;

    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        for(int i = 1;i<=10;i++)s.push(i);

        System.out.println(DeleteMidOfStack(s));
    }
    
 }