import java.util.ArrayList;
import java.util.List;

class Node {
	int data;
	Node left;
	Node right;
}

public class Solution {
	void LevelOrder(Node root) {
		List<List<Integer>> rows = new ArrayList<List<Integer>>();

		search(rows, root, 0);

		StringBuilder sb = new StringBuilder();
		for (List<Integer> row : rows) {
			for (int data : row) {
				if (sb.length() > 0) {
					sb.append(" ");
				}
				sb.append(data);
			}
		}
		System.out.println(sb);
	}

	void search(List<List<Integer>> rows, Node node, int depth) {
		if (node == null) {
			return;
		}

		if (rows.size() == depth) {
			rows.add(new ArrayList<Integer>());
		}
		rows.get(depth).add(node.data);

		search(rows, node.left, depth + 1);
		search(rows, node.right, depth + 1);
	}
}
