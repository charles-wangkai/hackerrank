import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int[] A = new int[N];
			for (int i = 0; i < A.length; i++) {
				A[i] = sc.nextInt();
			}

			System.out.println(
					String.join(" ", Arrays.stream(solve(A)).mapToObj(String::valueOf).collect(Collectors.toList())));
		}

		sc.close();
	}

	static int[] solve(int[] A) {
		int[] B = new int[A.length + 1];

		B[0] = 1;
		for (int i = 0; i < A.length; i++) {
			int g = gcd(B[i], A[i]);
			B[i] *= A[i] / g;

			B[i + 1] = A[i];
		}

		return B;
	}

	static int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, a % b);
	}
}
