import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String message = sc.next();
		int e = sc.nextInt();
		message.chars().map(ch -> ch - '0').map(digit -> (digit + e) % 10).forEach(System.out::print);

		sc.close();
	}
}
