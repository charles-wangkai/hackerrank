import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static final int LIMIT = 500;
	static final int[] DIGITS = { 0, 9 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			System.out.println(solve(N));
		}

		sc.close();
	}

	static BigInteger solve(int N) {
		boolean[] visited = new boolean[N];

		Queue<BigInteger> queue = new LinkedList<BigInteger>();
		queue.offer(BigInteger.valueOf(DIGITS[0]));
		while (true) {
			BigInteger head = queue.poll();

			for (int digit : DIGITS) {
				if (head.equals(BigInteger.ZERO) && digit == 0) {
					continue;
				}

				BigInteger next = head.multiply(BigInteger.TEN).add(BigInteger.valueOf(digit));

				int remainder = next.mod(BigInteger.valueOf(N)).intValue();
				if (remainder == 0) {
					return next;
				} else if (!visited[remainder]) {
					visited[remainder] = true;
					queue.offer(next);
				}
			}
		}
	}
}
