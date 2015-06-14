import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		BigInteger prev = new BigInteger(in.next());
		BigInteger current = new BigInteger(in.next());
		int N = in.nextInt();
		for (int i = 0; i < N - 2; i++) {
			BigInteger next = prev.add(current.multiply(current));
			prev = current;
			current = next;
		}
		System.out.println(current);

		in.close();
	}
}
