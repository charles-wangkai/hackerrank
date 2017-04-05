import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int s = sc.nextInt();
		int t = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[] apples = readArray(sc, m);
		int[] oranges = readArray(sc, n);
		int[] fallOns = solve(s, t, a, b, apples, oranges);
		System.out.println(fallOns[0]);
		System.out.println(fallOns[1]);

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static int[] solve(int s, int t, int a, int b, int[] apples, int[] oranges) {
		return new int[] { countFallOn(Arrays.stream(apples).map(apple -> a + apple), s, t),
				countFallOn(Arrays.stream(oranges).map(orange -> b + orange), s, t) };
	}

	static int countFallOn(IntStream locations, int s, int t) {
		return (int) locations.filter(location -> location >= s && location <= t).count();
	}
}
