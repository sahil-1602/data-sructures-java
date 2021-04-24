package recursion;

import java.util.Scanner;

public class PowerQuestion {

	// Write a program that returns power of a number
	// using recursion
	// power(2,4) ------> 16

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string");
		String str = sc.nextLine();
		Exception strException = new Exception("Invalid string");
		try {
			if (!str.toLowerCase().equals("india"))
				throw strException;
			else
				System.out.println("COOL!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("BYE");
	}

	public static int power(int num, int pow) {

		if (pow == 0) {
			return 1;
		}

		return num * power(num, pow - 1);
	}

}
