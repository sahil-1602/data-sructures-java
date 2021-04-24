package sortingAlgos;

import java.util.*;

import java.util.Arrays;

public class MergeSort {

	// highly recommended to go through slides to understand this!

	// Break up the array into halves until you have arrays that are empty or have
	// one element
	// Once you have smaller sorted arrays, merge those arrays with other sorted
	// arrays until you are back at the full length of the array
	// Once the array has been merged back together, return the merged (and sorted!)
	// array

	public int counter = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		MergeSort sort = new MergeSort();

		System.out.println("Enter the size of array ");
		int size = sc.nextInt();

		int[] a = new int[size];
		System.out.println("Enter elements of array");
		for (int i = 0; i < size; i++) {
			a[i] = sc.nextInt();
		}

		int[] left = mergeSort(a, sort);

		System.out.println("Sorted array : ");
		for (int items : left) {
			System.out.print(items + " ");
		}

		System.out.println();
		System.out.println("Count = " + sort.counter);
	}

	public static int[] mergeSort(int[] arr, MergeSort sort) {
		if (arr.length <= 1)
			return arr;
		int mid = arr.length / 2;
		int last = arr.length;
		int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid), sort);
		int[] right = mergeSort(Arrays.copyOfRange(arr, mid, last), sort);
		return merge(left, right, sort);
	}

	public static int[] merge(int[] a, int[] b, MergeSort sort) {
		int[] merged = new int[a.length + b.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while ((i < a.length) && (j < b.length) && (k < merged.length)) {
			sort.counter++;
			if (a[i] < b[j]) {
				merged[k] = a[i];
				k++;
				i++;
			} else {
				merged[k] = b[j];
				k++;
				j++;
			}
		}

		while (j < b.length) {
			sort.counter++;
			merged[k] = b[j];
			k++;
			j++;
		}

		while (i < a.length) {
			sort.counter++;
			merged[k] = a[i];
			k++;
			i++;
		}

		return merged;
	}
}
