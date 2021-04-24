package recursion;

public class ReverseString {
	
	//Reverse a string using recursion
	
	public static void main(String[] args) {
		String s = "sahil";
		System.out.println(reverse(s,s.length()-1));
	}
	
	public static String reverse(String str, int n) {
		if(n == 0) {
			return str.charAt(0)+"";
		}
		return str.charAt(n)+ reverse(str, n-1);	
	}

}
