package sortingAlgos;

public class BubbleSort {

	//	BUBBLE SORT PSEUDO CODE
//	Start looping from with a variable called i the end of the array towards the beginning
//	Start an inner loop with a variable called j from the beginning until i - 1
//	If arr[j] is greater than arr[j+1], swap those two values!
//	Return the sorted array
	
	public static void main(String[] args) {
		int[] a = {87, 64, 2, 10, 67};
		int[] sortedArray = bubbleSort(a);
		for(int items : sortedArray) {
			System.out.print(items + " ");
		}
	}
	
	public static int[] bubbleSort(int[] array) {
		
//		Start looping from with a variable called i till end
//		of the array towards the beginning
		for(int i=array.length; i>0; i--) {
			boolean noSwaps = true;
//			Start an inner loop with a variable called j from the
//			beginning until i - 1
			for(int j=0; j<(i-1); j++) {
//				If array[j] is greater than array[j+1],
//				swap those two values!
				if(array[j] > array[j+1]) {
					int temp   = array[j+1];
					array[j+1] = array[j];
					array[j]   = temp;
					noSwaps = false;
				}
			}
			if(noSwaps) break;
		}
		return array;
	}

}


