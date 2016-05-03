import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String S = sc.next();

		try {
			int intValue = Integer.parseInt(S);
			System.out.println(intValue);
		} catch (NumberFormatException nfe) {
			System.out.println("Bad String");
		}

		sc.close();
	}
}
