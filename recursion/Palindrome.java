package recursion;

public class Palindrome {

	public static void main(String[] args) {
		String s = "racecar";
		System.out.println(palindrome(s, s.length()-1, 0));
	}
	
	public static boolean palindrome(String str,int n, int s) {
		if(n<s) {
			return true;
		}
		if(str.charAt(s) == str.charAt(n)) {
			return palindrome(str, n-1, s+1);
		} else {
			return false;
		}
	}

}
