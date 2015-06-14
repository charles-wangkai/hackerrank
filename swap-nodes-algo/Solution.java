import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		Node[] nodes = new Node[N + 1];
		for (int i = 1; i <= N; i++) {
			nodes[i] = new Node(i);
		}
		for (int i = 1; i <= N; i++) {
			int left = in.nextInt();
			int right = in.nextInt();
			nodes[i].left = (left == -1 ? null : nodes[left]);
			nodes[i].right = (right == -1 ? null : nodes[right]);
		}

		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int K = in.nextInt();
			swap(K, nodes[1], 1);
			printInorder(nodes[1]);
			System.out.println();
		}

		in.close();
	}

	static void swap(int K, Node node, int depth) {
		if (node == null) {
			return;
		}

		swap(K, node.left, depth + 1);
		swap(K, node.right, depth + 1);

		if (depth % K == 0) {
			Node temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
	}

	static void printInorder(Node node) {
		if (node == null) {
			return;
		}

		printInorder(node.left);
		System.out.print(node.value + " ");
		printInorder(node.right);
	}
}

class Node {
	int value;
	Node left;
	Node right;

	Node(int value) {
		this.value = value;
	}
}