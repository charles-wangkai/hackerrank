import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int m = sc.nextInt();
			int n = sc.nextInt();

			Map<Integer, List<Integer>> cost2indices = new HashMap<Integer, List<Integer>>();
			for (int index = 1; index <= n; index++) {
				int cost = sc.nextInt();
				if (!cost2indices.containsKey(cost)) {
					cost2indices.put(cost, new ArrayList<Integer>());
				}

				cost2indices.get(cost).add(index);
			}

			for (int cost : cost2indices.keySet()) {
				if (cost * 2 == m) {
					List<Integer> indices = cost2indices.get(cost);
					if (indices.size() >= 2) {
						print(indices.get(0), indices.get(1));
						break;
					}
				} else if (cost2indices.containsKey(m - cost)) {
					print(cost2indices.get(cost).get(0), cost2indices.get(m - cost).get(0));
					break;
				}
			}
		}

		sc.close();
	}

	static void print(int index1, int index2) {
		if (index1 > index2) {
			print(index2, index1);
			return;
		}

		System.out.println(index1 + " " + index2);
	}
}
