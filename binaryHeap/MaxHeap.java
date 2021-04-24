package binaryHeap;

import java.util.ArrayList;

public class MaxHeap {
    ArrayList<Integer> values = new ArrayList<>();

    public void insert(int data){
        values.add(data);
        bubbleUp();
    }

    public int extractMax(){
        int idx = 0;
        int max = values.get(idx);
        int length = (values.toArray().length);
        int element = values.remove(length - 1);
        if(values.isEmpty()){
            values.set(idx, element);
            sinkDown();
        }
        return max;
    }

    public void print(){
        System.out.print("[");
        for(int i =0; i < ((values.toArray().length) - 1); i++){
            System.out.print(" " + values.get(i) + ",");
        }
        System.out.print(" " + values.get((values.toArray().length) - 1));
        System.out.print("]");
        System.out.println();
    }

    void bubbleUp(){
        int idx = (values.toArray().length) - 1;
        int element = values.get(idx);
        while(idx > 0){
            int parentIdx = (idx - 1)/2;
            int parent = values.get(parentIdx);
            if(element <= parent) break;
            values.set(parentIdx, element);
            values.set(idx, parent);
            idx = parentIdx;
        }
    }

    void sinkDown(){
        int idx = 0;
        int length = values.toArray().length;
        int element = values.get(idx);

        while(true){

            int leftChildIdx = 2 * idx + 1;
            int rightChildIdx = 2 * idx + 2;
            int leftChild, rightChild, swapIdx = 0;
            boolean noSwaps = true;
            leftChild = 0;
            if(leftChildIdx < length){
                leftChild = values.get(leftChildIdx);
                if(leftChild > element){
                    swapIdx = leftChildIdx;
                    noSwaps = false;
                }
            }
            if(rightChildIdx < length){
                rightChild = values.get(rightChildIdx);
                if((noSwaps && rightChild > element) || (!noSwaps && rightChild > leftChild)){
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
}