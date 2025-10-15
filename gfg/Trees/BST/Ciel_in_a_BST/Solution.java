package gfg.Trees.BST.Ciel_in_a_BST;

public class Solution {
    static int getCiel(Node root,int x){
        int ciel = -1;

        while(root != null){
            if(root.data == x) return root.data;
            else if(root.data < x) root = root.right;
            else{
                ciel = root.data;
                root = root.left;
            }
        }

        return ciel;
      
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(9);

        System.out.println(getCiel(root, 3));
        System.out.println(getCiel(root, 7)); 
        System.out.println(getCiel(root, 10)); 
        System.out.println(getCiel(root, 1));  
    }
}
