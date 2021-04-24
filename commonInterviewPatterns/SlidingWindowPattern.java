package commonInterviewPatterns;


//SLIDING WINDOW
//This pattern involves creating a window which can either be an array
//or number from one position to another
//
//Depending on a certain condition, the window either increases or closes
//(and a new window is created)
//
//Very useful for keeping track of a subset of data in an array/string
//etc.

//An Example
//Write a function called maxSubarraySum which accepts an array
//of integers and a number called n. The function should calculate the
//maximum sum of n consecutive elements in the array.

//maxSubarraySum([1,2,5,2,8,1,5],2) // 10
//maxSubarraySum([1,2,5,2,8,1,5],4) // 17
//maxSubarraySum([4,2,1,6],1) // 6
//maxSubarraySum([4,2,1,6,2],4) // 13
//maxSubarraySum([],4) // null

public class SlidingWindowPattern {

	public static void main(String[] args) {
		int[] a = {1,2,5,2,8,1,5};
		System.out.println(maxSubarraySum(a,4));
	}
	
	public static int maxSubarraySum(int[] arr, int size) {
		
		//handling side cases
		if(arr.length == 0 || size > arr.length) {
			return 0;
		}
		
		//storing sum of first window
		int maxSum = 0;
		for(int i=0; i<size; i++) {
			maxSum+=arr[i];
		}
		System.out.println(maxSum);
		
		//based on sum of first window we calculate next window
		//for more info check video lects
		int tempSum = maxSum;
		for(int i=size; i<(arr.length - size + 1); i++) {
			tempSum = tempSum - arr[i-size] + arr[i];
			System.out.println(tempSum);
			maxSum = Math.max(tempSum, maxSum); 
		}
		
		return maxSum;
	}

}
