import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] x = new int[N];
		for (int i = 0; i < x.length; i++) {
			x[i] = sc.nextInt();
		}
		System.out.printf("%.1f\n", mean(x));
		System.out.printf("%.1f\n", median(x));
		System.out.println(mode(x));

		sc.close();
	}

	static double mean(int[] x) {
		return Arrays.stream(x).average().getAsDouble();
	}

	static double median(int[] x) {
		Arrays.sort(x);

		if (x.length % 2 == 0) {
			return (x[x.length / 2 - 1] + x[x.length / 2]) / 2.0;
		} else {
			return x[(x.length - 1) / 2];
		}
	}

	static int mode(int[] x) {
		Map<Integer, Integer> number2count = new HashMap<Integer, Integer>();
		for (int number : x) {
			number2count.put(number, number2count.getOrDefault(number, 0) + 1);
		}

		int maxCount = -1;
		int result = Integer.MAX_VALUE;
		for (int number : number2count.keySet()) {
			int count = number2count.get(number);
			if (count > maxCount || (count == maxCount && number < result)) {
				maxCount = count;
				result = number;
			}
		}
		return result;
	}
}
