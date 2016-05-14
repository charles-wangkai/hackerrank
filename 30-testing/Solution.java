import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
	static final int T = 5;
	static final String[] OUTPUTS = { "YES", "NO", "YES", "NO", "YES" };
	static final int MIN_N = 4;
	static final int MAX_N = 200;
	static final int MIN_K = 3;
	static final int MIN_AI = -1000;
	static final int MAX_AI = 1000;

	static Random random = new Random();

	public static void main(String[] args) {
		System.out.println(T);

		Set<Integer> historyN = new HashSet<Integer>();
		for (int tc = 0; tc < T; tc++) {
			int N;
			do {
				N = generateRandomInt(MIN_N, MAX_N);
			} while (historyN.contains(N));
			historyN.add(N);

			int K = generateRandomInt(MIN_K, N);
			System.out.println(N + " " + K);

			int attendance;
			if (OUTPUTS[tc].equals("YES")) {
				attendance = generateRandomInt(2, K - 1);
			} else {
				attendance = generateRandomInt(K, N - 1);
			}

			List<Integer> a = generateA(N, attendance);
			System.out.println(String.join(" ", a.stream().map(String::valueOf).collect(Collectors.toList())));
		}
	}

	static int generateRandomInt(int min, int max) {
		return random.nextInt(max - min + 1) + min;
	}

	static List<Integer> generateA(int N, int attendance) {
		List<Integer> a = new ArrayList<Integer>();

		a.add(0);
		for (int i = 0; i < attendance - 1; i++) {
			a.add(generateRandomInt(MIN_AI, 0));
		}

		for (int i = 0; i < N - attendance; i++) {
			a.add(generateRandomInt(1, MAX_AI));
		}

		Collections.shuffle(a);

		return a;
	}
}
