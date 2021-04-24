package queue;

public class Queue {
    
    Node first;
    Node last;

    public void enqueue(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            first = last = newNode;
        } else {
            last.next = newNode;
            last = last.next;
        }
    }

    public int dequeue() throws Exception{
        if(isEmpty()) throw new Exception("Cannot remove from an empty queue");
        else if(first == last){
            int toRemove = first.data;
            first = last = null;
            return toRemove;
        } else {
            int toRemove = first.data;
            first = first.next;
            return toRemove;
        }
    }

    public int length(){
        if(isEmpty()) return 0;
        else{
            int length = 0;
            Node current = first;
            while(current != null){
                length++;
                current = current.next;
            }
            return length;
        }
    }

    public void print(){
        if(isEmpty()) return;
        else{
            Node current = first;
            System.out.println();
            while(current!= null){
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    boolean isEmpty(){
        return first == null;
    }

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
}