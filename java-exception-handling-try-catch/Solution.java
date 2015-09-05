import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int x = in.nextInt();
			int y = in.nextInt();
			System.out.println(x / y);
		} catch (Throwable t) {
			System.out.println(t.getClass().getName()
					+ ((t instanceof ArithmeticException) ? (": " + t
							.getMessage()) : ""));
		}
	}
}
