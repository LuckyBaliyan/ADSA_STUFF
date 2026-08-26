package Trees.Binary_Trees.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

      static class Node {
            int val;
            Node left;
            Node right;

            Node(int val) {
                  this.val = val;
                  this.left = this.right = null;
            }
      }

      public static int getRightMost(Node root, Node u) {
            int val = u.val;

            Queue<Node> q = new LinkedList<>();
            ArrayList<Integer> res = new ArrayList<>();

            q.offer(root);

            while (!q.isEmpty()) {
                  int size = q.size();

                  for (int i = 0; i < size; i++) {

                        Node curr = q.poll();

                        res.add(curr.val);

                        if (curr.left == null && curr.right == null)
                              continue;

                        if (curr.left != null)
                              q.offer(curr.left);
                        if (curr.right != null)
                              q.offer(curr.right);
                  }
            }

            boolean upcomming = false;

            for (int x : res) {
                  if (upcomming == true)
                        return x;
                  if (val == x)
                        upcomming = true;
            }

            return -1;
      }

      public static void main(String[] args) {
            Node root = new Node(0);

            root.left = new Node(1);
            root.right = new Node(2);

            root.left.left = new Node(3);
            root.left.right = new Node(4);

            root.right.left = new Node(5);
            root.right.right = new Node(6);

            int ans = getRightMost(root, root.left.right);

            System.out.println(ans);
      }
}
