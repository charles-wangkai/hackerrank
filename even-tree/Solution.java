import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int evenCountNum;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int M = in.nextInt();
		List<Integer>[] adjacentLists = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			adjacentLists[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			int ui = in.nextInt();
			int vi = in.nextInt();
			adjacentLists[ui].add(vi);
			adjacentLists[vi].add(ui);
		}

		evenCountNum = 0;
		dfs(adjacentLists, new boolean[adjacentLists.length], 1);
		System.out.println(evenCountNum - 1);

		in.close();
	}

	static int dfs(List<Integer>[] adjacentLists, boolean[] visited, int index) {
		visited[index] = true;
		int count = 1;
		for (int adj : adjacentLists[index]) {
			if (!visited[adj]) {
				count += dfs(adjacentLists, visited, adj);
			}
		}
		if (count % 2 == 0) {
			evenCountNum++;
		}
		return count;
	}
}
