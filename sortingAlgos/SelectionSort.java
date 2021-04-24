package sortingAlgos;

import java.util.Scanner;

public class SelectionSort {

	// SELECTION SORT PSEUDE CODE
	// - Store the first element as the smallest value you've seen so far.
	// - Compare this item to the next item in the array until you find a
	// smaller number.
	// - If a smaller number is found, designate that smaller number to
	// be the new "minimum" and continue until the end of the array.
	// - If the "minimum" is not the value (index) you initially began
	// with, swap the two values.
	// - Repeat this with the next element until the array is sorted.

	public int counter = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		SelectionSort sort = new SelectionSort();
		System.out.println("Enter Size");
		int size = sc.nextInt();

		int[] a = new int[size];
		System.out.println("Enter elements");
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}

		int[] sortedArray = selectionSort(a, sort);
		System.out.println("Sorted Array:\n");
		for (int item : sortedArray) {
			System.out.print(item + " ");
		}
		System.out.println("Counter = " + sort.counter);
	}

	public static int[] selectionSort(int[] array, SelectionSort sort) {
		for (int i = 0; i < array.length; i++) {
			sort.counter++;
			int min = i;
			for (int j = i; j < array.length; j++) {
				sort.counter++;
				if (array[j] < array[min]) {
					min = j;
				}
			}
			if (array[min] != array[i]) {
				int temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
		return array;
	}

}
