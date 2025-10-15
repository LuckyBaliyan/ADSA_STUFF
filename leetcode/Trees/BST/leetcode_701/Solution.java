package leetcode.Trees.BST.leetcode_701;

public class Solution {
    static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);

        TreeNode node = new TreeNode(val);
        TreeNode curr = root;

        while(curr != null){
            if(curr.val > val){
                if(curr.left == null){
                    curr.left = node;
                    break;
                }
                else{
                    curr = curr.left;
                }

            }
            else{
                if(curr.right == null){
                    curr.right = node;
                    break;
                }
                else{
                    curr = curr.right;
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(insertIntoBST(root,5));
    }
}
