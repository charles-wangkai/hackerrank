import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Node[] nodes = new Node[n + 1];
		for (int i = 1; i < nodes.length; i++) {
			nodes[i] = new Node();
		}
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int index1 = sc.nextInt();
			int index2 = sc.nextInt();

			if (index1 >= nodes.length || index2 >= nodes.length) {
				System.out.println(-1);

				sc.close();
				return;
			}

			nodes[index1].adjacents.add(index2);
			nodes[index2].adjacents.add(index1);
		}
		for (int i = 1; i < nodes.length; i++) {
			nodes[i].color = sc.nextInt();
		}
		int targetColor = sc.nextInt();

		System.out.println(solve(nodes, targetColor));

		sc.close();
	}

	static int solve(Node[] nodes, int targetColor) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < nodes.length; i++) {
			if (nodes[i].color == targetColor) {
				nodes[i].source = i;
				nodes[i].distance = 0;

				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int head = queue.poll();

			for (int adjacent : nodes[head].adjacents) {
				if (nodes[adjacent].source != nodes[head].source) {
					if (nodes[adjacent].source > 0) {
						return nodes[adjacent].distance + nodes[head].distance + 1;
					} else {
						nodes[adjacent].source = nodes[head].source;
						nodes[adjacent].distance = nodes[head].distance + 1;

						queue.offer(adjacent);
					}
				}
			}
		}

		return -1;
	}
}

class Node {
	List<Integer> adjacents = new ArrayList<>();
	int color;
	int source = -1;
	int distance = -1;
}