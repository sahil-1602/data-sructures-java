package sortingAlgos;

public class RadixSort {
	
//	RADIX SORT PSEUDO CODE
//	Define a function that accepts list of numbers
//	Figure out how many digits the largest number has
//	Loop from k = 0 up to this largest number of digits
//	For each iteration of the loop:
//	Create buckets for each digit (0 to 9)
//	place each number in the corresponding bucket based on its kth digit
//	Replace our existing array with values in our buckets, starting with 0 and going up to 9
//	return list at the end!
	
	public static void main(String[] args) {
		
	}
	
	public static int getDigit(int num, int i) {
		return (int)(num/ Math.pow(10, i)) % 10;
	}
	
	public static int digitCount(int num) {
		  if (num == 0) return 1;
		  return (int)(Math.log10(num)) + 1;
	}
	
	public static int mostDigits(int[] nums) {
		  int maxDigits = 0;
		  for (int i = 0; i < nums.length; i++) {
		    maxDigits = Math.max(maxDigits, digitCount(nums[i]));
		  }
		  return maxDigits;
	}

}
