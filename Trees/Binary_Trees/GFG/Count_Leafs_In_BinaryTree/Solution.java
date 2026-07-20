package Trees.Binary_Trees.GFG.Count_Leafs_In_BinaryTree;

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

      /**
       * @approach Recursion
       * @time O(N)
       * @param root
       * @return
       */
      public static int countLeafs(Node root) {
            if (root == null)
                  return 0;

            return getLeafs(root);
      }

      /**
       * Helper function to count the number of leafs in the binary tree.
       * 
       * @param root
       * @return
       */
      public static int getLeafs(Node root) {
            if (root.left == null && root.right == null)
                  return 1;

            int left = 0, right = 0;
            if (root.left != null)
                  left = getLeafs(root.left);
            if (root.right != null)
                  right = getLeafs(root.right);

            return left + right;
      }

      public static void main(String[] args) {
            Node root = new Node(0);

            root.left = new Node(1);
            root.right = new Node(2);

            root.left.left = new Node(4);
            root.left.right = new Node(5);

            root.right.left = new Node(6);
            root.right.right = new Node(7);

            root.left.left.left = new Node(8);
            root.left.left.right = new Node(9);

            System.out.println(countLeafs(root));
      }
}
