import java.util.Scanner;

public class Solution {
	static final int MODULUS = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int N = sc.nextInt();
			System.out.println(solve(A, B, N));
		}

		sc.close();
	}

	static int solve(int A, int B, int N) {
		int[] state = { A, B };

		int[][] transitionMatrix = { { 0, 1 }, { 1, 1 } };

		state = multiplyMod(state, powMod(transitionMatrix, N));
		return state[0];
	}

	static int[][] powMod(int[][] base, int exponent) {
		int size = base.length;
		int[][] result = buildEntityMatrix(size);
		while (exponent != 0) {
			if ((exponent & 1) != 0) {
				result = multiplyMod(result, base);
			}

			base = multiplyMod(base, base);
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

	static int[][] multiplyMod(int[][] matrix1, int[][] matrix2) {
		int size = matrix1.length;
		int[][] result = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					result[i][j] = addMod(result[i][j], multiplyMod(matrix1[i][k], matrix2[k][j]));
				}
			}
		}
		return result;
	}

	static int[] multiplyMod(int[] vector, int[][] matrix) {
		int size = vector.length;
		int[] result = new int[size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				result[i] = addMod(result[i], multiplyMod(vector[j], matrix[j][i]));
			}
		}
		return result;
	}

	static int addMod(int x, int y) {
		return (x + y) % MODULUS;
	}

	static int multiplyMod(int x, int y) {
		return (int) ((long) x * y % MODULUS);
	}
}
