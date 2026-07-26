package Trees.Binary_Trees.LeetCode.LC257_MaximumPathSum;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
      int val;
      TreeNode left, right;

      TreeNode(int val) {
            this.val = val;
            left = right = null;
      }
}

public class Solution {
      static Stack<TreeNode> st;
      static List<String> res;

      public List<String> binaryTreePaths(TreeNode root) {
            if (root == null)
                  return new ArrayList<>();

            res = new ArrayList<>();
            st = new Stack<>();

            dfs(root);

            return res;
      }

      public static void dfs(TreeNode root) {
            if (root == null)
                  return;

            st.push(root);

            if (root.left == null && root.right == null) {
                  // fill the result and backtrack
                  fillRes();
                  st.pop();

                  return;
            }

            dfs(root.left);
            dfs(root.right);

            st.pop(); // backtrack
      }

      public static void fillRes() {
            StringBuilder sb = new StringBuilder();

            int size = st.size();
            int k = 0;

            for (TreeNode node : st) {
                  if (k == size - 1) {
                        sb.append(node.val);
                  } else {
                        sb.append(node.val + "->");
                  }

                  k++;
            }

            res.add(sb.toString());
      }

      public static void main(String[] args) {

            /*
             * 1
             * / \
             * 2 3
             * / \
             * 5 4
             * 
             */

            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(5);
            root.left.right = new TreeNode(4);

            Solution obj = new Solution();
            List<String> ans = obj.binaryTreePaths(root);
            System.out.println(ans);
      }
}
