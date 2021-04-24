package sortingAlgos;

public class PivotHelper {
	
//	PIVOT PSEUDOCODE
	
//	- It will help to accept three arguments:
//		an array, a start index, and an end index
//		(these can default to 0 and the array length minus 1, respectively)
	
//	- Grab the pivot from the start of the array 
	
//	- Store the current pivot index in a variable
//		(this will keep track of where the pivot should end up)
	
//	- Loop through the array from the start until the end
	
//	- If the pivot is greater than the current element, increment
//		the pivot index variable and then swap the current element
//		with the element at the pivot index
	
//	- Swap the starting element (i.e. the pivot) with the pivot index
	
//	- Return the pivot index

	public static void main(String[] args) {
		int[] a = {4,8,2,1,5,7,6,3};
		System.out.println(pivotHelper(a, 0, 8));
	}
	
	public static int pivotHelper(int[] arr, int start, int end) {
		
		int pivot = arr[start];
		int pivotIndex = start;
		for(int i=start; i < end; i++) {
			
			if(pivot > arr[i]) {
				pivotIndex++;
				int temp 		= arr[pivotIndex];
				arr[pivotIndex] = arr[i];
				arr[i]  		= temp;
				
				System.out.println();
				for(int item : arr) {
					System.out.print(item + " ");
				}
				
			}
			
		}
		
		int temp 		= arr[pivotIndex];
		arr[pivotIndex] = pivot;
		arr[start] 		= temp;
		
		System.out.println();
		for(int item : arr) {
			System.out.print(item + " ");
		}
		
		return pivotIndex;
	}

}
