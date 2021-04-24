package searchingAlgo;

public class NaiveStringSearch {

//	PSEUDO CODE
//	Loop over the longer string
//	Loop over the shorter string
//	If the characters don't match, break out of the inner loop
//	If the characters do match, keep going
//	If you complete the inner loop and find a match, increment the count of matches
//	Return the count
	
	public static void main(String[] args) {
		System.out.println(search("lorie loled","lol"));
	}
	
	public static int search(String main, String substring) {
		
		int count = 0;
//		Loop over the longer string
		for(int i=0; i<main.length(); i++) {
//			Loop over the shorter string
			for(int j=0; j<substring.length(); j++) {
				
//				If the characters don't match, break out
//				of the inner loop
				if(main.charAt(i+j) != substring.charAt(j)) break;
//				If the characters do match, keep going
				
//				If you complete the inner loop and find a match,
//				increment the count of matches
				if(j == substring.length()-1) count++;
		
			}
		}
//		return counter
		return count;
	}

}
