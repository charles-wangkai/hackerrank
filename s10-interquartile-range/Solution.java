import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] X = readArray(sc, n);
		int[] F = readArray(sc, n);

		List<Integer> S = new ArrayList<Integer>();
		for (int i = 0; i < X.length; i++) {
			for (int j = 0; j < F[i]; j++) {
				S.add(X[i]);
			}
		}

		Collections.sort(S);

		int lowerBound;
		int upperBound;
		if (S.size() % 2 == 0) {
			lowerBound = S.size() / 2 - 1;
			upperBound = S.size() / 2;
		} else {
			lowerBound = S.size() / 2 - 1;
			upperBound = S.size() / 2 + 1;
		}

		double q1 = computeMedian(S, 0, lowerBound);
		double q3 = computeMedian(S, upperBound, S.size() - 1);

		System.out.printf("%.1f\n", q3 - q1);

		sc.close();
	}

	static int computeMedian(List<Integer> S, int beginIndex, int endIndex) {
		int size = endIndex - beginIndex + 1;
		if (size % 2 == 0) {
			return (S.get(beginIndex + size / 2 - 1) + S.get(beginIndex + size / 2)) / 2;
		} else {
			return S.get(beginIndex + size / 2);
		}
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}
}
