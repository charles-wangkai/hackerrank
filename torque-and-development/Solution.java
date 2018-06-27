import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int libCost = sc.nextInt();
			int roadCost = sc.nextInt();

			@SuppressWarnings("unchecked")
			List<Integer>[] adjacentLists = new List[n + 1];
			for (int i = 1; i < adjacentLists.length; i++) {
				adjacentLists[i] = new ArrayList<>();
			}

			for (int i = 0; i < m; i++) {
				int city1 = sc.nextInt();
				int city2 = sc.nextInt();

				adjacentLists[city1].add(city2);
				adjacentLists[city2].add(city1);
			}

			System.out.println(solve(adjacentLists, libCost, roadCost));
		}

		sc.close();
	}

	static long solve(List<Integer>[] adjacentLists, int libCost, int roadCost) {
		long minCost = Long.MAX_VALUE;
		for (int libNum = computeComponentNum(adjacentLists), roadNum = adjacentLists.length - 1
				- libNum; roadNum >= 0; libNum++, roadNum--) {
			minCost = Math.min(minCost, (long) libNum * libCost + (long) roadNum * roadCost);
		}
		return minCost;
	}

	static int computeComponentNum(List<Integer>[] adjacentLists) {
		boolean[] visited = new boolean[adjacentLists.length];
		int componentNum = 0;
		for (int i = 1; i < visited.length; i++) {
			if (!visited[i]) {
				search(adjacentLists, visited, i);
				componentNum++;
			}
		}
		return componentNum;
	}

	static void search(List<Integer>[] adjacentLists, boolean[] visited, int city) {
		if (visited[city]) {
			return;
		}

		visited[city] = true;
		for (int adjacent : adjacentLists[city]) {
			search(adjacentLists, visited, adjacent);
		}
	}
}
