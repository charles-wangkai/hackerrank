import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static final int MODULUS = 1000000007;

	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solve(A));
	}

	static int solve(int[] A) {
		boolean hasOdd = Arrays.stream(A).anyMatch(x -> x % 2 == 1);
		return addMod(powMod(2, hasOdd ? (A.length - 1) : A.length), -1);
	}

	static int addMod(int x, int y) {
		return ((x + y) % MODULUS + MODULUS) % MODULUS;
	}

	static int multiplyMod(int x, int y) {
		return (int) ((long) x * y % MODULUS);
	}

	static int powMod(int base, int exponent) {
		int result = 1;
		while (exponent != 0) {
			if (exponent % 2 != 0) {
				result = multiplyMod(result, base);
			}

			base = multiplyMod(base, base);
			exponent /= 2;
		}
		return result;
	}
}
