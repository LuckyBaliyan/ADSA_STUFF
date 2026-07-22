package Trees.Binary_Trees.LeetCode.LC63_Average_Levels;

import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int val) {
            this.val = val;
      }

      TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
      }
}

public class Solution {

      static List<Double> res;
      static Queue<TreeNode> q;

      public List<Double> averageOfLevels(TreeNode root) {

            res = new ArrayList<>();
            q = new LinkedList<>();

            bfs(root);

            return res;
      }

      public static void bfs(TreeNode root) {

            if (root == null)
                  return;

            q.offer(root);

            while (!q.isEmpty()) {

                  int size = q.size();
                  double sum = 0;

                  for (int i = 0; i < size; i++) {

                        TreeNode curr = q.poll();
                        sum += curr.val;

                        if (curr.left != null)
                              q.offer(curr.left);

                        if (curr.right != null)
                              q.offer(curr.right);
                  }

                  double avg = sum / size;
                  res.add(avg);
            }
      }

      public static void main(String[] args) {

            /*
             * 3
             * / \
             * 9 20
             * / \
             * 15 7
             * 
             * Expected Output:
             * [3.0, 14.5, 11.0]
             */

            TreeNode root = new TreeNode(
                        3,
                        new TreeNode(9),
                        new TreeNode(
                                    20,
                                    new TreeNode(15),
                                    new TreeNode(7)));

            Solution obj = new Solution();

            List<Double> ans = obj.averageOfLevels(root);

            System.out.println(ans);
      }
}