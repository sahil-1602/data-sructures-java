package sortingAlgos;

import java.util.*;

public class QuickSort {

	// Highly recommended to watch video lecture or slides
	public int counter = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		QuickSort sort = new QuickSort();

		System.out.println("Enter the size of array ");
		int size = sc.nextInt();

		int[] a = new int[size];
		System.out.println("Enter elements of array");
		for (int i = 0; i < size; i++) {
			a[i] = sc.nextInt();
		}

		int[] sorted = quickSort(a, 0, a.length - 1, sort);
		for (int item : sorted) {
			System.out.print(item + " ");
		}
		System.out.println();
		System.out.println("Count = " + sort.counter);
	}

	public static int[] quickSort(int[] arr, int left, int right, QuickSort sort) {
		// 1
		if (left < right) {
			int pivotIndex = pivotHelper(arr, left, right, sort);
			// left
			quickSort(arr, left, pivotIndex - 1, sort);
			// right
			quickSort(arr, pivotIndex + 1, right, sort);
		}

		return arr;
	}

	public static int pivotHelper(int[] arr, int start, int end, QuickSort sort) {

		int pivot = arr[start];
		int pivotIndex = start;
		for (int i = start; i <= end; i++) {
			sort.counter++;

			if (pivot > arr[i]) {
				pivotIndex++;
				int temp = arr[pivotIndex];
				arr[pivotIndex] = arr[i];
				arr[i] = temp;

			}

		}

		int temp = arr[pivotIndex];
		arr[pivotIndex] = pivot;
		arr[start] = temp;

		return pivotIndex;
	}

}
