package stacks;

public class Stack {
    
    Node first;

    public  void push(int data){
        Node toAdd = new Node(data);
        if(isEmpty()){
            first = toAdd;
        } else {
            toAdd.next = first;
            first = toAdd;
        }
    }

    public int pop() throws Exception{
        if(isEmpty()) throw new Exception("Cannot remove from an empty stack");
        else if(first.next == null){
            int toRemove = first.data;
            first = null;
            return toRemove;
        }
        else{
            int toRemove = first.data;
            Node temp = first.next;
            first.next = null;
            first = temp;
            return toRemove;
        }
    }

    public int length(){
        if(isEmpty()) return 0;
        int length = 0;
        while(first != null){
            length++;
            first = first.next;
        }
        return length;
    }

    public void print(){
        if(isEmpty()) return;
        Node current = first;
        System.out.println();
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean isEmpty(){
        return first == null;
    }

    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
}