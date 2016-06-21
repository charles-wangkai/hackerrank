import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
	private static final int CERTAINTY = 100;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BigInteger n = sc.nextBigInteger();
		System.out.println(n.isProbablePrime(CERTAINTY) ? "prime" : "not prime");

		sc.close();
	}
}
