package priorityQueue;

import java.util.ArrayList;

public class PriorityQueue {

    ArrayList<Node> values = new ArrayList<Node>();

    public void enqueue(String val, int priority){
        Node toAdd = new Node(val, priority);
        values.add(toAdd);
        bubbleUp();
    }

    public String dequeue(){
        int idx = 0;
        String min = values.get(idx).val;
        int length = (values.toArray().length);
        Node element = values.remove(length - 1);
        if(values.isEmpty()){
            values.set(idx, element);
            sinkDown();
        }
        return min;
    }

    public void print(){
        System.out.print("[");
        for(int i =0; i < ((values.toArray().length) - 1); i++){
            System.out.print(" " + values.get(i).val + ",");
        }
        System.out.print(" " + values.get((values.toArray().length) - 1).val);
        System.out.print("]");
        System.out.println();
    }

    void bubbleUp(){
        int idx = (values.toArray().length) - 1;
        Node element = values.get(idx);
        while(idx > 0){
            int parentIdx = (idx - 1)/2;
            Node parent = values.get(parentIdx);
            if(element.priority >= parent.priority) break;
            values.set(parentIdx, element);
            values.set(idx, parent);
            idx = parentIdx;
        }
    }

    void sinkDown(){
        int idx = 0;
        int length = values.toArray().length;
        Node element = values.get(idx);

        while(true){

            int leftChildIdx = 2 * idx + 1;
            int rightChildIdx = 2 * idx + 2;
            Node leftChild, rightChild;
            int swapIdx = 0;
            boolean noSwaps = true;
            leftChild = null;
            if(leftChildIdx < length){
                leftChild = values.get(leftChildIdx);
                if(leftChild.priority < element.priority){
                    swapIdx = leftChildIdx;
                    noSwaps = false;
                }
            }
            if(rightChildIdx < length){
                rightChild = values.get(rightChildIdx);
                if((noSwaps && rightChild.priority < element.priority) || (!noSwaps && rightChild.priority < leftChild.priority)){
                    swapIdx = rightChildIdx;
                    noSwaps = false;
                }
            }

            if(noSwaps) break;
            values.set(idx, values.get(swapIdx));
            values.set(swapIdx,element);
            idx = swapIdx;
        }
    }

    class Node{
        String val;
        int priority;
        Node(String val, int priority){
            this.val = val;
            this.priority = priority;
        }
    }
}