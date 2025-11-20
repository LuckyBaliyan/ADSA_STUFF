package leetcode.Recursion.LeetCode_21;

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

    public static Node mergeTwoNodes(Node list1,Node list2){
        if(list1 == null)return list2;
        if(list2 == null)return list1;

        if(list1.val <= list2.val){
            list1.next = mergeTwoNodes(list1.next, list2);
            return list1;
        }
        else{
            list2.next = mergeTwoNodes(list1, list2.next);
            return list2;
        }
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

        Node head = mergeTwoNodes(s1.temp,s2.temp);
        System.out.println();

        Node curr = head;
        while(curr != null){
            System.out.print(curr.val+"-->");
            curr = curr.next;
        }
    }
}
