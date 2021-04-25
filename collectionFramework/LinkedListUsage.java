import java.util.*;

/*

*/

public class LinkedListUsage {
    public static void main(String[] args) {

        LinkedList<String> myLinkedList = new LinkedList<String>();

        myLinkedList.add("A"); // adding to LinkedList
        myLinkedList.add("B");

        myLinkedList.addFirst("C");
        myLinkedList.addLast("D");

        myLinkedList.remove("B");
        myLinkedList.remove(0);
        myLinkedList.removeLast();
        myLinkedList.removeFirst();

        myLinkedList.get(0); // index
    }
}
