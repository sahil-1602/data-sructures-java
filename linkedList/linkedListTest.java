package linkedList;

public class linkedListTest {

    public static void main(String[] args) throws Exception {
        LinkedList myLL = new LinkedList();
        myLL.push(34);
        myLL.push(38);
        myLL.push(39);

        myLL.print();
        System.out.println();
        myLL.reverse();
        myLL.print();
    }
}