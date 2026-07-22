package Trees.Binary_Trees.LeetCode.LC266_InvertTree;

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

    public static void invertTree(Node root){
        if(root == null)return;

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return;
    }

    public static void main(String[] args) {
        Node p = new Node(0);

        p.left = new Node(1);
        p.right = new Node(2);

        p.left.left  = new Node(3);
        p.left.right = new Node(4);
        p.right.right = new Node(3);
        p.right.left = new Node(4);

        invertTree(p);

        System.out.println(p.left.val + " & "+  p.right.val);
    }
}
