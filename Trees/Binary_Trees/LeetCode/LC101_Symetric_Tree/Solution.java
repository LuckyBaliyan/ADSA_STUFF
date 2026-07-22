package Trees.Binary_Trees.LeetCode.LC101_Symetric_Tree;


public class Solution {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }


    public static boolean isSymmetric(Node root) {
        if (root == null)
            return true;

        return traverse(root.left, root.right);
    }

    public static boolean traverse(Node a, Node b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;

        if (a.val != b.val)
            return false;

        return traverse(a.left, b.right) && traverse(a.right, b.left);
    }

    public static void main(String[] args) {
        Node p = new Node(0);

        p.left = new Node(1);
        p.right = new Node(1);

        p.left.left  = new Node(3);
        p.left.right = new Node(4);
        p.right.right = new Node(3);
        p.right.left = new Node(4);

        System.out.println(isSymmetric(p));
    }
}
