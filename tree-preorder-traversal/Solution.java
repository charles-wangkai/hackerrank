class Node {
	int data;
	Node left;
	Node right;
}

public class Solution {
	void Preorder(Node root) {
		if (root == null) {
			return;
		}

		System.out.print(root.data + " ");
		Preorder(root.left);
		Preorder(root.right);
	}
}
