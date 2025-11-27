package ELiteBatch_HomeWorks.LeetCode_234;


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

    private static Node left;

    public static boolean isPalindrome(Node head){
        left = head;
        return solve(head);
    }

    public static boolean solve(Node right){
        if(right == null)return true;

        if(!solve(right.next))return false;
        if(left.val != right.val)return false;

        left = left.next;
        return true;
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

        System.out.println();

        s3.PrintList();

        System.out.println();
        
        s3.PrintList();

        Solution sp = new Solution();

        sp.InsertNode(1);
        sp.InsertNode(2);
        sp.InsertNode(2);
        sp.InsertNode(1);

        System.out.println(isPalindrome(sp.head));

        sp.head = sp.head.next;

        sp.PrintList();

        System.out.println();

        System.out.println(isPalindrome(sp.head));

    }
}
