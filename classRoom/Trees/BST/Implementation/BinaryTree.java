package classRoom.Trees.BST.Implementation;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    BinaryTree(){
        root = null;
    }

    //Insert a node 
    Node insertNode(Node node,int data){
        if(node == null){
           return new Node(data);
        }

        if(data < node.data){
            node.left = insertNode(node.left, data);
        }
        else if (data > node.data){
            node.right = insertNode(node.right, data);
        }

        return node;
    }

    void insert(int data){
        root = insertNode(root, data);
    }

    //delete Node
    Node deleteNode(Node root,int k){
        if(root  == null) return root;

        if(k < root.data){
            root.left = deleteNode(root.left, k);
        }
        else if (k > root.data){
            root.right = deleteNode(root.right, k);
        }

        else{
            if(root.left == null && root.right == null) return null;

            else if (root.left == null){
                return root.right;
            }

            else if (root.right == null){
                return root.left;
            }

            else{
                root.data = minValue(root.right);
                root.right = deleteNode(root.right,root.data);
            }
        }

        return root;
    }

    int minValue(Node node){
        int min = node.data;
        while(node.left != null){
            node = node.left;
            min = node.data;
        }

        return min;
    }

    void delete(int k){
        root = deleteNode(root, k);
    }


    //Update Node 
    void updateNode(Node node,int oldValue,int newValue){
        if(node == null) return;

        if(node.data == oldValue){
            node.data = newValue;
            return;
        }

        if(oldValue < node.data){
            updateNode(node.left,oldValue, newValue);
        }
        else{
            updateNode(node.right,oldValue, newValue);
        }
    }

    void  update(int oldValue, int newValue){
        delete(oldValue);
        insert(newValue);
    }

    //Trvaersal algos (DFS)

    void inOrder(Node node){
        if(node == null) return;

        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }

    void preOrder(Node node){
        if(node == null) return;

        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    void postOrder(Node node){
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+" ");
    }


    //(BFS) Level Order
    void levelOrder(Node root){
        if(root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.data+" ");

            if(temp.left != null){
               queue.add(temp.left);
            }        
            if (temp.right != null){
                queue.add(temp.right);
            }
        }
    }


    public static void main(String[] args) {
        BinaryTree bst = new BinaryTree();

        // in this case we can get a straight line and same traversal order since we are passing values in sequence
        int [] values = {22,40,20,10,34,90};
        for(int val:values){
            bst.insert(val);
        }

        bst.inOrder(bst.root);
        System.out.println();
        bst.preOrder(bst.root);

        bst.delete(22);

        System.out.println();

        bst.preOrder(bst.root);
        System.out.println();
        bst.levelOrder(bst.root);
    }

}
