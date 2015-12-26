
// http://dongxicheng.org/structure/suffix-array/

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static final int BASE = 300000;
	static final char SEPARATOR = (char) ('Z' + 1);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			String A = sc.next();
			String B = sc.next();
			System.out.println(solve(A, B));
		}

		sc.close();
	}

	static String solve(String A, String B) {
		String combined = A + SEPARATOR + B + SEPARATOR;
		int[] ranks = computeRanks(combined);

		StringBuilder result = new StringBuilder();
		int indexA = 0;
		int indexB = 0;
		for (int i = 0; i < A.length() + B.length(); i++) {
			if (shouldChooseFromFirst(A, indexA, B, indexB, ranks)) {
				result.append(A.charAt(indexA));
				indexA++;
			} else {
				result.append(B.charAt(indexB));
				indexB++;
			}
		}
		return result.toString();
	}

	static int[] computeRanks(String str) {
		int[] ranks = new int[str.length()];
		for (int i = 0; i < ranks.length; i++) {
			ranks[i] = str.charAt(i);
		}

		long[] keyAndIndexArray = new long[ranks.length];
		for (int length = 2; length < ranks.length; length *= 2) {
			for (int i = 0; i < keyAndIndexArray.length; i++) {
				int key1 = ranks[i];

				int nextIndex = i + length / 2;
				int key2 = (nextIndex < ranks.length) ? ranks[nextIndex] : 0;

				keyAndIndexArray[i] = generateKeyAndIndex(key1, key2, i);
			}

			Arrays.sort(keyAndIndexArray);

			int rank = 0;
			for (int i = 0; i < keyAndIndexArray.length; i++) {
				if (!(i > 0 && retrieveKey(keyAndIndexArray[i]) == retrieveKey(keyAndIndexArray[i - 1]))) {
					rank++;
				}

				ranks[retrieveIndex(keyAndIndexArray[i])] = rank;
			}
		}
		return ranks;
	}

	static int retrieveKey(long keyAndIndex) {
		return (int) (keyAndIndex / BASE);
	}

	static int retrieveIndex(long keyAndIndex) {
		return (int) (keyAndIndex % BASE);
	}

	static long generateKeyAndIndex(int key1, int key2, int index) {
		return (long) key1 * BASE * BASE + (long) key2 * BASE + index;
	}

	static boolean shouldChooseFromFirst(String A, int indexA, String B, int indexB, int[] ranks) {
		return indexB == B.length() || (indexA < A.length() && ranks[indexA] < ranks[indexB + 1 + A.length()]);
	}
}
