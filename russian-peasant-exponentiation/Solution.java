import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		StringTokenizer st = new StringTokenizer(line);

		int q = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < q; tc++) {
			line = in.readLine();
			st = new StringTokenizer(line);

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long k = Long.parseLong(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[] result = solve(a, b, k, m);
			System.out.println(result[0] + " " + result[1]);
		}
	}

	static int[] solve(int a, int b, long k, int m) {
		return multiply(new int[] { 1, 0 }, pow(new int[][] { { a, b }, { -b + m, a } }, k, m), m);
	}

	static int[] multiply(int[] x, int[][] y, int modulus) {
		int size = x.length;
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				result[i] = addMod(result[i], multiplyMod(x[j], y[j][i], modulus), modulus);
			}
		}
		return result;
	}

	static int[][] multiply(int[][] x, int[][] y, int modulus) {
		int[][] result = new int[x.length][y[0].length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				for (int k = 0; k < x[0].length; k++) {
					result[i][j] = addMod(result[i][j], multiplyMod(x[i][k], y[k][j], modulus), modulus);
				}
			}
		}
		return result;
	}

	static int[][] pow(int[][] base, long exponent, int modulus) {
		int size = base.length;
		int[][] result = buildEntityMatrix(size);
		while (exponent != 0) {
			if ((exponent & 1) != 0) {
				result = multiply(result, base, modulus);
			}

			base = multiply(base, base, modulus);
			exponent >>= 1;
		}
		return result;
	}

	static int[][] buildEntityMatrix(int size) {
		int[][] result = new int[size][size];
		for (int i = 0; i < size; i++) {
			result[i][i] = 1;
		}
		return result;
	}

	static int multiplyMod(int x, int y, int modulus) {
		return (int) ((long) x * y % modulus);
	}

	static int addMod(int x, int y, int modulus) {
		return (x + y) % modulus;
	}
}
