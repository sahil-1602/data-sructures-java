package priorityQueue;

public class Test {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enqueue("Low fever", 5);
        priorityQueue.enqueue("Gunshot", 1);
        priorityQueue.enqueue("Flu", 3);
        priorityQueue.enqueue("High fever", 4);
        priorityQueue.print();

    }
}