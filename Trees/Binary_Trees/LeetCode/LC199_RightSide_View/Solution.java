package Trees.Binary_Trees.LeetCode.LC199_RightSide_View;

import java.util.*;

public class Solution {

      static class Node {

            int val;
            Node left, right;

            Node(int val) {
                  this.val = val;
                  left = right = null;
            }

      }

      static List<Integer> res;

      public static List<Integer> getView(Node root) {

            if (root == null)
                  return new ArrayList<>();

            res = new ArrayList<>();

            dfs(root, 0);

            return res;

      }

      public static void dfs(Node root, int lvl) {

            if (root == null)
                  return;

            if (res.size() == lvl)
                  res.add(root.val);

            dfs(root.right, lvl + 1);
            dfs(root.left, lvl + 1);
      }

      public static void main(String[] args) {
            Node root = new Node(0);

            root.right = new Node(1);
            root.right.right = new Node(2);
            root.right.right.right = new Node(5);
            root.right.right.right.left = new Node(4);
            root.right.right.right.right = new Node(6);
            root.right.right.right.left.left = new Node(3);

            System.out.println(getView(root));
      }
}
