public class Solution {

    /**
     * Node
     */
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
     * 
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(Node p, Node q) {
        return traverse(p, q);
    }

    /**
     * 
     * @param p
     * @param q
     * @return
     */
    public static boolean traverse(Node p, Node q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;

        return traverse(p.left, q.left) && traverse(p.right, q.right);
    }

    public static void main(String[] args) {
        Node p = new Node(0);
        Node q = new Node(0);

        p.left = new Node(1);
        p.right = new Node(2);

        q.left = new Node(1);
        q.right = new Node(2);

        System.out.println(isSameTree(p, q));
    }

}
