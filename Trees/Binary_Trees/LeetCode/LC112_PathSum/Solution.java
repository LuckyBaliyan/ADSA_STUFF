package Trees.Binary_Trees.LeetCode.LC112_PathSum;

public class Solution {

      static class Node {
            int val;
            Node left, right;

            Node(int val) {
                  this.val = val;
                  left = right = null;
            }
      }

      public static boolean hasPathSum(Node root, int targetSum) {
            if (root == null)
                  return false;

            if (root.left == null && root.right == null && root.val == targetSum)
                  return true;

            return traverse(root, targetSum);
      }

      public static boolean traverse(Node root, int sum) {
            if (root.left == null && root.right == null)
                  return root.val == sum;

            boolean left = false;
            boolean right = false;

            if (root.left != null) {
                  left = traverse(root.left, sum - root.val);
            }

            if (root.right != null) {
                  right = traverse(root.right, sum - root.val);
            }

            return left || right;
      }

      public static void main(String[] args) {

            Node root = new Node(5);
            root.left = new Node(4);
            root.right = new Node(8);
            root.left.left = new Node(11);
            root.left.left.left = new Node(7);
            root.left.left.right = new Node(2);
            root.right.left = new Node(13);
            root.right.right = new Node(4);
            root.right.right.right = new Node(1);

            int targetSum = 22;
            System.out.println(hasPathSum(root, targetSum));

      }
}
