import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static int solve(int[] a) {
		Map<Integer, Integer> value2count = new HashMap<Integer, Integer>();
		for (int value : a) {
			if (!value2count.containsKey(value)) {
				value2count.put(value, 0);
			}
			value2count.put(value, value2count.get(value) + 1);
		}
		return a.length - value2count.values().stream().mapToInt(x -> x).max().getAsInt();
	}
}
