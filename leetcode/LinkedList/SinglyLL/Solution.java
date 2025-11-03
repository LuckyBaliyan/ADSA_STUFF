package leetcode.LinkedList.SinglyLL;

public class Solution {
    Node head;
    public void insertNode(int val){
      Node newNode = new Node(val);
      if(head == null){
        head = newNode;
        head.next = null;
        return;
      }

      Node curr = head;

      while(curr.next != null){
        curr = curr.next;
      }

      curr.next = newNode;

    }

    public int deleteNode(){
        Node curr = head;

        if(head == null) return -1;

        if(head.next  == null){
            int val = head.val;
            head = null;
            return val;
        }

        while(curr.next.next != null){
            curr = curr.next;
        }

        int deletedVal = curr.next.val;
        curr.next = null;

        return deletedVal;
    }

    public void logList(){
        Node curr = head;

        while(curr.next != null){
            System.out.print(curr.val+"-->");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        Solution list = new Solution();

        int n = 1;

        while(n<=12){
            list.insertNode(n);
            n++;
        }

        list.logList();
    }
}
