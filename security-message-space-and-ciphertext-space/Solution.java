import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String message = sc.next();
		message.chars().map(ch -> ch - '0').map(digit -> (digit + 1) % 10).forEach(System.out::print);

		sc.close();
	}
}
