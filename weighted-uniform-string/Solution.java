import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		Set<Integer> weights = buildWeights(s);
		int n = sc.nextInt();
		for (int tc = 0; tc < n; tc++) {
			int x = sc.nextInt();
			System.out.println(weights.contains(x) ? "Yes" : "No");
		}

		sc.close();
	}

	static Set<Integer> buildWeights(String s) {
		Set<Integer> weights = new HashSet<Integer>();
		char prev = 0;
		int weight = -1;
		for (char current : s.toCharArray()) {
			if (current != prev) {
				weight = 0;
			}

			weight += current - 'a' + 1;
			weights.add(weight);
			prev = current;
		}
		return weights;
	}
}
