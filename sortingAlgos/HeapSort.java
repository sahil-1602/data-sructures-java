package sortingAlgos;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = { 1, 9, 30, 6, 23 };
        heapsort(arr);
        printArray(arr);
    }

    public static void heapsort(int[] arr) {
        int size = arr.length;

        // Building heap (rearranging array)
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(arr, i, size);
        }

        // one by one extract the element from the heap
        for (int i = (size - 1); i > 0; i--) {

            // swapping the root(largest) to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call maxheap to the reduced heap
            heapify(arr, 0, i);
        }
    }

    public static void heapify(int[] arr, int curr, int size) {
        int largestIdx = curr;
        int leftIdx = 2 * curr + 1; // left child idx
        int rightIdx = 2 * curr + 2;// rightIdx child idx

        // we are checking if left exists and if it does
        // we see that is it greater than our root or largest till now
        if (leftIdx < size && arr[largestIdx] < arr[leftIdx]) {
            // updating largestIdx
            largestIdx = leftIdx;
        }

        // we are checking if the right exists and if it does we see
        // that is it greater than or largest till now
        if (rightIdx < size && arr[largestIdx] < arr[rightIdx]) {
            // updating largestIdx
            largestIdx = rightIdx;
        }

        // If the largest is root than its in it correct spot
        // so no need to swap, so we check here is it same or not
        if (largestIdx != curr) {
            // swapping the root with the largest
            int temp = arr[curr];
            arr[curr] = arr[largestIdx];
            arr[largestIdx] = temp;

            // calling heapify again on the updated root
            heapify(arr, curr, size);
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}