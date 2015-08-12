import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		BigInteger factorial = BigInteger.ONE;
		for (int i = 1; i <= N; i++) {
			factorial = factorial.multiply(new BigInteger(i + ""));
		}
		System.out.println(factorial);

		in.close();
	}
}
