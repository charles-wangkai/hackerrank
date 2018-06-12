import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] A = readArray(sc, n);
		int[] B = readArray(sc, n);
		System.out.println(solve(A, B));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static int solve(int[] A, int[] B) {
		Map<Integer, Integer> numberToCountA = buildNumberToCount(A);
		Map<Integer, Integer> numberToCountB = buildNumberToCount(B);

		int matchNum = 0;
		for (int numberA : numberToCountA.keySet()) {
			matchNum += Math.min(numberToCountA.get(numberA), numberToCountB.getOrDefault(numberA, 0));
		}

		return matchNum == A.length ? (A.length - 1) : (matchNum + 1);
	}

	static Map<Integer, Integer> buildNumberToCount(int[] numbers) {
		Map<Integer, Integer> numberToCount = new HashMap<>();
		for (int number : numbers) {
			numberToCount.put(number, numberToCount.getOrDefault(number, 0) + 1);
		}
		return numberToCount;
	}
}
