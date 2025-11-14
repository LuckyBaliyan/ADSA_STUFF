package classRoom.Stacks.Using_LinkedList;

public class Stack {
    Node top;

    Stack(){
        top = null;
    }

    boolean isEmpty(){
        return top == null;
    }

    //Push
    void push(int val){
        Node newNode =  new Node(val);
        newNode.next = top;
        top = newNode;
    }

    //pop()
    int pop(){
        if(isEmpty()) return -1;

        int popedValue = top.data;
        top = top.next;
        return popedValue;
    }

    //peek()
    int peek(){
        if(isEmpty()) return -1;

        return top.data;
    }
 
    //display()
    void display(){
        if(isEmpty()) return;
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Stack st = new Stack();

        for(int i = 0;i<=10;i++){
            st.push(i);
        }

        st.display();

        System.out.println();

        System.out.println(st.pop());
        System.out.println(st.isEmpty());

        System.out.println();

        st.display();
    }

}
