package recursion;

public class ProductOfArray {

	//Write a function called productOfArray which takes
	//in an array of numbers and returns the product of them all.
	
	//productOfArray([1,2,3])    // 6
	//productOfArray([1,2,3,10]) // 60
	
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,10};
		System.out.println(productOfArray(arr, arr.length - 1));
	}
	
	public static int productOfArray(int [] a, int n) {
		if(n == 0) {
			return a[0];
		}
		
		return a[n] * productOfArray(a,n-1);
	}
}
