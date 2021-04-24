package linkedList;

public class LinkedList {

    Node head;
    Node tail;

    public void push(int data) {
        Node toAdd = new Node(data);

        if (isEmpty()) {
            head = toAdd;
            tail = toAdd;
        } else {
            tail.next = toAdd;
            tail = toAdd;
        }
    }

    public int pop() throws Exception {
        Node current = head;

        if (isEmpty()) {
            throw new Exception("cannot remove last element from an empty linked list");
        } else if (current.next == null) {
            Node toRemove = head;
            head = null;
            tail = null;
            return toRemove.data;
        } else {

            while (current.next.next != null) {
                current = current.next;
            }

            tail = current;
            Node toRemove = current.next;
            current.next = null;

            return toRemove.data;
        }
    }

    public int shift() throws Exception {
        Node toRemove = head;
        if (isEmpty()) {
            throw new Exception("Cannot remove first element from an empty Linked list");
        } else if (head.next == null) {
            toRemove = head;
            head = null;
            return toRemove.data;
        } else {
            head = toRemove.next;
            int removed = toRemove.data;
            toRemove = null;
            return removed;
        }
    }

    public void unshift(int data) {
        Node toAdd = new Node(data);
        if (isEmpty()) {
            head = toAdd;
            tail = toAdd;
        } else {
            toAdd.next = head;
            head = toAdd;
        }

    }

    public int get(int index) throws Exception {
        if (index >= 0 || index < length()) {
            Node current = traverse(index);
            return current.data;
        } else {
            throw new Exception("Index out of bound");
        }
    }

    public boolean set(int index, int value){
        if (index >= 0 || index < length()) {
            Node current = traverse(index);
            current.data = value;
            return true;
        } else {
            return false;
        }
    }

    public boolean insert(int index, int value){
        if(index == 0){
            unshift(value);
            return true;
        }
        else if(index == length()){
            push(value);
            return true;
        }
        else if (index >= 0 || index < length()) {
            Node toInsert = new Node(value);
            index = index -1;
            Node current = traverse(index);
            Node temp = current.next;
            current.next = toInsert;
            toInsert.next = temp;
            return true;
        } else {
            return false;
        }
    }

    public int remove(int index) throws Exception{
        if(index == 0){
            return shift();
        }else if(index == length()){
            return pop();
        }else if (index >= 0 || index < length()){
            int prevNode = index - 1;
            Node previousNode = traverse(prevNode);
            Node remove = previousNode.next;
            previousNode.next = previousNode.next.next;

            return remove.data;
        }else{
            throw new Exception("Cannot remove the node from given index. Invalid Index");
        }
    }

    public void reverse(){
        if(isEmpty()){
            return;
        } else {
            Node prev = null;
            while(head != null){
                Node next_node = head.next;
                head.next = prev;
                prev = head;
                head = next_node;
            }
            head = prev;
            while(prev!=null){
                prev = prev.next;
            }
            tail = prev;
        }
    }

    Node traverse(int index){
        Node current = head;
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
        return current;
    }

    boolean isEmpty(){
        return head == null;
    }

    void print() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data +" ");
			temp=temp.next;
		}
    }
    
    public int length(){
        Node current = head;
        int length = 0;
        while(current != null){
            length++;
            current = current.next;
        }
        return length;
    }

    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data   = data;
            next        = null;
        }
    }
}
