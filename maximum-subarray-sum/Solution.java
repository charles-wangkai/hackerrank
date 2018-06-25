import java.util.Arrays;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int n = sc.nextInt();
			long m = sc.nextLong();
			long[] a = new long[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextLong();
			}

			System.out.println(solve(a, m));
		}

		sc.close();
	}

	static long solve(long[] a, long m) {
		long[] sums = buildSums(a, m);

		long result = Arrays.stream(sums).max().getAsLong();
		NavigableSet<Long> sortedSums = new TreeSet<>();
		for (long sum : sums) {
			Long higher = sortedSums.higher(sum);
			if (higher != null) {
				result = Math.max(result, addMod(sum, -higher, m));
			}

			sortedSums.add(sum);
		}
		return result;
	}

	static long[] buildSums(long[] a, long m) {
		long[] sums = new long[a.length];
		long sum = 0;
		for (int i = 0; i < sums.length; i++) {
			sum = addMod(sum, a[i], m);
			sums[i] = sum;
		}
		return sums;
	}

	static long addMod(long x, long y, long modulus) {
		return ((x + y) % modulus + modulus) % modulus;
	}
}
