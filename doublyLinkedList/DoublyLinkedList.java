package doublyLinkedList;


public class DoublyLinkedList {
    
    Node head;
    Node tail;

    public void push(int data){
        Node toAdd = new Node(data);
        if(isEmpty()){
            head = toAdd;
            tail = head;
            return;
        } else {
            tail.next = toAdd;
            tail.next.prev = tail;
            tail = tail.next;
        }
    }

    public int pop() throws Exception{
        Node toRemove = tail;
        if(isEmpty()) throw new Exception("Cannot pop from an empty list");
        else if(head == tail){
            head = tail = null;
            return toRemove.data;
        } else {
            tail = tail.prev;
            tail.next = null;
            toRemove.prev = null;
            return toRemove.data;
        }
    }

    public int shift() throws Exception{
        Node toRemove = head;
        if(isEmpty()) throw new Exception("Cannot remove from an empty Linked List");
        else if(head == tail){
            head = tail = null;
        }else{
            head = head.next;
            head.prev = null;
            toRemove.next = null;
        }
        return toRemove.data;
    }

    public void unshift(int data){
        Node toAdd = new Node(data);
        if(isEmpty()){
            head = tail = toAdd;
        }else{
            toAdd.next = head;
            head.prev = toAdd;
            head = toAdd;
        }

    }

    public int get(int index) throws Exception {
        Node current = getNode(index);
        return current.data;
    }

    public boolean set(int index, int value) throws Exception{
        Node current = getNode(index);
        current.data = value;
        return true;
    }

    public void insert(int index, int value) throws Exception{
        if(index == 0) unshift(value);
        else if(index == length()) push(value);
        else{
            Node toInsert = new Node(value);
            Node current = getNode(index);
            Node temp = current;
            current = current.prev;
            current.next = toInsert;
            toInsert.prev = current;
            temp.prev = toInsert;
            toInsert.next = temp;
        }
    }

    public int remove(int index) throws Exception {
        if(index == 0) return shift();
        else if( index == (length()-1) ) return pop();
        else{
            Node toRemove = getNode(index);
            toRemove.prev.next = toRemove.next;
            toRemove.next.prev = toRemove.prev;
            toRemove.next = null;
            toRemove.prev = null;
            return toRemove.data;
        }
    }

    Node traverseFromHead(int index){
        Node current = head;
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
        return current;
    }

    Node traverseFromTail(int index, int length){
        Node current = tail;
        int i = 0;
        while (i < (length - index - 1)) {
            current = current.prev;
            i++;
        }
        return current;
    }

    Node getNode(int index) throws Exception{
        int length = length();
        Node current = null;
        if (index >= 0 || index < length) {
            if(index <= (length/2)){
                current = traverseFromHead(index);
            } else {
                current = traverseFromTail(index, length);
            }
            return current;
        } else throw new Exception("Index out of");
    }

    public void print(){
        Node current = head;
        while(current!=null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
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

    boolean isEmpty(){
        return head == null;
    }

    class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}