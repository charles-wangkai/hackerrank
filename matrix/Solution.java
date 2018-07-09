import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		Road[] roads = new Road[n - 1];
		for (int i = 0; i < roads.length; i++) {
			int city1 = sc.nextInt();
			int city2 = sc.nextInt();
			int time = sc.nextInt();

			roads[i] = new Road(city1, city2, time);
		}
		Set<Integer> machines = new HashSet<>();
		for (int i = 0; i < k; i++) {
			int machine = sc.nextInt();

			machines.add(machine);
		}
		System.out.println(solve(n, roads, machines));

		sc.close();
	}

	static int solve(int n, Road[] roads, Set<Integer> machines) {
		Map<Integer, Integer> cityToParent = new HashMap<>();
		for (int i = 0; i < n; i++) {
			cityToParent.put(i, -1);
		}

		Arrays.sort(roads, (road1, road2) -> Integer.compare(road2.time, road1.time));

		int destroyTotal = 0;
		for (Road road : roads) {
			int root1 = findRoot(cityToParent, road.city1);
			int root2 = findRoot(cityToParent, road.city2);

			if (root1 == root2) {
				continue;
			}

			if (machines.contains(root1)) {
				if (machines.contains(root2)) {
					destroyTotal += road.time;
				} else {
					cityToParent.put(root2, root1);
				}
			} else {
				cityToParent.put(root1, root2);
			}
		}
		return destroyTotal;
	}

	static int findRoot(Map<Integer, Integer> cityToParent, int city) {
		int root = city;
		while (cityToParent.get(root) >= 0) {
			root = cityToParent.get(root);
		}
		return root;
	}
}

class Road {
	int city1;
	int city2;
	int time;

	Road(int city1, int city2, int time) {
		this.city1 = city1;
		this.city2 = city2;
		this.time = time;
	}
}