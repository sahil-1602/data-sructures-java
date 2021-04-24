package sortingAlgos;

import java.util.Scanner;

public class InsertionSort {

	// INSERTION SORT PSEUDO CODE
	// - Start by picking the second element in the array

	// - Now compare the second element with the one before it and
	// swap if necessary.

	// - Continue to the next element and if it is in the incorrect
	// order, iterate through the sorted portion (i.e. the left side)
	// to place the element in the correct place.

	// - Repeat until the array is sorted.

	public int counter = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		InsertionSort sort = new InsertionSort();

		System.out.println("Enter Size");
		int size = sc.nextInt();

		int[] a = new int[size];
		System.out.println("Enter elements");
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}

		System.out.println("Sorted Array:\n");
		int[] sortedArray = insertionSort(a, sort);
		for (int item : sortedArray) {
			System.out.print(item + " ");
		}
		System.out.println("Counter = " + sort.counter);
	}

	// Go and watch video explaining this!
	public static int[] insertionSort(int[] array, InsertionSort sort) {
		for (int i = 1; i < array.length; i++) {
			sort.counter++;
			int currentval = array[i];
			int j;
			for (j = i - 1; (j >= 0) && (array[j] > currentval); j--) {
				sort.counter++;
				array[j + 1] = array[j];
			}
			array[j + 1] = currentval;
		}
		return array;
	}

}
