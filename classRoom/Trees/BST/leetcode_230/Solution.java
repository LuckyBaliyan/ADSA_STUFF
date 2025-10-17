package classRoom.Trees.BST.leetcode_230;

import java.util.Stack;

/**
 * 
    230. Kth Smallest Element in a BST
    Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) 
    of all the values of the nodes in the tree.
*/

public class Solution {
    static int kthSmallest(TreeNode root,int k){

        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        int count = 0;

        while(curr != null || !st.isEmpty()){
            //Push all the left nodes in the stack first
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop(); // This is the minimum elemetn of the tree if count  = 0;
            count++; 

            if(k == count) return curr.val;

            curr = curr.right; //Now check for the right subtree
        }

       return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(6);

        System.out.println(kthSmallest(root, 3));
    }
}
