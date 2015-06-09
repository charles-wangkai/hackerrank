import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[] cells = new int[n];
			for (int i = 0; i < cells.length; i++) {
				cells[i] = in.nextInt();
			}
			System.out.println(canWin(cells, m) ? "YES" : "NO");
		}
		in.close();
	}

	static boolean canWin(int[] cells, int m) {
		boolean[] visited = new boolean[cells.length];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(0);
		while (!queue.isEmpty()) {
			int head = queue.poll();
			if (head >= cells.length) {
				return true;
			}
			if (head >= 0 && !visited[head] && cells[head] == 0) {
				visited[head] = true;
				queue.offer(head - 1);
				queue.offer(head + 1);
				queue.offer(head + m);
			}
		}
		return false;
	}
}
