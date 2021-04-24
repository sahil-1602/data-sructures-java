package commonInterviewPatterns;

public class TwoPointerPattern {

	public static void main(String[] args) {
//		int[] a = {-4, -3, -1, 0, 2, 5, 7};
//		sumZero(a);
		
		int[] b = {-3, -2, -2, -1, 0, 0, 6, 7, 8, 8};
		System.out.println(uniqueNo(b));
		
	}
	
	
	//This function returns a pair of value that sums to zero in
	// sorted array in O(n) time complexity
	public static boolean sumZero(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		
		while(left<right) {
			int sum = arr[left] + arr[right];
			if(sum==0) {
				System.out.println("("+arr[left]+","+arr[right]+")");
				return true;
			} else if (sum>0) {
				right--;
			} else {
				left++;
			}
		}
		System.out.println("There is no pair that sums to zero");
		return false;
	}
	
	//this function returns no. of unique values in a sorted array
	//approach
	//   i
	//  -3,-2,-2,-1,0,0,6,7,8,8  (ans = 7)
	//      j
	// we will loop through and check is i==j and if yes move j forward
	// and if they are not equal move i forward and i position will be
	// assigned value of j so at the end we will be left with an array:
	// -3,-2,-1,0,6,7,8,8
	//                i j   so index of i is 6 and adding 1 gives no. of unique values

	public static int uniqueNo(int[] arr) {
		int i = 0;
		int j = 1;
		while(j < arr.length && i < arr.length) {
			if(arr[i] == arr[j]) {
				j++;
			} else {
				i++;
				arr[i] = arr[j];
				j++;
			}
		}
		for(int val : arr) {
			System.out.print(val+" ");
		}
		System.out.println();
		return i+1;
	}
	
}
