import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println((n % 2 != 0 || (n >= 6 && n <= 20)) ? "Weird" : "Not Weird");

		sc.close();
	}
}
