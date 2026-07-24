package Trees.Binary_Trees.LeetCode.LC113_PathSum_II;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

      static class TreeNode {
            int val;
            TreeNode left, right;

            TreeNode(int val) {
                  this.val = val;
                  left = right = null;
            }
      }

      static Stack<TreeNode> st;
      static List<List<Integer>> res;

      public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            if (root == null)
                  return new ArrayList<>();

            res = new ArrayList<>();
            st = new Stack<>();

            if (root.left == null && root.right == null && root.val == targetSum) {
                  res.add(new ArrayList<>());
                  res.get(0).add(root.val);

                  return res;
            }

            dfs(root, targetSum);

            return res;
      }

      public static void dfs(TreeNode root, int sum) {
            st.push(root);

            if (root.left == null && root.right == null && root.val == sum) {
                  fillRes(); // fill the result from the stack
                  st.pop(); // find one path backtarck and remove this node
                  return;
            }

            if (root.left != null) {
                  dfs(root.left, sum - root.val);
            }

            if (root.right != null) {
                  dfs(root.right, sum - root.val);
            }

            // backtrack
            if (!st.isEmpty())
                  st.pop();
      }

      public static void fillRes() {

            List<Integer> temp = new ArrayList<>();

            // instead of poping iterate overstack otherwise it will pop all
            // the nodes at once

            for (TreeNode node : st) {
                  temp.add(node.val);
            }

            res.add(temp);
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(5);
            root.left = new TreeNode(4);
            root.right = new TreeNode(8);
            root.left.left = new TreeNode(11);
            root.left.left.left = new TreeNode(7);
            root.left.left.right = new TreeNode(2);
            root.right.left = new TreeNode(13);
            root.right.right = new TreeNode(4);
            root.right.right.right = new TreeNode(1);

            int targetSum = 22;
            System.out.println(pathSum(root, targetSum));
      }
}
