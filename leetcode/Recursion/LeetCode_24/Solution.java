package leetcode.Recursion.LeetCode_24;

public class Solution {
    Node temp;

    Solution(){
        temp = null;
    }

    static Node swapPairs(Node head){
       if(head == null || head.next == null) return head;

       Node first = head;
       Node second = head.next;

       first.next = swapPairs(second.next);
       second.next = first;

       return second;
    }

    public void Insert(Node newNode){
        if(temp == null){
            temp = newNode;
            return;
        }

        Node curr = temp;
        while(curr.next != null){
            curr = curr.next;
        }

        curr.next = newNode;

    }

    public void PrintList(){
        Node curr = temp;
        while(curr != null){
            System.out.print(curr.val+"->");
            curr = curr.next;
        }
        System.out.print("null");


    }

    public static void main(String[] args) {
        Solution s1 = new Solution();
        for(int i = 1;i<5;i++){
            s1.Insert(new Node(i));
        }

        System.out.println(s1.temp.val);
        s1.PrintList();

        s1.temp = swapPairs(s1.temp);

        System.out.println();

        s1.PrintList();
    }
}
