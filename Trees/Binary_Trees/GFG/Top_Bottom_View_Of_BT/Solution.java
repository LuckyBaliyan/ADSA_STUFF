package Trees.Binary_Trees.GFG.Top_Bottom_View_Of_BT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Solution {

      static class Node {
            int data;
            Node left, right;

            Node(int data) {
                  this.data = data;
                  left = right = null;
            }
      }

      static class Pair {

            Node node;
            int lvl;

            Pair(Node node, int lvl) {
                  this.lvl = lvl;
                  this.node = node;
            }

      }

      static Map<Integer, Integer> mp;
      static ArrayList<Integer> res;

      public static ArrayList<Integer> bottomView(Node root) {
            // code here
            if (root == null)
                  return new ArrayList<>();

            res = new ArrayList<>();
            mp = new TreeMap<>();

            Queue<Pair> q = new LinkedList<>();

            q.offer(new Pair(root, 0));

            while (!q.isEmpty()) {

                  int size = q.size();

                  for (int i = 0; i < size; i++) {

                        Pair curr = q.poll();
                        Node currNode = curr.node;
                        int lvl = curr.lvl;

                        mp.put(lvl, currNode.data);

                        if (currNode.left != null) {
                              q.offer(new Pair(currNode.left, lvl - 1));
                        }

                        if (currNode.right != null) {
                              q.offer(new Pair(currNode.right, lvl + 1));
                        }
                  }

            }

            for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
                  res.add(e.getValue());
            }

            return res;
      }

      public static ArrayList<Integer> topView(Node root) {
            // code here
            if (root == null)
                  return new ArrayList<>();

            res = new ArrayList<>();
            mp = new TreeMap<>();

            Queue<Pair> q = new LinkedList<>();

            q.offer(new Pair(root, 0));

            while (!q.isEmpty()) {

                  int size = q.size();

                  for (int i = 0; i < size; i++) {

                        Pair curr = q.poll();
                        Node currNode = curr.node;
                        int lvl = curr.lvl;

                        if (!mp.containsKey(lvl))
                              mp.put(lvl, currNode.data);

                        if (currNode.left != null) {
                              q.offer(new Pair(currNode.left, lvl - 1));
                        }

                        if (currNode.right != null) {
                              q.offer(new Pair(currNode.right, lvl + 1));
                        }
                  }

            }

            for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
                  res.add(e.getValue());
            }

            return res;
      }

      public static void main(String[] args) {
            Node root = new Node(0);

            root.left = new Node(2);
            root.right = new Node(3);

            root.left.left = new Node(1);
            root.left.right = new Node(4);

            root.right.left = new Node(6);
            root.right.right = new Node(5);

            root.left.right.left = new Node(8);
            root.left.right.right = new Node(7);

            root.right.left.left = new Node(9);
            root.right.right.right = new Node(10);

            System.out.println(topView(root));
      }
}
