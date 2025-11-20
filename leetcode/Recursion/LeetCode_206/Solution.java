package leetcode.Recursion.LeetCode_206;

public class Solution {
    Node temp;

    Solution(){
        temp = null;
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

    public static Node ReverseRec(Node head){
        if(head == null || head.next == null)return head;

        Node newNode = ReverseRec(head.next);
        head.next.next = head;

        head.next = null;

        return newNode;
    }

    public static void main(String[] args) {
        Solution s1 = new Solution();
        Solution s2 = new Solution();
        for(int i = 1;i<5;i++){
            s1.Insert(new Node(i));
            s2.Insert(new Node(i));
        }

        System.out.println(s1.temp.val+""+s2.temp.val);
        s1.PrintList();

        Node head = ReverseRec(s1.temp);

        System.out.println();

        Node curr = head;
        while(curr != null){
            if(curr.next == null){
                System.out.print(curr.val+" ");
                break;
            }
            System.out.print(curr.val+"-->");
            curr = curr.next;
        }
    }
}
