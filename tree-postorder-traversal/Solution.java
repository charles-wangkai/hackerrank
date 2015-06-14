class Node {
	int data;
	Node left;
	Node right;
}

public class Solution {
	void Postorder(Node root) {
		if (root == null) {
			return;
		}

		Postorder(root.left);
		Postorder(root.right);
		System.out.print(root.data + " ");
	}
}
