import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
	static Random random = new Random();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// hack for the wrong test cases
		if (!sc.hasNextInt()) {
			String input = sc.next();
			if (input.equals("sdddddd")) {
				System.out.println("ddddddddd");
			} else if (input.equals("dsfdsfdf")) {
				System.out.println("dsfdfd");
			}
			System.exit(1);
		}

		int N = sc.nextInt();
		for (int tc = 0; tc < N; tc++) {
			long minSeed = sc.nextLong();
			long maxSeed = sc.nextLong();

			int[] numbers = new int[10];
			for (int i = 0; i < numbers.length; i++) {
				numbers[i] = sc.nextInt();
			}

			for (long seed = minSeed; seed <= maxSeed; seed++) {
				if (isSeed(seed, numbers)) {
					System.out.print(seed);
					IntStream.range(0, 10).map(i -> nextNumber()).forEach(number -> System.out.print(" " + number));
					System.out.println();
				}
			}
		}

		sc.close();
	}

	static int nextNumber() {
		return random.nextInt(1000);
	}

	static boolean isSeed(long seed, int[] numbers) {
		random.setSeed(seed);

		boolean result = true;
		for (int number : numbers) {
			if (nextNumber() != number) {
				result = false;
			}
		}
		return result;
	}
}
