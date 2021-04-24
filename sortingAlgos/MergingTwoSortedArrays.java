package sortingAlgos;

public class MergingTwoSortedArrays {

//	- Create an empty array, take a look at the smallest values
//		in each input array
	
//	- While there are still values we haven't looked at...
//		- If the value in the first array is smaller than the value
//			in the second array, push the value in the
//			first array into our results and move on to
//			the next value in the first array
	
//		- If the value in the first array is larger than the value
//			in the second array, push the value in the second array
//			into our results and move on to the next value in the
//			second array
	
//		- Once we exhaust one array, push in all remaining values
//			the other array
	
	public static void main(String[] args) {
		int[] a1 = {2,4,7,12,100};
		int[] a2 = {1,3,8,9};
		int[] sorted = mergeSorted(a1, a2);
		for(int items : sorted) {
			System.out.print(items + " ");
		}
	}
	
	public static int[] mergeSorted(int[] a, int[] b) {
		int[] merged = new int[a.length + b.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while((i < a.length) && (j < b.length) && (k < merged.length)) {
			if(a[i] < b[j]) {
				merged[k] = a[i];
				k++;
				i++;
			}else{
				merged[k] = b[j];
				k++;
				j++;
			}
		}
		
		while(j<b.length) {
			merged[k] = b[j];
			k++;
			j++;
		}
		
		while(i<a.length) {
			merged[k] = a[i];
			k++;
			i++;
		}
		
		return merged;
	}

}
