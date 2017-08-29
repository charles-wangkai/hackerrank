import java.util.ArrayList;
import java.util.List;

// Node is defined as :
class Node {
	int data;
	Node left;
	Node right;
}

public class Solution {
	static Node lca(Node root, int v1, int v2) {
		List<Node> path1 = searchPath(root, v1);
		List<Node> path2 = searchPath(root, v2);

		Node result = null;
		for (int i = 0; i < path1.size() && i < path2.size() && path1.get(i) == path2.get(i); i++) {
			result = path1.get(i);
		}
		return result;
	}

	static List<Node> searchPath(Node root, int value) {
		List<Node> path = new ArrayList<Node>();
		search(root, value, path);
		return path;
	}

	static boolean search(Node node, int value, List<Node> path) {
		if (node == null) {
			return false;
		}

		path.add(node);

		if (node.data == value) {
			return true;
		}

		if (search(node.left, value, path)) {
			return true;
		}
		if (search(node.right, value, path)) {
			return true;
		}

		path.remove(path.size() - 1);
		return false;
	}
}
