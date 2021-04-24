package doublyLinkedList;

public class test {
    public static void main(String[] args) throws Exception {
        DoublyLinkedList mydll = new DoublyLinkedList();
        mydll.push(2);
        mydll.push(3);
        mydll.push(6);
        mydll.print();
        System.out.println(mydll.remove(1));
        mydll.print();
    }
}