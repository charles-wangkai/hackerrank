import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] sticks = new int[n];
		for (int i = 0; i < sticks.length; i++) {
			sticks[i] = sc.nextInt();
		}

		int[] result = solve(sticks);
		System.out.println(
				result == null ? -1 : Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

		sc.close();
	}

	static int[] solve(int[] sticks) {
		int[] result = null;
		for (int i = 0; i < sticks.length; i++) {
			for (int j = i + 1; j < sticks.length; j++) {
				for (int k = j + 1; k < sticks.length; k++) {
					if (isTriangle(sticks[i], sticks[j], sticks[k])) {
						int[] solution = { sticks[i], sticks[j], sticks[k] };
						Arrays.sort(solution);

						if (result == null || (solution[2] > result[2])
								|| (solution[2] == result[2] && solution[0] > result[0])) {
							result = solution;
						}
					}
				}
			}
		}
		return result;
	}

	static boolean isTriangle(int a, int b, int c) {
		return a + b > c && b + c > a && c + a > b;
	}
}
