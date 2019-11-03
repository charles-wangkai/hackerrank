import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int lena = sc.nextInt();
		int lenb = sc.nextInt();
		int lenc = sc.nextInt();
		int[] a = readArray(sc, lena);
		int[] b = readArray(sc, lenb);
		int[] c = readArray(sc, lenc);

		System.out.println(solve(a, b, c));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static long solve(int[] a, int[] b, int[] c) {
		int[] sortedSetA = buildSortedSet(a);
		int[] sortedSetB = buildSortedSet(b);
		int[] sortedSetC = buildSortedSet(c);

		long result = 0;
		for (int numberB : sortedSetB) {
			result += (long) findBeforeCount(sortedSetA, numberB) * findBeforeCount(sortedSetC, numberB);
		}
		return result;
	}

	static int findBeforeCount(int[] x, int number) {
		int index = Arrays.binarySearch(x, number);
		if (index < 0) {
			index = -1 - index - 1;
		}
		return index + 1;
	}

	static int[] buildSortedSet(int[] x) {
		return Arrays.stream(x).distinct().sorted().toArray();
	}
}
