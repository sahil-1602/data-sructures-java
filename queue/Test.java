package queue;

public class Test {
    public static void main(String[] args) throws Exception{
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.print();
        System.out.println(queue.length());


    }
}