import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] list1 = readList(sc);
		int[] list2 = readList(sc);

		System.out.println(solve(list1, list2).stream().map(String::valueOf).collect(Collectors.joining(" ")));

		sc.close();
	}

	static List<Integer> solve(int[] list1, int[] list2) {
		Map<Integer, Integer> numberToCount1 = buildNumberToCount(list1);
		Map<Integer, Integer> numberToCount2 = buildNumberToCount(list2);

		return numberToCount2.keySet().stream()
				.filter(number -> numberToCount2.get(number) > numberToCount1.getOrDefault(number, 0)).sorted()
				.collect(Collectors.toList());
	}

	static int[] readList(Scanner sc) {
		int size = sc.nextInt();
		int[] list = new int[size];
		for (int i = 0; i < list.length; i++) {
			list[i] = sc.nextInt();
		}
		return list;
	}

	static Map<Integer, Integer> buildNumberToCount(int[] list) {
		Map<Integer, Integer> numberToCount = new HashMap<>();
		for (int number : list) {
			numberToCount.put(number, numberToCount.getOrDefault(number, 0) + 1);
		}
		return numberToCount;
	}
}
