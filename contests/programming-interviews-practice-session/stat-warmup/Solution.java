import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	static final double CONFIDENCE_INTERVAL_CONSTANT = 1.96;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int[] numbers = new int[N];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = in.nextInt();
		}

		System.out.printf("%.1f\n", mean(numbers));
		System.out.printf("%.1f\n", median(numbers));
		System.out.printf("%d\n", mode(numbers));
		System.out.printf("%.1f\n", standardDeviation(numbers));

		double[] boundaries = confidenceInterval(numbers);
		System.out.printf("%.1f %.1f\n", boundaries[0], boundaries[1]);

		in.close();
	}

	static double mean(int[] numbers) {
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}
		return (double) sum / numbers.length;
	}

	static double median(int[] numbers) {
		Arrays.sort(numbers);
		if (numbers.length % 2 == 0) {
			return (numbers[numbers.length / 2 - 1] + numbers[numbers.length / 2]) / 2.0;
		} else {
			return numbers[numbers.length / 2];
		}
	}

	static int mode(int[] numbers) {
		Map<Integer, Integer> number2count = new HashMap<Integer, Integer>();
		for (int number : numbers) {
			if (!number2count.containsKey(number)) {
				number2count.put(number, 0);
			}
			number2count.put(number, number2count.get(number) + 1);
		}

		int maxCount = number2count.values().stream().mapToInt(x -> x).max()
				.getAsInt();
		return number2count.keySet().stream()
				.filter(number -> number2count.get(number) == maxCount)
				.mapToInt(x -> x).min().getAsInt();
	}

	static double standardDeviation(int[] numbers) {
		double avg = mean(numbers);
		double temp = 0;
		for (int number : numbers) {
			double diff = number - avg;
			temp += diff * diff;
		}
		return Math.sqrt(temp / numbers.length);
	}

	static double[] confidenceInterval(int[] numbers) {
		double avg = mean(numbers);
		double sd = standardDeviation(numbers);
		return new double[] {
				avg - CONFIDENCE_INTERVAL_CONSTANT * sd
						/ Math.sqrt(numbers.length),
				avg + CONFIDENCE_INTERVAL_CONSTANT * sd
						/ Math.sqrt(numbers.length) };
	}
}
