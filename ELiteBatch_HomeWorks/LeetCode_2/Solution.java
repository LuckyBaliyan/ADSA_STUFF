package ELiteBatch_HomeWorks.LeetCode_2;

public class Solution {
    Node head;

    public void InsertNode(int val){
        Node newNode = new Node(val);

        if(head == null){head = newNode;return;};
        if(head.next == null){
            head.next = newNode;
            return;
        }
        Node curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = newNode;
    }

    public void PrintList(){
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val+"-->");
            curr = curr.next;
        }
    }

    public static Node sumLists(Node l1,Node l2){
        Node dummy =  new Node(-1);
        Node curr = dummy;

        int carry = 0;
        while(l1 != null || l2 != null){
            int val1 = 0;
            int val2 = 0;
            if(l1 != null){
                val1 = l1.val;
            }
            if(l2 !=null){
                val2 = l2.val;
            }

            int sum = val1+val2+carry;
            if(sum >=10){
                carry = sum/10;
                sum = sum%10;
                curr.next = new Node(sum);
                curr = curr.next; 
            }
            else{
                curr.next = new Node(sum);
                curr = curr.next;
                carry = 0;
            }

            if(l1!= null)l1 = l1.next;
            if(l2!= null)l2 = l2.next;
        }

        //there may some case with some leading carry we can handle it as 
        if(carry != 0){
            curr.next = new Node(carry);
            curr = curr.next;
        }

        return dummy.next;
    }

    //Recursive approach
     public static Node addRecursive(Node l1, Node l2,int carry){
        if(l1 == null && l2 == null && carry == 0)return null;
        if(l1 == null && l2== null && carry != 0){
            return new  Node(carry); 
        }

        int val1 = 0;
        int val2 = 0;

        Node newL2 = null;
        Node newL1 = null;

        if(l1 != null){
            val1 = l1.val;
            newL1 = l1.next;
        };
        if(l2 != null){
            val2 = l2.val;
            newL2 = l2.next;
        };

        int sum = val1+val2+carry;
        int digit = sum%10;
        carry = sum/10;

        Node curr = new Node(digit);
        curr.next = addRecursive(newL1,newL2,carry);
        return curr;
    }

    public static void main(String[] args) {
        Solution s1 = new Solution();
        Solution s2 = new Solution();
        Solution s3 = new Solution();

        for(int i = 0;i<=10;i++){
            s1.InsertNode(i);
            s2.InsertNode(i);
        }

        s1.PrintList();

        System.out.println();

        s2.PrintList();

        s3.head = sumLists(s1.head, s2.head);

        System.out.println();

        s3.PrintList();

        s3.head = addRecursive(s1.head, s2.head, 0);

        System.out.println();
        
        s3.PrintList();

    }
}
