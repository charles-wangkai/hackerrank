import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String A = sc.next();

		System.out.println(new StringBuilder(A).reverse().toString().equals(A) ? "Yes" : "No");

		sc.close();
	}
}
