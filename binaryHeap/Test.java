package binaryHeap;

public class Test {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(41); //39 33 18 27 12 55
        maxHeap.insert(39);
        maxHeap.insert(33);
        maxHeap.insert(18);
        maxHeap.insert(27);
        maxHeap.insert(12);
        maxHeap.insert(55);

        maxHeap.print();
    }
}