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

      public static int getMinHeight(Node root) {
            if (root == null)
                  return 0;

            return getHeight(root) + 1;
      }

      public static int getHeight(Node root) {
            if (root == null)
                  return 0;

            if (root.left == null && root.right == null)
                  return 0;

            int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;

            if (root.left != null) {
                  left = 1 + getHeight(root.left);
            }

            if (root.right != null) {
                  right = 1 + getHeight(root.right);
            }

            return Math.min(left, right);
      }

      public static void main(String[] args) {
            Node root = new Node(0);

            root.left = null;
            root.right = new Node(1);
            root.right.left = new Node(2);
            root.right.right = new Node(3);

            root.right.left.left = null;
            root.right.left.right = null;

            root.right.right.left = null;
            root.right.right.right = new Node(4);

            System.out.println(getMinHeight(root));
      }
}
