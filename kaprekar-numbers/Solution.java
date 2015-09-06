import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int p = in.nextInt();
		int q = in.nextInt();
		List<Integer> result = IntStream
				.rangeClosed(p, q)
				.filter(Solution::isKaprekar)
				.collect(ArrayList<Integer>::new, List<Integer>::add,
						List<Integer>::addAll);
		if (result.isEmpty()) {
			System.out.println("INVALID RANGE");
		} else {
			System.out.println(String.join(" ", result.stream()
					.map(x -> x + "").collect(Collectors.toList())));
		}

		in.close();
	}

	static boolean isKaprekar(int number) {
		long square = (long) number * number;
		String squareStr = square + "";
		int leftLength = squareStr.length() / 2;
		return Integer.parseInt("0" + squareStr.substring(0, leftLength))
				+ Integer.parseInt(squareStr.substring(leftLength)) == number;
	}
}
