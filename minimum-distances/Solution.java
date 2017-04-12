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
		int minDistance = Integer.MAX_VALUE;
		Map<Integer, Integer> value2lastIndex = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			if (value2lastIndex.containsKey(a[i])) {
				minDistance = Math.min(minDistance, i - value2lastIndex.get(a[i]));
			}

			value2lastIndex.put(a[i], i);
		}

		return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
	}
}
