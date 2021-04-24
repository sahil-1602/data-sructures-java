package searchingAlgo;

//BINARY SEARCH PSEUDO CODE
// -This function accepts a sorted array and a value
// -Create a left pointer at the start of the array, and a right pointer at the end of the array
// -While the left pointer comes before the right pointer:
//	 -Create a pointer in the middle
//	 -If you find the value you want, return the index
//	 -If the value is too small, move the left pointer up
//	 -If the value is too large, move the right pointer down
// -If you never find the value, return -1

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 6, 98, 100};
		System.out.println(binarySearch(arr, 99));
	}
	
	// -This function accepts a sorted array and a value
	public static int binarySearch(int[] a, int val) {
		
		// -Create a left pointer at the start of the array
		//and a right pointer at the end of the array
		int left = 0;
		int right = a.length -1;
		
		// -While the left pointer comes before the right pointer:
		while(left<=right) {
			
			//-Create a pointer in the middle
			int middle = (left + right)/2;
			
			//-If you find the value you want, return the index
			if(a[middle] == val) {
				return middle;
			} else if(a[middle]>val) {
				//-If the value is too large, move the right pointer down
				right--;
			} else {
				//-If the value is too small, move the left pointer up
				left++;
			}
		}
		// -If you never find the value, return -1
		return -1;
	}

}
